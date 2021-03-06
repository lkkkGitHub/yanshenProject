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
                for (i = json.length; i < 6; i++) {
                    x[i].remove();
                }
            } else if (json.length > 6) {
                for (i = 6; i < json.length; i++) {
                    id = i + 1;
                    str = "";
                    str += "<div class=\"statistical-item clearfix js-statistical-item\" data-id=\"570\">";
                    str += "<div onclick=\"checkedAndNoCheck(" + id + ",'classifyClass')\" class=\"s-item-cell s-checkbox\">\n" +
                        "<label class=\"checkbox\" id=\"classifyClass" + id + "\">\n" +
                        "<span class=\"icons\"></span>\n" +
                        "<input type=\"checkbox\" value=\"" + id + "\" name=\"classifyIds\" class=\"classifyClass" + id + "\">\n" +
                        "</label>\n" +
                        "</div>";
                    str += "<div class=\"s-item-cell s-column1\" id=\"column" + id + "\">" + json[i].classifyName + "</div>\n" +
                        "<div class=\"s-item-cell s-column2\"><span id=\"didTopic" + id + "\"></span>\n" +
                        "/<span id=\"allTopicNum" + id + "\"></span>\n" +
                        "</div>";
                    str += " <div class=\"s-item-cell s-column3\"><span id=\"correctRate" + id + "\"></span>%</div>\n" +
                        "<div class=\"s-item-cell s-column4\">\n" +
                        "<a data-left=\"303\" class=\"btn btn-primary nc-js-make-paper\">开始练习</a>\n" +
                        "</div>\n" +
                        "<div class=\"s-item-oprt\">\n" +
                        "<a class=\"js-del-skill\" href=\"javascript:void(0);\">查看错题</a>\n" +
                        "</div>\n" +
                        "</div>";
                    $(".statistical-list").append(str);
                }
            }
            //初始化选择框中的题目类型
            str = "";
            str += "<span class=\"item-label\">出题来源：</span>";
            for (i = 0; i < json.length; i++) {
                str += "<label class=\"checkbox\" onclick=\"checkedAndNoCheck(" + json[i].classifyId + ",'checkbox')\" id=\"checkbox" + json[i].classifyId + "\">";
                str += "<span class=\"icons\"></span><input class=\"checkbox" + json[i].classifyId + "\" type=\"checkbox\" name=\"classifyIds\" value=\"" + json[i].classifyId + "\">" + json[i].classifyName + "</label>";
            }
            $("#selectType").html(str);
            checkedAndNoCheck(json[0].classifyId, 'checkbox');
        }
    });
    //初始化做过题目,导航条，每个类型的做题数量，以及每个类型的正确率
    $.ajax({
        url: "/didTopic/getDidTopicUtil",
        type: "post",
        async: true,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (data) {
            var str;
            //初始化导航条
            str = "" + data.didTopicNum + "题";
            $("#didTopic").html(str);
            str = "" + data.didTopicNum-data.errorDidTopicNum + "题";
            $("#errorDidTopic").html(str);
            str = "" + data.correctRate + "%";
            $("#correctRate").html(str);
            //初始化每个类型做过多少题目
            for (var key in data.mapDidTopicByClassify) {
                str = "" + data.mapDidTopicByClassify[key] + "";
                $("#didTopic" + key).html(str);
            }
            //初始化正确率
            for (var key in data.mapCorrectRate) {
                str = "" + data.mapCorrectRate[key] + "";
                $("#correctRate" + key).html(str);
            }
        }
    });
    //初始化所有类别题目总数
    $.ajax({
        url: "/topic/getTopicNumAllClassify",
        type: "post",
        async: true,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (data) {
            for (var key in data) {
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

//点击弹出或者关闭题目选择的界面
$(document).on('click', ".nc-js-make-paper", function () {
    var selectDiv = document.getElementById("selectTopicType");
    if (selectDiv.style.display == 'none') {
        selectDiv.style.display = 'block';
    } else {
        selectDiv.style.display = 'none';
    }
});

//复选框checkbox 点击选中或者取消选中
function checkedAndNoCheck(classifyId, className) {
    var classCheckbox = className + classifyId;
    //鼠标点击一次触发两次的解决方法
    //阻止冒泡事件
    event.preventDefault();
    // var checkbox = document.getElementsByClassName(classCheckbox);
    var check = document.getElementById(classCheckbox);
    if (check.className.indexOf("checked")>-1) {
        check.classList.remove("checked");
        $('.'+classCheckbox).attr('checked', false);
    } else {
        check.classList.add("checked");
        $('.'+classCheckbox).attr('checked', true);
    }
}

//单选框radio 点击选中或者取消选中
function radioCheckedAndNoCheck(name, type) {
    event.preventDefault();
    var check = document.getElementById(name);
    var checkout = document.getElementsByClassName(type);

    for (var i = 0; i < checkout.length; i++) {
        checkout[i].classList.remove("checked");
        $('.'+type).attr('checked', false);
    }
    if (check.className.indexOf("checked")>-1) {
        check.classList.remove("checked");
        $('.'+name).attr('checked', false);
    } else {
        check.classList.add("checked");
        $('.'+name).attr('checked', true);
    }
}