//进入页面即触发的函数，对页面的数据进行初始化
function initUserTopicInfo() {
    //初始化类别信息：java C++...
    $.ajax({
        url: "/classify/getAllClassify",
        type: "get",
        async: true,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (json) {
            for (var i = 0; i < json.length; i++) {
                var str = "";
                str = ""+json[i].classifyName+"";
                var id = i + 1;
                var strId = "column" + id;
                $("#"+strId).html(str);
            }
        }
    });
    //初始化做过题目导航条
    $.ajax({
        url : "/didTopic/getDidTopicUtil",
        type : "post",
        async : true,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success : function (data) {
            var str;
            str = ""+data.didTopicNum+"";
            $("#didTopic").html(str);
            str = ""+data.errorDidTopicNum+"";
            $("#errorDidTopic").html(str);
            str = ""+data.correctRate+"%";
            $("#correctRate").html(str);
        }
    });
    //初始化所有类别题目总数
    $.ajax({
        url : "/topic/getTopicNumAllClassify",
        type : "post",
        async : true,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success : function (data) {
            for(var key in data){
                var str;
                str = ""+data[key]+"";
                $("#allTopicNum" + key).html(str);
            }
        }
    });
}


//点击加载更多数据，实际上已经加载并显示了数据，只是display隐藏了
$(document).on('click', ".js-skill-angle", function () {
    var x = document.getElementsByClassName("js-statistical-item");
    if ($(".icon-angle-up").css("display") == 'none') {
        $(".icon-angle-up").css("display", "block");
        $(".icon-angle-down").css("display", "none");
        for (var i = 0; i < x.length; i++) {
            x[i].style.display = 'block';
        }
    } else {
        $(".icon-angle-up").css("display", "none");
        $(".icon-angle-down").css("display", "block");
        for (var i = 3; i < x.length; i++) {
            x[i].style.display = 'none';
        }
    }
});