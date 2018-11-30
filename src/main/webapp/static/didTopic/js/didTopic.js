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
            checkCollection();
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