$(function () {
    let $index = $('#index');
    let $product = $('.products-browser');

    function addProductToBrowser(product) {
        $product.append(`
        <div class="product-listitem-medium-container">
            <div class="product-listitem-medium">
                <img class="product-img-small" src="${product.img}">
                <p>${product.name}</p>
                <p>${product.price} ${product.currency}</p>
                <p>${product.description}</p>
                <button type="button" name="Add to cart" value="${product.id}" class="add-to-cart-button">Köp</button>
            </div>
        </div>`
        )
    }

    $.ajax({
        type: 'GET',
        url: 'api/products/',
        success: function (products) {
            console.log('success', products);
            $.each(products, function (i, product) {
                addProductToBrowser(product);
            })
        },
        error() {
            alert("No products found.");
        }
    })

    function addProductToCart() {

    }

    $($product).on('click', '.add-to-cart-button', function () {
        let productId = $(this).val();
        $.ajax({
            type: 'GET',
            url: 'api/products/' + productId,
            success: function (product) {
                console.log('success', product);

            },
            error() {
                alert("No products found.");
            }
        })

    })

})