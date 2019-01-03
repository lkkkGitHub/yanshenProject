//收藏的所有题目数量
var num = "";
//当前页数
var size = "";

// 初始化分页收藏题目
function getNum() {
    var tempSize = size;
    if (tempSize == "") {
        tempSize = 0;
        size = 0;
    }
    size++;
    $.ajax({
        url: "/collection/getCollectionTopic",
        type: "get",
        async: false,
        data: {currentSize : tempSize},
        success: function (data) {
            // 收藏所有题目的数量
            num = data.totalNum;
            //加载收藏数量
            addNum();
            //加载试题
            addTopic(data.dateList);
            var str = "";
            if (data.hasNextPage) {
                str += "<a href=\"javascript:void(0);\" onclick=\"getNum()\" class=\"btn btn-primary\">加载更多</a>";
            } else {
                str += "<a href=\"javascript:void(0);\" class=\"btn btn-primary\">已经到底了</a>";
            }
            $("#jsExeChosen").html(str);
        }
    });
}

//加载收藏数量
function addNum() {
    var str = "";
    str += "<h1>收藏的试题数("+num+")</h1>";
    $("[class='module-head clearfix']").html(str);
}

//加载试题简单信息
function addTopic(topicList) {
    var str = "";
    for (var i = 0; i < topicList.length; i++) {
        var topic = topicList[i];
        str += "<li id='li"+topic.topicId+"'> <div class=\"cont-brief\"> <a href=\"/topicDetail?topicId="+topic.topicId+"\" target=\"_top\">"+topic.topicComment+"</a> </div>";
        str += "<div style='color: #1b82d6;' class=\"tags-box\">来自："+topic.classifyName+"</div>";
        str += "<div class=\"feed-legend\"> <span><a href=\"javascript:void(0);\" " +
            "class=\"link-green click-editfollow nc-req-auth\" onclick='deleteCollection("+topic.topicId+")'" +
            " data-id=\"23239\">取消收藏</a></span> ";
        str += "</div> </div> </li>";
    }
    $("#commentList").append(str);
}

//删除收藏信息
function deleteCollection(topicId) {
    $.ajax({
        url: "/collection/deleteCollection",
        type: "get",
        async: false,
        data: {topicId: topicId},
        success: function (data) {
            if (data) {
                $("#li"+topicId).remove();
                num--;
                addNum();
            }
        }
    });
}