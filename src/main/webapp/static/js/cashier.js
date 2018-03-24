$(function () {
    $('.category-button').on('click',function () {
        $.get("http://localhost:8080/menu?category="+this.id, function (result) {
            $('#content').html(result);
        });
    });
});

$(function () {
    $('.dish-button').on("click", function () {
        $.get("http://localhost:8080/check?dishId="+this.id, function (result) {
            $('#aside').html(result);
        });
    });
});