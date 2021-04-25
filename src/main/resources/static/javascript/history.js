$(function () {
    let $history = $('#history');

    initPage();

    async function initPage() {
        let orders = await getOrders();
        orders.forEach(async (order) => {
            await addOrder(order, order.id);
            await addCustomer(order.customerId, order.id);
            await addOrderLines(order.id);
             addOrderDeleteButton(order.id);
            listenToOrderDeleteButtons();
        })

    }

     function listenToOrderDeleteButtons() {
        $history.on('click', '.order-delete-button',  function () {
            let orderId = $(this).attr('id');
             $.ajax({
                type: 'DELETE',
                url: '/api/orders/' + orderId,
                success: function () {
                    $(`#${orderId}`).remove();
                    $(this).html('');
                }
            });
             $.ajax({
                type: 'DELETE',
                url: '/api/orderLines/orderId/' + orderId,
                success: function () {
                }
            });

        });
    }

    async function getOrders() {
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
        <div id="${id}" class="order">
            <p>Ordernummer: ${order.id} <br>Datum: ${order.finalisedByDate}</p>
        </div>`
        )
    }

    function addOrderDeleteButton(orderId) {
        $(`#${orderId}`).append(`
        <div id="${orderId}">
            <button type="submit" id="${orderId}" class="order-delete-button">Ta bort order</button>
        </div>`)
    }

    async function addCustomer(customerId, id) {
        let customer = await getCustomer(customerId);
        $(`#${id} > p`).after(`<p>${customer.name} ${customer.email}</p>
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

    async function getOrderLines(orderId) {
        let matchedOrderLines = [];
        await $.ajax({
            "type": 'GET',
            "url": 'api/orderLines/orderId/' + orderId,
            "success": function (orderLines) {
                matchedOrderLines = orderLines;
            },
            "error": function () {
                alert("No products found.");
            }
        })
        return matchedOrderLines;
    }

    async function addOrderLines(orderId) {
        let orderLines = await getOrderLines(orderId);
        orderLines.forEach((orderLine)=> {
            $(`#${orderId}.order`).append(`<p>ProduktID = ${orderLine.productId} antal: ${orderLine.amount} Kostnad(per): ${orderLine.price} kr</p>
            `)
        })
    }

})