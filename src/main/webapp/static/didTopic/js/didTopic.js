//指向当前的题目序号
var SEQUENCENEXT = "";

function initTopicToShow(sequenceNext) {
    $.ajax({
        url: "/didTopic/getDidTopicToShow",
        type: "get",
        async: false,
        data: {sequenceNext: sequenceNext},
        success: function (data) {
            var str = "";
            str += "<div class=\"result-question-box\"> <div class=\"subject-question\"> " +
                "<div class=\"question-main\">" + data.tbTopic.topicId + "    " + data.tbTopic.topicComment + "</div> </div> </div>";
            str += "<div class=\"result-subject-item result-subject-answer\">";
            str += "<h1>解析：" + data.tbTopic.analysis + "</h1>";
            for (var i = 0; i < data.tbTopic.optionList.length; i++) {
                if (data.tbTopic.optionList[i].correct == 1) {
                    str += "<div class=\"result-answer-item green-answer-item\">\n" +
                        "        <pre>" + data.tbTopic.optionList[i].optionId + "   " + data.tbTopic.optionList[i].optionComment + "</pre>\n" +
                        "        </div>";
                } else {
                    if (data.errorOptionId != null) {
                        if (data.tbTopic.optionList[i].optionId == data.errorOptionId) {
                            str += "<div class=\"result-answer-item orange-answer-item\">\n" +
                                "        <pre>" + data.tbTopic.optionList[i].optionId + "   " + data.tbTopic.optionList[i].optionComment + "</pre>\n" +
                                "        </div>";
                        } else {
                            str += "<div class=\"result-answer-item\">\n" +
                                "        <pre>" + data.tbTopic.optionList[i].optionId + "   " + data.tbTopic.optionList[i].optionComment + "</pre>\n" +
                                "        </div>";
                        }
                    } else {
                        str += "<div class=\"result-answer-item\">\n" +
                            "        <pre>" + data.tbTopic.optionList[i].optionId + "   " + data.tbTopic.optionList[i].optionComment + "</pre>\n" +
                            "        </div>";
                    }
                }
            }
            str += "<div id=\"referAnchor\"></div></div>";
            $("#topicShow").html(str);
            SEQUENCENEXT = data.topicId;
            /**
             * 判断是否收藏
             */
            checkCollection();
            /**
             * 生成评论信息
             */
            findComment();
        }
    });
    //done-hover
    //标记选中的当前的题目序号
    var orders = document.getElementsByClassName("order");
    //清除之前选中
    for (var i = 0; i < orders.length; i++) {
        orders[i].classList.remove("done-hover");
    }
    //选中当前的题目序号
    var orderA = document.getElementById("order" + sequenceNext);
    orderA.classList.add("done-hover");
}

function checkCollection() {
    $.ajax({
        url: "/collection/checkCollection",
        type: "get",
        async: true,
        data: {
            topicId: SEQUENCENEXT
        },
        success: function (data) {
            var flag = data;
            var str = "";
            if (flag == 0) {
                str += " <a class=\"oprt-item oprt-collect click-follow nc-req-auth\" onclick=\"confirmChecked(" + 1 + "," + 1 + ")\" href=\"javascript:void(0);\">";
                str += "已收藏";
            } else if (flag == -1) {
                str += " <a class=\"oprt-item oprt-collect click-follow nc-req-auth\" onclick=\"confirmChecked(" + 0 + "," + 0 + ")\" href=\"javascript:void(0);\">";
                str += "收藏";
            } else if (flag == 1) {
                str += " <a class=\"oprt-item oprt-collect click-follow nc-req-auth\" onclick=\"confirmChecked(" + 0 + "," + 1 + ")\" href=\"javascript:void(0);\">";
                str += "收藏";
            }
            str += "</a>";
            $("#collection").html(str);
        }
    });
}

function confirmChecked(deleteFlag, flag) {
    $.ajax({
        url: "/collection/insertCollection",
        type: "get",
        async: true,
        data: {
            topicId: SEQUENCENEXT,
            deleteFlag: deleteFlag,
            flag: flag
        },
        success: function (data) {
            var str = "";
            if (deleteFlag == 0) {
                str += " <a class=\"oprt-item oprt-collect click-follow nc-req-auth\" onclick=\"confirmChecked(" + 1 + "," + 1 + ")\" href=\"javascript:void(0);\">";
                str += "已收藏";
            } else {
                str += " <a class=\"oprt-item oprt-collect click-follow nc-req-auth\" onclick=\"confirmChecked(" + 0 + "," + 1 + ")\" href=\"javascript:void(0);\">";
                str += "收藏";
            }
            str += "</a>";
            $("#collection").html(str);
        }
    });
}

//显示评论，信息，回复点击展开之后再显示
function findComment() {
    $.ajax({
        url: "/comment/findCommentByTopicId",
        type: "get",
        data: {topicId: SEQUENCENEXT},
        success: function (data) {
            var str = "";
            if (data.length != 0) {
                str += "<span class=\"analytic-discuss-num\">共有"+data[0].count+"条讨论</span>";
                $("#clearfix").html(str);
                str = "";
                var date = "";
                for (var i = 0; i < data.length; i++) {
                    date = timeStamp2String(data[i].commentCreateDate);
                    str += "<li class=\"answer-list-item clearfix\"> <div class=\"answer-content clearfix\" data-cmt-id=\"1155848\" data-dislikecnt=\"0\" data-isdisliked=\"\" data-recommend=\"0\">";
                    str += " <div class=\"answer-info\"><a href=\"/profile/759736\" class=\"answer-head\" data-card-uid=\"759736\" data-card-index=\"1\">";
                    str += "<img src=\"" + data[i].tbUser.image + "\" alt=\"\"></a>";
                    str += "<a class=\"answer-name 梦境迷离头像level-color-9\" data-card-uid=\"759736\" href=\"/profile/759736\" data-card-index=\"2\">" + data[i].tbUser.uname + "</a>";
                    str += "</div><div class=\"answer-brief\">" + data[i].commentContent + "</div>";
                    str += " <div class=\"answer-legend\"><span class=\"answer-time\">发表于" + date + "</span>";
                    str += "<a class=\"click-reply\" href=\"javascript:void(0);\">回复（回复数量待查）</a>";
                    str += "  </div>  </div> </li>";
                }
                $("#commentList").html(str);
            } else {
                str += "<span class=\"analytic-discuss-num\">暂时没有评论</span>";
                $("#clearfix").html(str);
            }

        }
    });
}

//时间处理函数

function timeStamp2String(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}