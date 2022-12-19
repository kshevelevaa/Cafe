var foodMenu = document.querySelector('.food-menu-item-wrapper')
console.log(foodMenu)
let addButton
if (user == 'admin') {
    addButton = document.querySelector('.reservation-btn')
    addButton.addEventListener('click', addDish)
}

function addDish() {
    var allInputs = foodMenu.querySelectorAll('.input-box')
    let dish = {
        title: allInputs[0].value,
        price: allInputs[1].value,
        category_id: allInputs[2].value,
        cook_id: allInputs[3].value
    }
    $.ajax({
        url: "http://localhost:8080/dishes",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(dish),
        success: createDish
    })
}

function createDish(response) {

    if (!response) {
        console.log("ERROR")
    } else {
        showDish(response);
    }
}

function getAll() {
    $.ajax({
        url: "http://localhost:8080/dishes",
        type: 'GET',
        contentType: 'application/json',
        success: showAllDishes
    })
}

function showAllDishes(response) {
    console.log(response);
    let limit = 0;
    if (user == "admin") {
        limit = 1;
    }
    while (foodMenu.children.length > limit) {
        foodMenu.removeChild(foodMenu.lastChild)

    }
    for (let i = 0; i < response.length; i++) {
        showDish(response[i]);
    }
}

function showDish(response) {
    let menuItem = document.createElement('div');
    menuItem.id = response.id
    menuItem.classList.add('element-item', 'food-item', 'style-2', 'col-md-3', 'col-sm-4');
    menuItem.innerHTML = "<div class=\"food-item-img\">\n" +
        "        <img src=\"assets/images/food-menu/item13.jpg\" alt=\"\">\n" +
        "            <div class=\"food-item-img-overlay\"></div>\n" +
        "            <div class=\"food-item-img-overlay-content\">\n" +
        "            </div>\n" +
        "    </div>\n" +
        "    <div class=\"food-item-details\">\n" +
        "        <div class=\"dotted-title\">\n" +
        "            <div class=\"dotted-name\">\n" +
        "                <a href=\"#\">" + response.title + "</a>\n" +
        "            </div>\n" +
        "            <div class=\"dotted-dot\"></div>\n" +
        "            <div class=\"dotted-price\">\n" +
        "                <span>$" + response.price + "</span>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!-- dotted title -->\n" +
        "        <p>Conveniently imaiipact worldwide and</p>\n" +
        "        <div class=\"rating-star\">\n" +
        "            <i class=\"fa fa-star-o\"></i>\n" +
        "            <i class=\"fa fa-star-o\"></i>\n" +
        "            <i class=\"fa fa-star-o\"></i>\n" +
        "            <i class=\"fa fa-star-o\"></i>\n" +
        "            <i class=\"fa fa-star-o\"></i>\n" +
        "            <span>\n" +
        "\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n" +
        "\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n" +
        "\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n" +
        "\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star\"></i>\n" +
        "\t\t\t\t\t\t\t\t\t<i class=\"fa fa-star-half-o\"></i>\n" +
        "\t\t\t\t\t\t\t\t</span>\n" +
        "        </div>\n" +
        "        <!-- rating star -->\n" +
        "    </div>"
    var renatLoh = menuItem.querySelector(".food-item-img-overlay-content");
    if (user == "admin") {
        renatLoh.innerHTML = " <a href=\"#\" class=\"button m-2\">edit dish</a> " +
            " <a href=\"#\" class=\"button m-2\">delete dish</a>"
        var buttons = renatLoh.querySelectorAll('.button')
        // console.log(buttons)
        buttons[0].addEventListener('click', function () {
            editDish(menuItem, response)
        })
        buttons[1].addEventListener('click', function () {
            deleteDish(menuItem, response.id)
        })
    } else {
        renatLoh.innerHTML = " <a href=\"#\" class=\"button\">add to cart</a> "
        var button = renatLoh.querySelector('.button')
        button.addEventListener('click', function () {
            addToCart(response)
        })
    }
    foodMenu.appendChild(menuItem);
}

getAll();

function editDish(menuItem, response) {
    console.log(menuItem)
    console.log(response)
    menuItem.style.display = 'none'
    let editForm = document.createElement('div');
    editForm.classList.add('element-item', 'food-item', 'style-2', 'col-md-3', 'col-sm-4');
    editForm.innerHTML = "<div class=\"food-item-img\">\n" +
        "\t\t\t\t\t\t\tEdit dish\n" +
        "\t\t\t\t\t\t\t<div class=\"single-input\">\n" +
        "\t\t\t\t\t\t\t\t<input class=\"input-box\" value='" + response.title + "' type=\"text\" name=\"Person\" placeholder=\"title\">\n" +
        "\t\t\t\t\t\t\t\t<i class=\"fa fa-user\"></i>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t<div class=\"single-input\">\n" +
        "\t\t\t\t\t\t\t\t<input class=\"input-box\" value='" + response.price + "' type=\"text\" name=\"Person\" placeholder=\"price\">\n" +
        "\t\t\t\t\t\t\t\t<i class=\"fa fa-user\"></i>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t<div class=\"single-input\">\n" +
        "\t\t\t\t\t\t\t\t<input class=\"input-box\" value='" + response.category_id + "' type=\"number\" name=\"Person\" placeholder=\"category_id\">\n" +
        "\t\t\t\t\t\t\t\t<i class=\"fa fa-user\"></i>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t<div class=\"single-input\">\n" +
        "\t\t\t\t\t\t\t\t<input class=\"input-box\" value='" + response.cook_id + "' type=\"text\" name=\"Person\" placeholder=\"cook_id\">\n" +
        "\t\t\t\t\t\t\t\t<i class=\"fa fa-user\"></i>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t<div class=\"reservation-btn\">\n" +
        "\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"button\">Edit</button>\n" +
        "\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"button\">Close</button>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t</div>"
    let buttons = editForm.querySelectorAll('.button')
    buttons[0].addEventListener('click', function () {
            updateDish(menuItem, response.id)
        }
    )
    buttons[1].addEventListener('click', function () {
            closeForm(menuItem)
        }
    )
    menuItem.parentNode.insertBefore(editForm, menuItem.nextSibling)
}

console.log(order)


function updateDish(menuItem, id) {
    // console.log(menuItem)
    // console.log(id)
    let editForm = menuItem.nextSibling
    // console.log(editForm)

    let allInputs = editForm.querySelectorAll('.input-box')
    let dish = {
        title: allInputs[0].value,
        price: allInputs[1].value,
        category_id: allInputs[2].value,
        cook_id: allInputs[3].value
    }
    $.ajax({
        url: "http://localhost:8080/dishes/" + id,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(dish),
        success: updateBlock
    })
    // console.log(menuItem)
    menuItem.style.display = 'block'
    menuItem.parentNode.removeChild(menuItem.nextSibling)
}

function updateBlock(response) {
    if (response) {
        // console.log(response)
        var menuItem = document.querySelector(`#${CSS.escape(response.id)}`)
        var title = menuItem.querySelector('.dotted-name')
        var price = menuItem.querySelector('.dotted-price')
        title.innerHTML = "                <a href=\"#\">" + response.title + "</a>\n"
        price.innerHTML = "                <span>$" + response.price + "</span>\n"
    }
}

function closeForm(menuItem) {
    menuItem.style.display = 'block'
    menuItem.parentNode.removeChild(menuItem.nextSibling)
}

function deleteDish(menuItem, id) {
    $.ajax({
        url: "http://localhost:8080/dishes/" + id,
        type: 'DELETE',
        contentType: 'application/json',

    })
    menuItem.parentNode.removeChild(menuItem)
}

function addToCart(response) {
    console.log(response)
    $.ajax({
        url: "http://localhost:8080/order/change?change=plus&dish_id=" + response.id + "&order_id=" + order.id,
        type: 'PUT',
        contentType: 'application/json',
    })
}


// let nameButton = document.querySelector('.sortByTitle')
// let priceButton = document.querySelector(".sortByPrice")
// let defaultButton = document.querySelector(".sortBy")
let selectSortButton = document.querySelector('.selectSort')
selectSortButton.addEventListener('change', sort)
// nameButton.addEventListener('select', sort)
// selectSortButton.addEventListener('change', sort)
function sort(e) {
    console.log(e.target.value)
    let sort = e.target.value
    $.ajax({
        url: "http://localhost:8080/dishes?sort=" + sort,
        type: 'GET',
        contentType: 'application/json',
        success: showAllDishes
    })
}

let selectCategoryButton = document.querySelector('.selectCategory')
selectCategoryButton.addEventListener('change', selectCategory)

function selectCategory(e) {
    let category = e.target.value
    $.ajax({
        url: "http://localhost:8080/dishes/select?category=" + category,
        type: 'GET',
        contentType: 'application/json',
        success: showAllDishes
    });
}

var searchForm = document.querySelector('.search-form')
var button = searchForm.getElementsByTagName('button')
var input = searchForm.querySelector('input')
button[0].addEventListener('click', function () {
    $.ajax({
        url: "http://localhost:8080/dishes/find?template=" + input.value,
        type: 'GET',
        contentType: 'application/json',
        success: showAllDishes
    });
})



