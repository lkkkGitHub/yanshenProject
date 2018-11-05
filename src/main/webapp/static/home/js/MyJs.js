$(document).on('click', ".js-skill-angle", function () {
    var x = document.getElementsByClassName("js-statistical-item");
    if ($(".icon-angle-up").css("display") == 'none') {
        $(".icon-angle-up").css("display","block");
        $(".icon-angle-down").css("display","none");
        for (var i = 0; i < x.length; i++) {
            x[i].style.display = 'block';
        }
    } else {
        $(".icon-angle-up").css("display","none");
        $(".icon-angle-down").css("display","block");
        for (var i = 3; i < x.length; i++) {
            x[i].style.display = 'none';
        }
    }
});