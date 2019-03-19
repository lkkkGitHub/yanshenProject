//当前页数
var replySize = "";

function getReply() {
    var tempSize = replySize;
    if (tempSize == "") {
        tempSize = 0;
        replySize = 0;
    }
    replySize++;
    $.ajax({
        url: "/reply/getReplyIsRead",
        type: "get",
        async: false,
        data: {currentSize: tempSize, isRead: 0},
        success: function (data) {
            var replyList = data.dateList;
            var str = "";
            for (var i = 0; i < replyList.length; i++) {
                var time = timeStamp2String(replyList[i].replyCreateDate);
                str += "<li id=\"reply"+replyList[i].replyId+"\" <div class=\"chat-headbox\">>";
                str += "<a class=\"list-head\" href=\"javascript:void(0);\">";
                str += "<img alt=\"头像\" src=\"https://static.nowcoder.com/images/head/notify.png\"> </a>  </div>";
                str += "<div class=\"tooltip fade right in\"> <div class=\"tooltip-arrow\"></div>";
                str += "<div class=\"tooltip-inner letter-chat clearfix\"> <div class=\"letter-info\">";
                str += " <p class=\"letter-time\">" + time + "</p>  <a href=\"javascript:void(0);\" onclick='updateIsRead("+replyList[i].replyId+")'>删除</a>";
                str += "  </div> <div class=\"chat-content\">";
                str += "你对题目<a class=\"msg-view-all\" href=\" /topicDetail?topicId=" + replyList[i].tbTopic.topicId + " \">\" " + replyList[i].tbTopic.topicComment + " \"</a>的评论收到新回复了，去看看对自己是否有用吧。";
                str += "</div> </div> </div> </li>";
            }
            $(".letter-chatlist").append(str);
            str = "";
            if (data.hasNextPage) {
                str += "<a href=\"javascript:void(0);\" onclick=\"getReply()\" class=\"btn btn-primary\">加载更多</a>";
            } else {
                str += "<a href=\"javascript:void(0);\" class=\"btn btn-primary\">已经到底了</a>";
            }
            $("#jsExeChosen").html(str);
        }
    });
}

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

function updateIsRead(replyId) {
    $.ajax({
        url: '/reply/updateIsRead',
        type: "get",
        async: false,
        data: {replyId: replyId},
        success: function (data) {
            if (data == false) {
                alert("删除失败");
            } else {
                findNoReadReplyCount();
                $("#reply"+replyId).remove();
            }
        }
    });
}