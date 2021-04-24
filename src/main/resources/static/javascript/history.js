$(function () {
    let $history = $('#history');

    initPage();
    async function initPage(){
        let orders = await getOrders();
        orders.forEach((order)=>{
            console.log(order.id);
            addOrder(order, order.id)
            addCustomer(order.customerId, order.id)
            addOrderDeleteButton(order.id);
        })
        listenToOrderDeleteButtons();
    }
function listenToOrderDeleteButtons(){
    $history.on('click', '.order-delete-button', function () {
        let orderId = $(this).attr('id');
        $.ajax({
            type: 'DELETE',
            url: '/api/orders/' + orderId,
            success: function () {
                $(`#${orderId}`).remove();
                $(this).html('');
            }
        });

    });
    }
    async function getOrders(){
        let orders = [];
        await $.ajax({
            "type": 'GET',
            "url": 'api/orders/',
            "success": function (ordersFromDb) {
                orders = ordersFromDb;
            },
            "error": function () {
                alert("No orders found.");
            }
        })
        return orders;
    }
    async function addOrder(order, id) {
        $history.append(`
        <div id="${id}">
            <p>Ordernummer: ${order.id} <br>Datum: ${order.finalisedByDate}</p>
        </div>`
        )
    }
    function addOrderDeleteButton(orderId){
        $(`#${orderId}`).append(`
        <div id="${orderId}">
            <button type="submit" id="${orderId}" class="order-delete-button">Ta bort order</button>
        </div>`)
    }

    async function addCustomer(customerId, id) {
         let customer = await getCustomer(customerId);
            $(`#${id}>p`).after(`<p>${customer.name} ${customer.email}</p>
            `)
    }

    async function getCustomer(customerId) {
        let customer;
        await $.ajax({
            "type": 'GET',
            "url": 'api/customers/',
            "success": function (customers) {
                $.each(customers, function (i, tmpCustomer) {
                    if (tmpCustomer.id === customerId) customer = tmpCustomer;
                })
            },
            "error": function () {
                alert("No customers with that id found.");
            }
        })
        return customer;
    }
function getOrderLines(){
    $.ajax({
        "type": 'GET',
        "url": 'api/orderLines/',
        "success": function (orderLines) {
            $.each(orders, function (i, order) {
                addOrder(order);
            })
        },
        "error": function () {
            alert("No products found.");
        }
    })
}
    function addOrderlines(orderId) {
       let orderLine = getOrderLine();
    }

})