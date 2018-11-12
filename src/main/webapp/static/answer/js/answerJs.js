//进入页面即触发一次，初始化第一题的题目信息，之传入sequence = 1
//之后通过点击下一题，或者点击 12345等答题卡按钮触发
function intiTopicInfo(sequence, sequenceNext, optionId) {
    $.ajax({
        url: "/topic/getTopicPagination",
        type: "get",
        async: true,
        //(默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。注意，
        // 同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        data: {
            sequence: sequence,
            sequenceNext: sequenceNext,
            optionId: optionId
        },
        success: function (data) {
            var str = "";
            str += "<div class=\"subject-question\">\n" +
                "                            "+data.topicId+"   "+data.topicComment+"\n"+
                "                        </div>";
            for (var i = 0; i < data.optionList.length; i++) {
                str += "<a href=\"javascript:void(0);\" class=\"option subject-options\" onclick=\"checkedAndNoChecked("+i+")\" id=\"optionA" + i + "\" data-id=\"69554\">";
                str += "<label class=\"option radio\" id=\"option"+i+"\">";
                str += "<span class=\"icons\"></span>";
                str += "<input data-toggle=\"radio\" name=\"option\" class=\"option\" value=\""+data.optionList[i].optionId+"\" id=\"optionInput" + i + "\" type=\"radio\">";
                str += "<pre>"+data.optionList[i].optionId+"   "+data.optionList[i].optionComment+"</pre></label></a>";
                if (data.optionId != null) {
                    checkedAndNoChecked(i);
                }
            }
            $(".subject-content").html(str);
        }
    });
}

//单选框的选中
function checkedAndNoChecked(id) {
    var chackA = document.getElementById("optionA" + id);
    var chack = document.getElementById("option" + id);
    var nocheckedAll = document.getElementsByClassName("option");
    for (var i = 0; i < nocheckedAll.length; i++) {
        nocheckedAll[i].classList.remove("selected");
        nocheckedAll[i].classList.remove("checked");
        $('.option').attr('checked', false);
    }
    chackA.classList.add("selected");
    chack.classList.add("checked");
    $('#optionInput' + id).attr('checked', true);
}

//下导航条的题目num刷新   以及想去的下一题序号
//123456789 。。。 传入想去的下一个题目id,以及题目总数
function answeringNum(sequenceNext, topicNum) {
    //当前作答的题目序号 answering-num
    var sequence = null;
    //当前作答的题目选项id
    var optionId = $("input[name='option']:checked").val();
    if (optionId == null) {
        optionId = -1;
    }
    //获取当前的题目顺序号
    for (var i = 0; i < topicNum; i++) {
        if ($('#topicIndex' + i).is('.answering-num')) {
            sequence = i;
        }
    }
    alert(optionId);
    //传入当前题目顺序号，以及题目的选择
    intiTopicInfo(sequence, sequenceNext, optionId);
}