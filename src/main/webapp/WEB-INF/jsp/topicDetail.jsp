<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="google-site-verification" content="lFSmn0rlLR-OPkas5c2GxdhTKP4J4PyaahhQ2TNanjs">
    <meta itemprop="image" content="https://static.nowcoder.com/images/logo_87_87.png">
    <meta name="description" content="旅行商问题是NP问题吗？,高级算法专项练习">
    <meta name="keywords" content="高级算法专项练习,IT笔试,牛客网">
    <title>错题解析</title>

    <script charset="utf-8" type="text/javascript" src="../../static/didTopic/js/donequestionv2.js"></script>
    <script charset="utf-8" type="text/javascript" src="../../static/didTopic/js/index.js"></script>
    <script charset="utf-8" type="text/javascript" src="../../static/didTopic/js/kindeditor.js"></script>
    <script charset="utf-8" type="text/javascript" src="../../static/didTopic/js/highlighter.js"></script>
    <script type="text/javascript" src="../../static/didTopic/js/didTopic.js"></script>
    <script type="text/javascript" src="../../static/js/jquery-1.8.3.min.js"></script>
    <link media="all" href="../../static/didTopic/css/index.css" type="text/css" rel="stylesheet">
    <link href="../../static/didTopic/css/didTopicCss.css" type="text/css" rel="stylesheet">
    <script type="text/javascript">
        var uid = "${sessionScope.user.uid}";
        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        }
    </script>
    <script src="../../static/js/ajaxTools.js"></script>
</head>
<body onload="topicDetail(),ajaxCyclic(),findReplyCount()">

<div class="nk-container">
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
                    <ul class="sub-nav">
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
                               href="#"
                               data-unread-conv="">
                                <span class="nav-msg-num" id="replyCount">0</span>消息</a>
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
    <div class="nk-main analytic-page clearfix">
        <span><a style="color: #00A1CB" href="/collection">我的收藏></a>题目详情</span>
        <div class="menu-box">
            <ul class="menu clearfix">
                <li class="selected">题目详情</li>
            </ul>
        </div>
        <div class="module-box clearfix">
            <input id="questionType" value="1" type="hidden">
            <input id="questionId" value="25512" type="hidden">
            <span id="topicShow">
            </span>
            <ul class="oprt-tool clearfix">
                <li>

                </li>
                <li id="collection">
                    <a class="oprt-item oprt-collect click-follow nc-req-auth" href="javascript:void(0);">
                        收藏
                    </a>
                </li>
            </ul>
            <div class="result-subject-item analysis-mod">
                <h1 class="clearfix" id="clearfix">
                    <span class="analytic-discuss-num">共有3条讨论</span>
                </h1>
                <ul class="answer-list" id="commentList">
                </ul>
            </div>
            <div id="commentInput">
                <div class="reply-editbox clearfix cmt-reply-to-main" style="margin:0 auto">
                    <div class="reply-write" style="float: left"><textarea placeholder="请输入你的观点" id="textareaComment"
                                                                           class="reply-input reply-input-textarea nc-req-auth js-main-ipt"
                                                                           style="width: 798px; resize: none; height: 20px;"></textarea>
                    </div>
                    <span class="btn btn-primary reply-btn js-main-reply" onclick="sendComment()" style="float: right;"
                          href="javascript:void(0);">评论</span>
                </div>
            </div>
            <script src="../../static/didTopic/js/hm.js"></script>
        </div>

        <script src="../../static/didTopic/js/sea.js" type="text/javascript"></script>

        <script src="../../static/didTopic/js/nc.cpn.js" type="text/javascript"></script>
        <script src="../../static/didTopic/js/pc.js" type="text/javascript"></script>
        <script src="../../static/didTopic/js/base.js" type="text/javascript"></script>
        <script type="text/javascript">
            seajs.use('nowcoder/1.2.1125/javascripts/site/common/index');
            seajs.use('nowcoder/1.2.1125/javascripts/site/common/nav');
        </script>


        <script src="../../static/didTopic/js/questioncmt.js" type="text/javascript"></script>
        <script type="text/javascript">
            seajs.use('nowcoder/1.2.1125/javascripts/site/question/doneQuestionV2');
        </script>
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
                        <img src="../../static/didTopic/img/wx-rcode.jpg" alt="二维码">
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
                        <img src="../../static/didTopic/img/app.png" alt="二维码">
                        <p>下载牛客APP，随时随地刷题</p>
                    </div>
                </li>
            </ul>
            <div class="phone-qrcode" style="display: none;">
                <a href="javascript:void(0);" class="qrcode-close">x</a>
                <img src="../../static/didTopic/img/app.png" alt="二维码" style="width: 70px; height: 70px;">
                <p>扫一扫下载牛客APP</p>
            </div>
        </div>
        <div class="ft-wrap">
            <div class="ft-cont clearfix">
                <div class="ft-app">
                    <div class="ft-qrcode-box">
                        <img src="../../static/didTopic/img/app_download.png">
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
                                    <img src="../../static/didTopic/other/59_1534321710941_41a541f87ae349e1d829b1b0b95c955d"
                                         width="110">
                                    <p>扫描二维码，进入QQ群</p>
                                </div>
                            </div>
                        </a>
                        <a href="javascript:void(0);" class="ft-wx-ico">
                            <div class="tooltip top">
                                <div class="tooltip-arrow"></div>
                                <div class="tooltip-inner">
                                    <img src="../../static/didTopic/other/59_1534321725995_22162f7114ac793718cc28f7f3f8b789"
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
<img src="../../static/didTopic/img/ghs.png" style="width: 18px; height: 18px;">
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
               href="https://www.nowcoder.com/test/question/done?tid=20029048&amp;qid=25512&amp;headNav=www">点击查看&gt;&gt;</a>
        </div>

    </div>

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
<div class="js-editor-img-bar editor-img-bar" style="display: none; width: 60px;"><a href="javascript:void(0);"
                                                                                     title="放大"
                                                                                     class="icon-zoom-in"></a><a
        href="javascript:void(0);" title="缩小" class="icon-zoom-out"></a></div>
</body>
</html>
