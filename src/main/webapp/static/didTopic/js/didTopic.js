//指向当前的题目序号
var SEQUENCENEXT = "";
// 当前题目的题目id
var TOPICId = "";

// 做完题之后 初始化题目显示
function initTopicToShow(sequenceNext) {
    $.ajax({
        url: "/didTopic/getDidTopicToShow",
        type: "get",
        async: false,
        data: {sequenceNext: sequenceNext},
        success: function (data) {
            TOPICId = data.tbTopic.topicId;
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
             * 生成评论信息,以及显示回复的数量；
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

//收藏题目显示
function topicDetail() {
    var topicId = getQueryString("topicId");
    $.ajax({
        url: "/collection/getTopicDetail",
        type: "get",
        async: false,
        data: {topicId: topicId},
        success: function (data) {
            TOPICId = data.tbTopic.topicId;
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
             * 生成评论信息,以及显示回复的数量；
             */
            findComment();
        }
    });
}

//检查是否收藏
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

//收藏
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

//显示评论，信息
function findComment() {
    $.ajax({
        url: "/comment/findCommentByTopicId",
        type: "get",
        async: true,
        data: {topicId: SEQUENCENEXT},
        success: function (data) {
            var str = "";
            if (data.length != 0) {
                str += "<span class=\"analytic-discuss-num\">共有" + data[0].count + "条讨论</span>";
                $("#clearfix").html(str);
                str = "";
                var date = "";
                for (var i = 0; i < data.length; i++) {
                    var flag = data[i].tbUser.uid == uid;
                    date = timeStamp2String(data[i].commentCreateDate);
                    str += "<li class=\"answer-list-item clearfix\"> <div class=\"answer-content clearfix\" data-cmt-id=\"1155848\" data-dislikecnt=\"0\" data-isdisliked=\"\" data-recommend=\"0\">";
                    str += " <div class=\"answer-info\"><a href=\"/profile/759736\" class=\"answer-head\" data-card-uid=\"759736\" data-card-index=\"1\">";
                    str += "<img src=\"" + data[i].tbUser.image + "\" alt=\"\"></a>";
                    str += "<a class=\"answer-name 梦境迷离头像level-color-9\" data-card-uid=\"759736\" href=\"/profile/759736\" data-card-index=\"2\">" + data[i].tbUser.uname + "</a>";
                    str += "<span id=\"showComment" + data[i].commentId + "\" style='float: right'>";
                    if (!flag) {
                        str += "<a href=\"javascript:void(0);\" onclick=\"appendInput('commentInput', -1, " + data[i].commentId + ", 'showComment', '" + data[i].tbUser.uid+ "')\" class=\"reply-answer js-reply-answer\">回复</a>";
                    }
                    str += "</span> </div><div class=\"answer-brief\">" + data[i].commentContent + "</div>";
                    str += " <div class=\"answer-legend\"><span class=\"answer-time\">发表于" + date + "</span>";
                    if (flag) {
                        str += "<a class=\"click-reply\" onclick='deleteCommentConfirm(" + data[i].commentId + ")' href=\"javascript:void(0);\">删除</a>";
                    }
                    str += "<span id=\"replyCount" + data[i].commentId + "\"> <a class=\"click-reply\" href=\"javascript:void(0);\">回复（回复数量待查）</a>";
                    str += "</span>  </div> <span id='commentInput" + data[i].commentId + "'></span> <div id=\"jsCpn_62_component_" + data[i].commentId + "\" class=\" reply-box\"></div></div> </li>"
                }
                $("#commentList").html(str);
                for (var i = 0; i < data.length; i++) {
                    findReplyCount(data[i].commentId);
                }
            } else {
                $("#commentList").html("");
                str += "<span class=\"analytic-discuss-num\">暂时没有评论</span>";
                $("#clearfix").html(str);
            }
        }
    });
}


//时间处理函数
function timeStamp2String(time) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}

//显示评论回复的个数，0以上显示查看回复，0则显示回复
function findReplyCount(commentId) {
    $.ajax({
        url: "/reply/findReplyCountByCommentId",
        type: "get",
        async: false,
        data: {commentId: commentId},
        success: function (data) {
            var str = "";
            if (data != 0) {
                str += "<a class=\"click-reply\" onclick=\"findReply(" + commentId + ")\" href=\"javascript:void(0);\"> 查看回复(" + data + ") </a>";
            } else {
                str += "<a class=\"click-reply\" href=\"javascript:void(0);\"> 暂时没有回复 </a>";
            }
            $("#replyCount" + commentId).html(str);
        }
    })
}

//显示回复信息
function findReply(commentId) {
    $("#jsCpn_62_component_" + commentId).show();
    $.ajax({
        url: "/reply/findReplyByCommentId",
        type: "get",
        async: false,
        data: {commentId: commentId},
        success: function (data) {
            var date = "";
            var str = "";
            var str = "<div class=\"reply-container js-container\" style=\"\"><ul class=\"reply-list js-list\" style=\"\">";
            for (var i = 0; i < data.length; i++) {
                var flag = data[i].tbUser.uid == uid;
                if (data[i].toUid == uid) {
                    updateIsRead(data[i].replyId);
                }
                date = timeStamp2String(data[i].replyCreateDate);
                str += "<li class=\"ui-subcmt-item\" data-id=\"684660\"> <div class=\"reply-main clearfixjsCpn_62_component_6\">";
                str += "<div class=\"reply-person\" style=\"margin-right:5px;\"><a href=\"/profile/8816416\" data-card-uid=\"8816416\"";
                if (data[i].replyFatherId == -1) {
                    str += " class=\"level-color-7\" data-cardjsCpn_62_component_6-index=\"9\" style=\"font-size: 14px;color: #00A1CB\">" + data[i].tbUser.uname + "</a>：</div>";
                } else {
                    for (var j = 0; j < data.length; j++) {
                        if (data[i].replyFatherId == data[j].replyId) {
                            str += " class=\"level-color-7\" data-cardjsCpn_62_component_6-index=\"9\" style=\"font-size: 14px;color: #00A1CB\">" + data[i].tbUser.uname + "</a>：";
                            str += "回复 <a href=\"/profile/8816416\" data-card-uid=\"8816416\"";
                            str += " class=\"level-color-7\" data-cardjsCpn_62_component_6-index=\"9\" style=\"font-size: 14px;color: #00A1CB\">" + data[j].tbUser.uname + "</a>：";
                            str += "<span class=\"reply-content\" style=\"font-size: 14px;color: #00A1CB\" >" + data[j].replyContent + "</span> </div>";
                            break;
                        }
                    }
                }
                str += "<div class=\"reply-content\" style=\"font-size: 14px\" >" + data[i].replyContent + "</div> </div>";
                str += "<div class=\"answer-legend reply-info\"><span class=\"reply-time\">" + date + "</span> <span id='show" + data[i].replyId + "'>";
                if (!flag) {
                    str += "<a href=\"javascript:void(0);\" onclick=\"appendInput('reply', " + data[i].replyId + ", " + data[i].commentId + ", 'show', '" + data[i].tbUser.uid + "')\" class=\"reply-answer js-reply-answer\">回复</a>";
                }
                str += "</span>";
                if (flag) {
                    str += "<a class=\"click-reply\" onclick='deleteReplyConfirm(" + data[i].replyId + ")' href=\"javascript:void(0);\">删除</a>";
                }
                str += "</div><span id='reply" + data[i].replyId + "'></span> </li>";
            }
            str += "</ul> <div class=\"js-pag   er\" style=\"display: none;\">";
            str += "<div id=\"jsCpn_63_component_" + commentId + "\" class=\" pagination\" style=\"display: none;\">  <ul> </ul> </div> </div>";
            $("#jsCpn_62_component_" + commentId).html(str);
            str = "<a class=\"click-reply\" onclick=\"hideHtml('jsCpn_62_component_'," + commentId + ")\" href=\"javascript:void(0);\"> 隐藏回复 </a>";
            $("#replyCount" + commentId).html(str);
        }
    });
}

//添加输入框:：fatherId添加评论框的位置，showStyle：修改《回复，收起》状态
function appendInput(fatherId, replyId, commentId, showStyle, toUid) {
    var str = "";
    if (replyId != -1) {
        str += "<span id='input" + fatherId + "" + replyId + "'>";
    } else {
        str += "<span id='input" + fatherId + "" + commentId + "'>";
    }
    str += "<div class=\"reply-editbox clearfix cmt-reply-to-main\" style=\"margin-top:10px;\">";
    str += "<div class=\"reply-write\"><textarea id='textarea" + replyId + "' placeholder=\"请输入你的回复\"";
    str += "class=\"reply-input reply-input-textarea nc-req-auth js-main-ipt\"";
    str += "style=\"width: 798px; resize: none; height: 20px;\"></textarea> </div>";
    str += "<a class=\"btn btn-primary reply-btn js-main-reply\" onclick=\"sendReply(" + commentId + ", " + replyId + ", '" + toUid + "')\" href=\"javascript:void(0);\">回复</a> </div> </span> ";
    if (replyId != -1) {
        $("#" + fatherId + replyId).append(str);
    } else {
        $("#" + fatherId + commentId).append(str);
    }
    str = "<a href=\"javascript:void(0);\" onclick=\"delInput('input' ,'" + fatherId + "'," + replyId + ", " + commentId + ", '" + showStyle + "', '" + toUid + "')\" class=\"reply-answer js-reply-answer\">收起</a>";
    if (replyId != -1) {
        $("#" + showStyle + replyId).html(str);
    } else {
        $("#" + showStyle + commentId).html(str);
    }
}

//收起评论框  fatherId添加评论框的位置，showStyle：修改《回复，收起》状态
function delInput(input, fatherId, replyId, commentId, showStyle, toUid) {
    if (replyId != -1) {
        $("#" + input + fatherId + replyId).remove();
    } else {
        $("#" + input + fatherId + commentId).remove();
    }
    var str = "<a href=\"javascript:void(0);\" onclick=\"appendInput('" + fatherId + "', " + replyId + ", " + commentId + ", '" + showStyle + "', '" + toUid + "')\" class=\"reply-answer js-reply-answer\">回复</a>";
    if (replyId != -1) {
        $("#" + showStyle + replyId).html(str);
    } else {
        $("#" + showStyle + commentId).html(str);
    }
}

//掩藏评论
function hideHtml(id, replyId) {
    $("#" + id + replyId).toggle();
    findReplyCount(replyId);
}

//发送回复
function sendReply(commendId, replyId, toUid) {
    var textareValue = $("#textarea" + replyId).val();
    if (!textareValue) {
        alert("输入不能为空");
        return;
    }
    $.ajax({
        url: "/reply/insertReply",
        type: "post",
        async: false,
        data: {commentId: commendId, replyFatherId: replyId, replyContent: textareValue, topicId: TOPICId, toUid: toUid},
        success: function (data) {
            if (data == false) {
                alert("插入失败，。。。");
            } else {
                findReply(commendId);
                $("#textarea" + replyId).val('');
            }
        }
    });
}

//发送题目评论
function sendComment() {
    var textareValue = $("#textareaComment").val();
    if (!textareValue) {
        alert("输入不能为空");
        return;
    }
    $.ajax({
        url: "/comment/insertComment",
        type: "post",
        async: false,
        data: {commentContent: textareValue, topicId: TOPICId},
        success: function (data) {
            if (data == false) {
                alert("插入失败，。。。");
            } else {
                findComment();
                $("#textareaComment").val('');
            }
        }
    })
}

//确认是否删除提醒
function deleteReplyConfirm(replyId) {
    if (replyId == -1) {
        if (event.returnValue = confirm("删除该回复，会删除之下的所有回复，你确认要删除吗？")) {
            deleteReply(replyId);
        }
    } else {
        if (event.returnValue = confirm("确认删除？")) {
            deleteReply(replyId);
        }
    }
}

function deleteCommentConfirm(commentId) {
    if (commentId == -1) {
        if (event.returnValue = confirm("删除该回复，会删除之下的所有回复，你确认要删除吗？")) {
            deleteComment(commentId);
        }
    } else {
        if (event.returnValue = confirm("确认删除？")) {
            deleteComment(commentId);
        }
    }
}

//删除功能（评论或者回复）
function deleteComment(commentId) {
    $.ajax({
        url: "/comment/deleteCommentById",
        type: "post",
        async: false,
        data: {commentId: commentId},
        success: function (data) {
            if (!data) {
                alert("删除失败！");
            } else {
                findComment();
            }
        }
    });
}

function deleteReply(replyId) {
    $.ajax({
        url: "/reply/deleteReplyById",
        type: "post",
        async: false,
        data: {replyIds: replyId},
        success: function (data) {
            if (!data) {
                alert("删除失败！");
            } else {
                findComment();
            }
        }
    });
}

function updateIsRead(replyId) {
    $.ajax({
        url: '/reply/updateIsRead',
        type: "get",
        async: false,
        data: {replyId: replyId},
        success: function (data) {
            if (data == false) {
                alert("已读失败");
            } else {
                findNoReadReplyCount();
            }
        }
    });
}