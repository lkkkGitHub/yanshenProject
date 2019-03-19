<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <meta content="0" http-equiv="expires">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="google-site-verification" content="lFSmn0rlLR-OPkas5c2GxdhTKP4J4PyaahhQ2TNanjs">
    <meta itemprop="image" content="https://static.nowcoder.com/images/logo_87_87.png">
    <meta name="description" content="怎样更改一个文件的权限设置？,Linux专项练习,牛客网是IT求职神器,提供海量IT笔试题库,全面提升编程能力">
    <meta name="keywords" content="Linux专项练习,IT笔试,牛客网">
    <title>牛客网</title>

    <script type="text/javascript" src="../../static/js/jquery-1.8.3.min.js"></script>
    <script charset="utf-8" async="" src="../../static/answer/js/dangxuan.js"></script>
    <script charset="utf-8" async="" src="../../static/answer/js/questionutil.js"></script>
    <script charset="utf-8" async="" src="../../static/answer/js/highlighter.js"></script>
    <script charset="utf-8" async="" src="../../static/answer/js/answerJs.js"></script>
    <script src="../../static/js/ajaxTools.js"></script>
    <link media="all" href="../../static/answer/css/index.css" type="text/css" rel="stylesheet">
    <%--确认离开--%>

</head>
<body onload="start();intiTopicInfo(0, -1, -1),ajaxCyclic(),findNoReadReplyCount();">

<div class="nk-container     ">
    <div class="nowcoder-header">
        <div class="header-main clearfix">
            <a class="nowcoder-logo" href="/home" title="牛客网"></a>
            <ul class="nowcoder-navbar">
                <li class="active">
                    <a href="/home">首页</a>
                </li>
                <li>
                    <a href="#">题库</a>
                    <ul class="sub-nav">
                        <li><a href="#">顺序练习</a></li>
                        <li><a href="#">随机练习</a></li>
                        <li><a href="#">章节练习</a></li>
                        <li><a href="#">专项练习</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">学习</a>
                    <ul class="sub-nav">answer-sheet-box open
                        <li><a href="#">课程</a></li>
                        <li><a href="#">项目实战</a></li>
                        <li><a href="#">技术栈</a></li>
                    </ul>
                </li>
                <li>
                    <span class="ico-nav-new"></span>
                    <a href="#">求职</a>
                </li>
                <li>
                    <a href="#">讨论区</a>
                </li>
                <li>
                    <a href="#" target="_top">发现</a>
                    <ul class="sub-nav">
                        <li><a href="#" target="_top">竞赛</a></li>
                        <li><a href="#">Offer神器</a></li>
                        <li><a href="#">排行榜</a></li>
                        <li><a href="#">牛币兑换中心</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nowcoder-navbar nowcoder-other-nav">
                <li class="nav-search">
                    <a href="javascript:void(0);" class="icon-search js-search-btn">搜索</a>
                    <div class="newnav-search-wrap">
                        <div class="newnav-search-cont">
                            <form method="get" action="/#">
                                <input class="nav-search-txt" name="query" autocomplete="off" value="" type="text">
                                <input name="type" value="all" type="hidden">
                                <input class="nk-invisible" type="submit">
                                <a href="javascript:void(0);" class="icon-search-colse js-close-search-btn"></a>
                            </form>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="#" class="icon-mobile-phone">APP</a>
                </li>
                <c:choose>
                    <c:when test="${user!=null}">
                        <li class="nav-msg">
                            <a class="icon-envelope"
                               href="/message"
                               data-unread-conv="">
                                <span class="nav-msg-num" id="noReadReplyCount">0</span>消息</a>
                        </li>
                        <li class="profile-item">
                            <a href="/personal" class="nav-profile">
                                <div class="img-box"><img
                                        src="${imgstr}">
                                </div>
                            </a>
                            <div class="profile-hover-wrapper">
                                <div class="profile-hover-info">
                            <span>
                                 <span class="profile-hover-name">${username}</span>
                             </span>
                                    <a href="/personal" class="profile-hover-btn">个人主页</a>
                                </div>
                                <div class="item-profile-box">
                                    <a href="#" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico1"></i>
                                        我的简历
                                    </a>
                                    <a href="#" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico2"></i>
                                        刷题
                                    </a>
                                    <a href="#" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico3"></i>
                                        课程
                                    </a>
                                    <a href="#" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico4"></i>
                                        项目
                                    </a>
                                    <a href="#" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico5"></i>
                                        笔记
                                    </a>
                                    <a href="#" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico6"></i>
                                        收藏
                                    </a>
                                </div>
                                <div class="hover-accout-wrapper">
                                    <a href="/personal"><i
                                            class="hover-item-ico hover-accout-icon"></i>个人信息</a>
                                    <a href="/User/exit" class="nc-logout"><i
                                            class="hover-item-ico hover-accout-logout"></i>退出登录</a>
                                </div>
                            </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="/login">登陆</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
    <div class="nk-main  clearfix">
        <div class="module-box subject-box">
            <div class="nowcoder-topic">
                <div class="subject-progress">
                    <div class="progress">
                        <div style="width: 0%" class="progress-bar"></div>
                    </div>
                    <span class="progress-nums">1/10</span>
                    <a href="javascript:void(0);" class="progress-time" title="暂停">
                        <%--<i class="ico-time-control"></i>--%>
                        <span data-left="2592000" data-time="0" class="time-text"
                              style="font-size: 20px;"></span>
                    </a>
                </div>
                <div class="subject-title">[单选题]</div>
                <div class="subject-main">
                    <div class="subject-content">
                        <%--<div class="subject-question">--%>
                        <%--怎样更改一个文件的权限设置？--%>
                        <%--</div>--%>
                        <%--<a href="javascript:void(0);" class="subject-options selected" id="" data-id="69554">--%>
                        <%--<label class="radio checked" id="option0">--%>
                        <%--<span class="icons"></span>--%>
                        <%--<input data-toggle="radio" value="69554" type="radio">--%>
                        <%--<pre>chmod</pre>--%>
                        <%--</label>--%>
                        <%--</a>--%>
                        <%--<a href="javascript:void(0);" class="subject-options" data-id="69555">--%>
                        <%--<label class="radio" id="option1">--%>
                        <%--<span class="icons"></span>--%>
                        <%--<input data-toggle="radio" value="69555" type="radio">--%>
                        <%--<pre>file</pre>--%>
                        <%--</label>--%>
                        <%--</a>--%>
                        <%--<a href="javascript:void(0);" class="subject-options" data-id="69556">--%>
                        <%--<label class="radio" id="option2">--%>
                        <%--<span class="icons"></span>--%>
                        <%--<input data-toggle="radio" value="69556" type="radio">--%>
                        <%--<pre>attrib</pre>--%>
                        <%--</label>--%>
                        <%--</a>--%>
                        <%--<a href="javascript:void(0);" class="subject-options" data-id="69557">--%>
                        <%--<label class="radio" id="option3">--%>
                        <%--<span class="icons"></span>--%>
                        <%--<input data-toggle="radio" value="69557" type="radio">--%>
                        <%--<pre>change</pre>--%>
                        <%--</label>--%>
                        <%--</a>--%>
                    </div>
                    <div class="subject-action clearfix">
                        <div class="subject-opr">
                            <%--<span class="subject-opr-item"><i class="ico-collect"></i><a href="javascript:void(0);"--%>
                                                                                         <%--class="js-follow nc-req-auth"--%>
                                                                                         <%--data-id="53096">收藏本题</a></span>--%>
                        </div>
                        <div class="subject-next">
                            <%--<form id="submitForm" method="post"--%>
                            <%--action="https://www.nowcoder.com/question/next?pid=13625559&amp;qid=53096&amp;tid=19951551">--%>
                            <%--<input name="content" id="answer" type="hidden">--%>
                            <%--<input id="aheadFinish" name="button" class="btn warning-btn" value="提前交卷"--%>
                            <%--type="submit">--%>
                            <%--<input id="next" name="button" class="btn btn-primary" value="下一题" type="submit">--%>
                            <%--</form>--%>
                            <a href="/didTopic/commitAnswer" id="aheadFinish" name="button"
                               class="btn warning-btn">交卷</a>
                            <%--<input id="next" name="button" class="btn btn-primary" value="下一题" onclick="">--%>
                        </div>
                    </div>
                </div>
                <!-- 展开的时候加class:open -->
                <div class="answer-sheet-box open">
                    <span class="answer-box">
                        <a href="javascript:void(0)" class="card-unfold">答题卡</a>
                        <a href="javascript:void(0)" class="card-fold">展开答题卡</a>
                    </span>
                    <ul class="answer-sheet-num clearfix">
                        <%--<li><a href="javascript:void(0);" class="answering-num " data-qid="53096">1</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="answer-done " data-qid="55688">2</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="answer-done" data-qid="57362">3</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="answer-done" data-qid="55444">4</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="" data-qid="36221">5</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="" data-qid="25177">6</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="" data-qid="7270">7</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="" data-qid="56275">8</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="" data-qid="36467">9</a></li>--%>
                        <%--<li><a href="javascript:void(0);" class="" data-qid="55450">10</a></li>--%>
                        <c:forEach var="topic" items="${sessionScope.topicList}" varStatus="status">
                            <c:choose>
                                <c:when test="${status.index + 1 == 1}">
                                    <li><a href="javascript:void(0);" class="answering-num"
                                           onclick="answeringNum(${status.index}, ${fn:length(topicList)})"
                                           id="topicIndex${status.index}" data-qid="55450">${status.index + 1}</a></li>
                                </c:when>
                                <c:when test="${topic.optionId != null}">
                                    <li><a href="javascript:void(0);" class="answer-done"
                                           onclick="answeringNum(${status.index}, ${fn:length(topicList)})"
                                           id="topicIndex${status.index}" data-qid="55450">${status.index + 1}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="javascript:void(0);" class=""
                                           onclick="answeringNum(${status.index}, ${fn:length(topicList)})"
                                           id="topicIndex${status.index}" data-qid="55450">${status.index + 1}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>
                </div>

                <script src="../../static/answer/js/sea.js" type="text/javascript"></script>

                <script src="../../static/answer/js/nc.cpn.js" type="text/javascript"></script>
                <script src="../../static/answer/js/pc.js" type="text/javascript"></script>
                <script src="../../static/answer/js/base.js" type="text/javascript"></script>
                <script type="text/javascript">
                    seajs.use('nowcoder/1.2.1124/javascripts/site/common/index');
                    seajs.use('nowcoder/1.2.1124/javascripts/site/common/nav');
                </script>

                <script>
                    (function (window, undefined) {
                        seajs.use('nowcoder/1.2.1124/javascripts/site/question/dangxuan.js');
                    })(window);
                </script>
            </div>
            <input id="jsQuestionInfo" data-pid="13625559" data-tid="19951551" data-qid="53096" data-total="10"
                   data-left="10" type="hidden">
        </div>
        <div class="fixed-menu">
            <ul>
                <li>
                    <a href="javascript:void(0);" class="gotop js-nav-go-top" title="回到顶部"></a>
                </li>
                <li>
                    <a class="fixed-wb" target="_top" href="http://www.weibo.com/nowcoder"></a>
                </li>
                <li>
                    <a href="tencent://groupwpa/?subcmd=all&amp;param=7B2267726F757055696E223A3135373539343730352C2274696D655374616D70223A313431333130373737387D0A"
                       class="qq" title="QQ"></a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="wx"></a>
                    <div class="wx-qrcode">
                        <img src="../../static/answer/img/wx-rcode.jpg" alt="二维码">
                        <p>扫描二维码，关注牛客网</p>
                    </div>
                </li>
                <li>
                    <a href="https://www.nowcoder.com/discuss/30" class="feedback" title="意见反馈"></a>
                    <a href="https://www.nowcoder.com/discuss/30" class="feedback-letter">意见反馈</a>
                </li>
                <li>
                    <a href="javascript:void(0);" class="qrcode"></a>
                    <div class="wx-qrcode">
                        <img src="../../static/answer/img/app.png" alt="二维码">
                        <p>下载牛客APP，随时随地刷题</p>
                    </div>
                </li>
            </ul>
            <div class="phone-qrcode" style="display: none;">
                <a href="javascript:void(0);" class="qrcode-close">x</a>
                <img src="../../static/answer/img/app.png" alt="二维码" style="width: 70px; height: 70px;">
                <p>扫一扫下载牛客APP</p>
            </div>
        </div>
        <div class="ft-wrap">
            <div class="ft-cont clearfix">
                <div class="ft-app">
                    <div class="ft-qrcode-box">
                        <img src="../../static/answer/img/app_download.png">
                    </div>
                    <p>扫一扫，把题目装进口袋</p>
                </div>
                <dl class="ft-web-info">
                    <dt class="ft-web-name">牛客网，程序员必备求职神器</dt>
                    <dd>
                        <a href="javascript:void(0);" class="ft-qq-ico">
                            <div class="tooltip top">
                                <div class="tooltip-arrow"></div>
                                <div class="tooltip-inner">
                                    <img src="../../static/answer/other/59_1534321710941_41a541f87ae349e1d829b1b0b95c955d"
                                         width="110">
                                    <p>扫描二维码，进入QQ群</p>
                                </div>
                            </div>
                        </a>
                        <a href="javascript:void(0);" class="ft-wx-ico">
                            <div class="tooltip top">
                                <div class="tooltip-arrow"></div>
                                <div class="tooltip-inner">
                                    <img src="../../static/answer/other/59_1534321725995_22162f7114ac793718cc28f7f3f8b789"
                                         width="110">
                                    <p>扫描二维码，关注牛客网公众号</p>
                                </div>
                            </div>
                        </a>
                        <a href="https://weibo.com/nowcoder" class="ft-wb-ico" target="_top"></a>
                        <a href="https://www.zhihu.com/org/niu-ke-wang-53/activities" class="ft-zh-ico"
                           target="_top"></a>
                        <a href="https://www.jianshu.com/u/6b440373157d" class="ft-jian-ico" target="_top"></a>
                    </dd>
                </dl>
                <div class="ft-main">
                    <ul class="ft-links">
                        <li><a href="https://www.nowcoder.com/html/aboutus">关于我们</a></li>
                        <li><a href="https://www.nowcoder.com/nowcoder/recruitment">加入我们</a></li>
                        <li><a href="https://www.nowcoder.com/discuss/30">意见反馈</a></li>
                        <li><a href="https://hr.nowcoder.com/">企业服务</a></li>
                        <li><a href="https://www.nowcoder.com/html/cooperation">联系我们</a></li>
                        <li><a href="https://www.nowcoder.com/html/disclaimer">免责声明</a></li>
                        <li><a href="https://www.nowcoder.com/html/links">友情链接</a></li>
                    </ul>
                    <ul class="webrights">
                        <li>公司地址：北京市朝阳区大屯路东金泉时代3-808北京牛客科技有限公司</li>
                        <li>联系方式：010-60728802(电话) <span class="contact-email">admin@nowcoder.com</span></li>
                        <li>牛客科技©2018 All rights reserved</li>
                        <li>京ICP备14055008号-4</li>
                        <li>
                            <span style="color: rgb(169, 184, 202);">
                            <img src="../../static/answer/img/ghs.png" style="width: 18px; height: 18px;">
                            <a style="font-size: 12px;" class="ft-info-item" target="_top"
                               href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010502036488">京公网安备 11010502036488号</a>
                            </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="ad-window-sm js-global-tips" style="display: none;">
            <a href="javascript:void(0);" class="ad-close">X</a>
            <div class="ad-live-active"></div>
            <a class="link-green js-global-tips-href" target="_top"
               href="https://www.nowcoder.com/test/question/14c4cdcb25c4425cb0fdc42774241069?pid=13625559&amp;tid=19951551">点击查看&gt;&gt;</a>
        </div>

    </div>
    <script>
        window.selected = {"content": ""};
        window.isIntelligentPaper = true;
        window.canPauseTime = true;
        window.isContest = false;
        window.leaveCount = 0;
        // 问题信息
        window.questionInfo = {
            pid: '13625559',
            tid: '19951551',
            qid: '53096',
            total: '10',
            left: '10',
            type: '1'
        };
    </script>


</div>
<div id="jsCpn_1_component_0" style="display: none;">
    <div id="jsCpn_0_component_0" class="  btn-group" style="display: block; min-width: 297px;">
        <ul class="dropdown-menu js-menu"
            style="position: static; float: none; border-bottom: 0px none; overflow-x: hidden;"></ul>
        <div style="padding: 20px 0px; text-align: center; font-size: 14px; display: none; background: rgb(255, 255, 255) none repeat scroll 0% 0%; border: 1px solid rgb(212, 212, 212);"
             class="js-none">没有结果
        </div>
    </div>
</div>

<%--定时器--%>
<script>
    var hour, minute, second; //时 分 秒
    hour = minute = second = 0; //初始化
    var millisecond = 0; //毫秒
    var int;

    function start() //开始
    {
        int = setInterval(timer, 50);
    }

    function timer() //计时
    {
        millisecond = millisecond + 50;
        if (millisecond >= 1000) {
            millisecond = 0;
            second = second + 1;
        }
        if (second >= 60) {
            second = 0;
            minute = minute + 1;
        }

        if (minute >= 60) {
            minute = 0;
            hour = hour + 1;
        }
        $(".time-text").html(hour + ':' + minute + ':' + second);
    }
</script>
</body>
</html>
