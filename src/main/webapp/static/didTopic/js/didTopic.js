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

        }
    })
}