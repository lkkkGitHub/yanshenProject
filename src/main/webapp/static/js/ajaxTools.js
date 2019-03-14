function ajaxCyclic() {
    ajax({
        url: "/reply/getRedisReplyList",
        type: "get",
        async: false,
        contentType: "application/x-www-form-urlencoded",
        dataType: 'json',
        success: function (data) {

            ajaxCyclic();
        }
    });
}