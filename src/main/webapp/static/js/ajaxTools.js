function ajaxCyclic() {
    setInterval(findNoReadReplyCount,30000);
}

function findNoReadReplyCount() {
    $.ajax({
        async: true,
        url: "/reply/getReplyCount",
        type: "get",
        data: {isRead: 0},
        success: function (data) {
            $("#noReadReplyCount").html(data);
        }
    })
}