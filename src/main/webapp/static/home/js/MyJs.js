//进入页面即触发的函数，对页面的数据进行初始化
function initUserTopicInfo() {
    //初始化类别信息：java C++...
    $.ajax({
        url: "/classify/getAllClassify",
        type: "get",
        async: false,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (json) {
            for (var i = 0; i < json.length; i++) {
                var str = "";
                str = "" + json[i].classifyName + "";
                var id = i + 1;
                var strId = "column" + id;
                $("#" + strId).html(str);
            }
            if (json.length < 6) {
                var x = document.getElementsByClassName("js-statistical-item");
                for (var i = json.length; i < 6; i++) {
                    x[i].remove();
                }
            } else if (json.length > 6) {
                for (var i = 6; i < json.length; i++) {
                    var id = i + 1;
                    var str = "";
                    str += "<div class=\"statistical-item clearfix js-statistical-item\" data-id=\"636\" style=\"display: none;\">";
                    str += "<div class=\"s-item-cell s-checkbox\">";
                    str += "<label class=\"checkbox\" id=\"jsCpn_5_checkbox_3\">";
                    str += "<span class=\"icons\"></span>";
                    str += "<input type=\"checkbox\">";
                    str += " </label></div><div class=\"s-item-cell s-column1\" id=\"column"+id+"\">"+json[i].classifyName+"</div>";
                    str += "<div class=\"s-item-cell s-column2\">15/<span id=\"allTopicNum"+id+"\"></span> </div>";
                    str += "<div class=\"s-item-cell s-column3\">33%</div><div class=\"s-item-cell s-column4\">";
                    str += "<form class=\"form-box\" method=\"post\" action=\"https://www.nowcoder.com/makePaper?tagIds=636\">";
                    str += "<button data-left=\"41\" class=\"btn btn-primary nc-js-make-paper\">开始练习</button></form></div>";
                    str += "<div class=\"s-item-oprt\"><a class=\"js-del-skill\" href=\"javascript:void(0);\">查看错题</a> </div> </div>";
                    $(".statistical-list").append(str);
                }
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
            str = ""+data.didTopicNum+"题";
            $("#didTopic").html(str);
            str = ""+data.errorDidTopicNum+"题";
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