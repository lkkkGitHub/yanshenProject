function ajaxCyclic() {
    setInterval(findReplyCount,30000);
}

function findReplyCount() {
    $.ajax({
        async: true,
        url: "/reply/getReplyCount",
        type: "get",
        data: {isRead: 0},
        success: function (data) {
            $("#replyCount").html(data);
        }
    })
}