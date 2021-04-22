$(function () {
    let $history = $('#history');
    $.ajax({
        "type": 'GET',
        "url": 'api/orders/',
        "success": function (orders) {
            console.log('success', orders);
            $.each(orders,  function (i, order) {
                 addOrder(order, i)
                    console.log("CustomerId: " + order.customerId);
                     addCustomer(order.customerId, i);
            })
        },
        "error": function () {
            alert("No orders found.");
        }
    })

    async function addOrder(order, id) {
        $history.append(`
        <div id="${id}">
    <p>Ordernummer: ${order.id} <br>Datum: ${order.finalisedByDate}</p>
        </div>`
        )
    }

    async function addCustomer(customerId, id) {

         let customer = await getCustomer(customerId);
            $(`#${id}`).append(`
            <p>     -${customer.name} ${customer.email}</p><br><br>
            `)
    }

    async function getCustomer(customerId) {
        let customer;
        await $.ajax({
            "type": 'GET',
            "url": 'api/customers/',
            "success": function (customers) {
                console.log('success', customers);
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

    function addOrderline() {
        $.ajax({
            "type": 'GET',
            "url": 'api/orders/',
            "success": function (orders) {
                console.log('success', orders);
                $.each(orders, function (i, order) {
                    addOrder(order);
                })
            },
            "error": function () {
                alert("No products found.");
            }
        })
    }

})