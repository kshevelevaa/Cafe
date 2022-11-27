var tableBody = document.querySelector('.tableBody')

function showCartItem(response) {
    let user = document.createElement('tr')
    user.id = response.id
    user.innerHTML = "<td class=\"cart-single-item\">\n" +
        "        <div class=\"item-img\">\n" +
        "            <a href=\"\"><img src=\"assets/images/food-menu/cart1.jpg\" alt=\"\"></a>\n" +
        "        </div>\n" +
        "        <div class=\"item-name\">\n" +
        "            <a href=\"#\">" + response.username + "</a>\n" +
        "        </div>\n" +
        "    </td>\n" +
        "    <!-- cart-single-item -->\n" +
        "    <td class=\"cart-price\">\n" +
        "        <span>" + response.number + "</span>\n" +
        "    </td>\n" +
        "    <!-- cart-price -->\n" +
        "    <td class=\"cart-price\">\n" +
        "        <span>" + response.email + "</span>\n" +
        "    </td>\n" +
        "    <!-- cart-quantity -->\n" +
        // "    <td class=\"cart-total\">\n" +
        // "        <span>$40.00</span>\n" +
        // "    </td>\n" +
        "    <!-- cart-total -->\n" +
        "    <td class=\"cart-item-remove\">\n" +
        "<button type='submit' class='button delete'>delete</button> "+
        // " <a href=\"#\" class=\"button m-2\">delete dish</a>" +
        "    </td>"
    var deleteButton = user.querySelector(".button")
    deleteButton.addEventListener('click', function () {
        deleteUser(user, response.id)
    })
    tableBody.appendChild(user);
}