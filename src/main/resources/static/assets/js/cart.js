var tableBody = document.querySelector('.tableBody')

console.log(order)

function showCartItem(response) {
    let item = document.createElement('tr')
    item.id = response.id
    item.innerHTML = "<td class=\"cart-single-item\">\n" +
        "        <div class=\"item-img\">\n" +
        "            <a href=\"\"><img src=\"assets/images/food-menu/cart1.jpg\" alt=\"\"></a>\n" +
        "        </div>\n" +
        "        <div class=\"item-name\">\n" +
        "            <a href=\"#\">" + response.title + "</a>\n" +
        "        </div>\n" +
        "    </td>\n" +
        "    <!-- cart-single-item -->\n" +
        "    <td class=\"cart-price\">\n" +
        "        <span>" + response.price + "</span>\n" +
        "    </td>\n" +
        "    <!-- cart-price -->\n" +
        "<td class=\"cart-quantity\">\n" +
        "<div class=\"product-quantity\">\n" +
        "<input type=\"submit\" class='minus' name=\"submit\" value=\"-\">\n" +
        "<input type=\"text\" name=\"text\" value=\"" + response.dish_count + "\">\n" +
        "<input type=\"submit\" class='plus' name=\"submit\" value=\"+\">\n" +
        "</div>\n" +
        "</td>" +
        "    <td class=\"cart-price total\" class=\"total\">\n" +
        "        <span>" + Number(response.dish_count * response.price) + "</span>\n" +
        "    </td>\n"
    let buttonMinus = item.querySelector('.minus')
    buttonMinus.addEventListener('click', function () {
        changeDishCount('minus', response.dish_id, item)
    })
    let buttonPlus = item.querySelector('.plus')
    buttonPlus.addEventListener('click', function () {
        changeDishCount('plus', response.dish_id, item)
    })
    tableBody.appendChild(item);
}

function changeDishCount(change, dish_id, item) {
    $.ajax({
        url: "http://localhost:8080/order/change?change=" + change + "&dish_id=" + dish_id + "&order_id=" + order.id,
        type: 'PUT',
        contentType: 'application/json',
        success: function (response) {
            console.log(response)
            changeItem(response, item)
        }
    })
}

function changeItem(response, item) {
    console.log(response)
    if (response === '') {
        item.parentNode.removeChild(item);
    } else {
        var count = item.querySelectorAll('input')
        count[1].value = response.dishCount
        var totalPrice = item.querySelectorAll(".cart-price")
        console.log(totalPrice[0].innerHTML)
        totalPrice[1].innerHTML = "        <span>" +
            Number(response.dishCount * totalPrice[0].querySelector('span').innerHTML) + "</span>\n"
    }
    editTotalPrice()
}

function showAllItems(response) {
    console.log(response);
     let sum = Number(0);
    for (let i = 0; i < response.length; i++) {
        showCartItem(response[i])
    }
    showTotalPrice()
}

function getAll() {
    $.ajax({
        url: "http://localhost:8080/details/item?order_id=" + order.id,
        type: 'GET',
        contentType: 'application/json',
        success: showAllItems
    })

}

getAll()
function calculateTotalPrice(){
    let allTotal = document.querySelectorAll('.total')
    let sum = Number(0);
    console.log(allTotal.length)
    for ( let i = 0; i<allTotal.length;i++){
        console.log(allTotal[i].querySelector('span').innerHTML)
        sum +=Number(allTotal[i].querySelector('span').innerHTML)
        console.log("sum=" +sum)
    }
    return sum
}
function showTotalPrice() {

    let orderTotal = document.querySelector('.total-price')
    let totalPrice = document.createElement('div')
    totalPrice.classList.add('order-total')
    totalPrice.innerHTML = "<span class=\"pull-left\">Order Total</span>\n" +
        "\t\t\t\t\t\t\t\t\t\t<p class=\"pull-right\">" + calculateTotalPrice() + "</p>"
    orderTotal.appendChild(totalPrice)
}
function editTotalPrice(){
    let totalPrice = document.querySelector('.pull-right')
    totalPrice.innerHTML= calculateTotalPrice();
}

var finishButton = document.querySelector('.finish')
finishButton.addEventListener('click',  finishOrder)
function finishOrder() {
    // for(let i=0;i<tableBody.children.length;i++){
    //     console.log(tableBody.children[i])
    //     tableBody.removeChild(tableBody.children[i])
    // }
    // tableBody.innerHTML=''
    $.ajax({
        url: "http://localhost:8080/order/send?order_id=" + order.id,
        type: 'PUT',
        contentType: 'application/json',
        success: function (){
            window.location.replace("http://localhost:8080/shop")
        }
    })
}