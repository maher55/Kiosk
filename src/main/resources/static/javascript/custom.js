let productsDictionary = {};
if (localStorage.getItem("cart") === null) localStorage.setItem("cart", JSON.stringify([]));

$(function () {
    let $index = $('#index');
    let $product = $('.products-browser');

    $.ajax({
        "type": 'GET',
        "url": 'api/products/',
        "success": function (products) {
            console.log('success', products);
            $.each(products, function (i, product) {
                productsDictionary[product.id] = product;
                addProductToBrowser(product);
            })
        },
        "error": function () {
            alert("No products found.");
        }
    }).then(() => {
        buildCartGUI();
    });
    $(".products-browser").on('click', '.buy-button', () => {
        window.location.href = '/order';
    })

    $($product).on('click', '.add-to-cart-button', function () {
        $('.cart').show();
        let productId = $(this).val();
        addProductToCart(productsDictionary[productId], 1) //todo
    })
    $(".cart-button").on('click', function () {
        if ($('.cart').is(":visible")) {
            $('.cart').hide();
        } else {
            $('.cart').show();
        }
    })

    function addProductToCart(product, amount) {
        let cartItem = increaseCartItem(product, amount);
        updateCartWithProduct(product, cartItem.amount)
    }

    function updateCartWithProduct(product, amount) {
        if ($(`.current-order #${product.id}`).length === 0) {
            $(`.current-order`).append(`
        <li id='${product.id}'>${product.name} ${amount} ${product.unit} ${parseFloat(product.price) * amount} Kr <button id="${product.id}" class="remove-cartItem-button">X</button></li>
        `)
        } else {
            $(`.current-order #${product.id}`).replaceWith(`
        <li id='${product.id}'>${product.name} ${amount} ${product.unit} ${parseFloat(product.price) * amount} Kr<button id="${product.id}" class="remove-cartItem-button">X</button></li>
        `)
        }
        updateCartTotalCost()
    }

    function updateCartTotalCost() {
        let sum = 0;
        getCart().forEach(cartItem => sum = parseFloat(productsDictionary[cartItem.id].price) * cartItem.amount + sum);
        $(`.total-cost`).replaceWith(`<p class="total-cost">Total kostnad: ${sum} Kr</p>
        `)
    }

    function addProductToBrowser(product) {
        $product.append(`
        <div class="product-listitem-medium-container">
            <div class="product-listitem-medium">
                <img class="product-img-small" src="${product.img}" alt="${product.name}">
                <p>${product.name}</p>
                <p>${product.price} Kr/${product.unit}</p>
                <p>${product.description}</p>
                <button type="button" name="Add to cart" value="${product.id}" class="add-to-cart-button">Lägg till</button>
            </div>
        </div>`
        )
    }

    function getCartItem(cart, product) {
        return cart.find(cartItem => product.id === cartItem.id);
    }

    function clearCartItemInCart(cartItemIdToRemove) {
        saveCart(getCart().filter(cartItem => cartItem.id !== cartItemIdToRemove));
    }


    function getCart() {
        return JSON.parse(localStorage.getItem("cart"));
    }

    function saveCart(cart) {
        localStorage.setItem("cart", JSON.stringify(cart));
    }

    function setCartItem(product, amount) {
        let cart = getCart();
        let cartItem = getCartItem(cart, product)
        if (cartItem === undefined) {
            cartItem = {
                "id": product.id,
                "amount": 0
            }
            cart.push(cartItem);
        }
        cartItem.amount = amount;
        saveCart(cart);
        return cartItem;
    }

    function increaseCartItem(product, amount) {
        let cartItem = getCartItem(getCart(), product);
        let currentAmount = cartItem === undefined ? 0 : cartItem.amount;
        return setCartItem(product, currentAmount + amount);

    }

    function buildCartGUI() {
        $('.products-browser').append
        (`<div class="cart">
            <div class="current-order-container">
                <ul class="current-order"></ul>  
                </div>
                    <p class="total-cost">Total kostnad: 0Kr</p>
                <div class="buy-button-container">
                    <button class="buy-button">Köp</button>
            </div>
        </div>`);
        $('.cart').hide();
        $(`.current-order`).unbind('click');
        $(`.current-order`).on('click', '.remove-cartItem-button', function () {
            let cartItemId = $(this).attr('id');
            clearCartItemInCart(parseInt(cartItemId));
            $(this.closest('li')).remove();
            updateCartTotalCost();

        });
        loadLocalCartData();
    }

    function loadLocalCartData() {
        let cart = getCart();
        if (cart !== undefined) {
            (getCart()).forEach((cartItem) => updateCartWithProduct(productsDictionary[parseInt(cartItem.id)], cartItem.amount))
            updateCartTotalCost();
        }
    }

})