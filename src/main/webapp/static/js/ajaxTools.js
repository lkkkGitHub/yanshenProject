function ajaxCyclic() {
    setInterval(function () {
        $.ajax({
            async: false,
            url: "/reply/getRedisReplyList",
            type: "get",
            contentType: "application/x-www-form-urlencoded",
            dataType: 'json',
            timeout: 20000,
            success: function (data) {

            }
        })
    },30000);
}


function findReplyCount() {
    $.ajax({
        async: false,
        url: "/reply/getRedisReplyList",
        type: "get",
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (data) {

        }
    })
}