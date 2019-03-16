function ajaxCyclic() {
    setInterval(function () {
        $.ajax({
            async: false,
            url: "/reply/getReplyCount",
            type: "get",
            contentType: "application/x-www-form-urlencoded",
            dataType: 'json',
            timeout: 20000,
            data: {isRead: 0},
            success: function (data) {
                $("#replyCount").html(data);
            }
        })
    },30000);
}

function findReplyCount() {
    $.ajax({
        async: false,
        url: "/reply/getReplyCount",
        type: "get",
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        data: {isRead: 0},
        success: function (data) {
            $("#replyCount").html(data);
        }
    })
}