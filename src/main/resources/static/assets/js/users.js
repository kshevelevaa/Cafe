// // <tbody>
// // <tr>
//     <td class="cart-single-item">
//         <div class="item-img">
//             <a href=""><img src="assets/images/food-menu/cart1.jpg" alt=""></a>
//         </div>
//         <div class="item-name">
//             <a href="#">Product Title Here</a>
//         </div>
//     </td>
//     <!-- cart-single-item -->
//     <td class="cart-price">
//         <span>$20.00</span>
//     </td>
//     <!-- cart-price -->
//     <td class="cart-quantity">
//         <div class="product-quantity">
//             <input type="submit" name="submit" value="-">
//                 <input type="text" name="text" value="2">
//                     <input type="submit" name="submit" value="+">
//         </div>
//     </td>
//     <!-- cart-quantity -->
//     <td class="cart-total">
//         <span>$40.00</span>
//     </td>
//     <!-- cart-total -->
//     <td class="cart-item-remove">
//         <a href="#">
//             <i class="fa fa-times"></i>
//         </a>
//     </td>
//     <!-- cart-item-remove -->
// // </tr>

var tableBody = document.querySelector('.tableBody')

function showUser(response) {
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

function showAllUsers(response) {
    console.log(response);
    for (let i = 0; i < response.length; i++) {
        if (response[i].username != "admin") {
            showUser(response[i])
        }
    }
}

function getAll() {
    $.ajax({
        url: "http://localhost:8080/users",
        type: 'GET',
        contentType: 'application/json',
        success: showAllUsers
    })
}

getAll()


function deleteUser(user, id) {
    $.ajax({
        url: "http://localhost:8080/users/" + id,
        type: 'DELETE',
        contentType: 'application/json',

    })
    user.parentNode.removeChild(user)
}
