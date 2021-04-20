
$(function () {
    let $index = $('#index');

    function addProduct(product) {
        $index.append(`
         <div class="product-listitem-medium">
            <img class="product-img-small" src="${product.img}">
            <tbody>
            <table>
                <tr>
                    <td> Vara:</td>
                    <td>${product.name}</td>
                </tr>
                <tr>
                    <td> Pris:</td>
                    <td>${product.price} ${product.currency}</td>
                </tr>
            </table>
            </tbody>
            <p>Beskrivning: </p>
            <p>${product.description}</p>
            <button type="button" name="add-to-cart" value="${product.id}" th:onclick="|@{a}|">Köp</button>
         </div>`
        )
    }

    $.ajax({
        type: 'GET',
        url: 'api/products/',
        success: function (products) {
            console.log('success', products);
            $.each(products, function (i, product) {
                addProduct(product);
            })
        },
        error(){
            alert("No products found.");
        }
    })

})