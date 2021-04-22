$(function () {
    let $order = $('#order');

    $('#finalise').on('click', () => {
         registerData().then(()=>{
             localStorage.removeItem("cart")
         });

    })
    async function registerData(){
        let customerId = await getCurrentCustomer();

        let productDictionary = await getProductDictionary();
        let orderId = await buildOrder(customerId, Date());
        JSON.parse(localStorage.getItem("cart")).forEach((cartItem)=>{
            let price = productDictionary[parseInt(cartItem.id)].price;
            buildOrderLines(
                parseInt(orderId),
                parseInt(cartItem.id),
                parseInt(cartItem.amount),
                (cartItem.amount*parseInt(price)).toString())
        })
        $order.html(`<div>
<h4> Tack för beställningen. Välkommen in för att hämta din färdigplockade matkasse!</h4> 
</div>`)

    }
    async function getProductDictionary(){
        let productsDictionary = {};
        await $.ajax({
            "type": 'GET',
            "url": 'api/products/',
            "success": function (products) {
                console.log('success', products);
                $.each(products, function (i, product) {
                    productsDictionary[product.id] = product;
                })

            },
            "error": function () {
                alert("No products found.");
            }
        })
        return productsDictionary;
    }
    function buildOrderLines(orderId, productId, amount, price){
        let orderLine={
            "orderId" : orderId,
            "productId" : productId,
            "amount" : amount,
            "price" :  price
        }
        $.ajax({
            type: 'POST',
            url: 'api/orderLines/',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify(orderLine),
            success:  function () {
                console.log(orderLine + ' registered in db.')
            },
            error: function () {
            }
        });
    }

    async function getCurrentCustomer(){
        let id;
         await $.ajax({
            "type": 'GET',
            "url": 'api/customers/',
            "success":  (customers)=> {
                 $.each(customers, (i, customer) => {
                if(customer.email == $('#email').val()){
                    id = customer.id;
                    return;
                }})
            },
            "error": function () {
            }
        })
        if(id == undefined){
            await buildCustomer();
            return getCurrentCustomer()};//TODO OBS kan fastna i loop vid fel
        return id;
    }
    async function buildCustomer(){
        let customer = {
            "name":$('#name').val(),
            "email":$('#email').val(),
            "phoneNumber":$('#phoneNumber').val()
        }
        await $.ajax({
            type: 'POST',
            url: 'api/customers/',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify(customer),
            success:  function () {
                console.log(customer + ' registered in db.')
            },
            error: function () {

            }
        });
    }
    async function buildOrder(customerId, date){
        let order = {
            "customerId" : customerId,
            "finalisedByDate" : date
        }
        await $.ajax({
            type: 'POST',
            url: 'api/orders/',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            data: JSON.stringify(order),
            success: console.log(order + ' registered in db.'),
            error: function () {
                alert('Det gick inte att spara ner din order.');
            }
        });
        let orderId;
        await $.ajax({
            "type": 'GET',
            "url": 'api/orders/',
            "success":  (orders)=> {
                $.each(orders, (i, order) => {
                    if(order.customerId === customerId && order.finalisedByDate === date){
                        orderId = order.id;
                    }})
            },
            "error": function () {

            }
        })
        return orderId;
    }
})