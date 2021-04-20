let productsDictionary = {};
if(localStorage.getItem("cart") === null) localStorage.setItem("cart", JSON.stringify([]));
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
                productsDictionary[product.id] = product;
                addProductToBrowser(product);
            })
        },
        error() {
            alert("No products found.");
        }
    })

    function addProductToCart(product) {
        let cart = JSON.parse(localStorage.getItem("cart"));
        let cartItem = cart.find(cartItem => product.id === cartItem.id);
        if(cartItem === undefined){
            cartItem = {
                "id":product.id,
                "amount":1
            }
            cart.push(cartItem);
        }else{
            cartItem.amount++;
        }
        localStorage.setItem("cart",JSON.stringify(cart));
    }

    $($product).on('click', '.add-to-cart-button', function () {
        let productId = $(this).val();
        addProductToCart(productsDictionary[productId])
    })
    $
})