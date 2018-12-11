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
    <link media="all" href="../../static/didTopic/css/index.css" type="text/css" rel="stylesheet">
    <link href="../../static/didTopic/css/didTopicCss.css" type="text/css" rel="stylesheet">
</head>
<body onload="initTopicToShow(0)">

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
                                <span class="nav-msg-num">0</span>消息</a>
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
        <div class="menu-box">
            <ul class="menu clearfix">
                <li class="selected">答题情况</li>
            </ul>
        </div>
        <div class="module-box clearfix">
            <div class="result-subject-item">
                <h1>每题得分</h1>
                <ul class="subject-num-list">
                    <c:forEach items="${didTopicList}" var="didTopic" varStatus="status">
                        <c:choose>
                            <c:when test="${didTopic.error == 1}">
                                <li class="error-order" onclick="initTopicToShow(${status.index})">
                                    <a class="order" id="order${status.index}"
                                       href="javascript:void(0);">${status.index + 1}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="correct-order" onclick="initTopicToShow(${status.index})">
                                    <a class="order" id="order${status.index}"
                                       href="javascript:void(0);">${status.index + 1}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <%--<li class="error-order">--%>
                    <%--<a class=""--%>
                    <%--href=""--%>
                    <%--data-qid="97246">1</a></li>--%>
                    <%--<li class="error-order">--%>
                    <%--<a class="done-hover "--%>
                    <%--href=""--%>
                    <%--data-qid="25512">2</a></li>--%>
                    <%--<li class="error-order">--%>
                    <%--<a class="" href=""--%>
                    <%--data-qid="256">3</a></li>--%>
                    <%--<li class="error-order">--%>
                    <%--<a class="" href=""--%>
                    <%--data-qid="265">4</a></li>--%>
                    <%--<li class="correct-order">--%>
                    <%--<a class="" href=""--%>
                    <%--data-qid="338">5</a></li>--%>
                </ul>
            </div>
            <input id="questionType" value="1" type="hidden">
            <input id="questionId" value="25512" type="hidden">
            <span id="topicShow">
                <%--<div class="result-question-box">--%>
                    <%--<div class="subject-question">--%>
                        <%--<div class="question-main">旅行商问题是NP问题吗？</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="result-subject-item result-subject-answer">--%>
                    <%--<h1>解析：</h1>--%>
                    <%--<div class="result-answer-item orange-answer-item">--%>
                        <%--<pre>否</pre>--%>
                    <%--</div>--%>
                    <%--<div class="result-answer-item green-answer-item">--%>
                        <%--<pre>是</pre>--%>
                    <%--</div>--%>
                    <%--<div class="result-answer-item">--%>
                        <%--<pre>至今尚无定论</pre>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div id="referAnchor"></div>--%>
            </span>
            <ul class="oprt-tool clearfix">
                <%--<li>--%>
                <%--<a href="javascript:void(0);" class="oprt-item oprt-del js-shield nc-req-auth">--%>
                <%--屏蔽本题--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="javascript:void(0);" class="oprt-item oprt-note js-add-note nc-req-auth">--%>
                <%--添加笔记--%>
                <%--</a>--%>
                <%--</li>--%>
                <li>
                    <a data-type="asking" data-count="3" class="oprt-item oprt-ask js-click-ask nc-req-auth"
                       href="javascript:void(0);">
                        求解答(3)
                    </a>
                </li>
                <li id="collection">
                    <a class="oprt-item oprt-collect click-follow nc-req-auth" href="javascript:void(0);">
                        收藏
                    </a>
                </li>
            </ul>
            <div class="result-subject-item analysis-mod">
                <h1 class="clearfix">
                    <span class="analytic-discuss-num">共有3条讨论</span>
                    <%--<a href="javascript:void(0);" id="jsDealAnswer" class="btn float-right btn-primary">添加解析</a>--%>
                </h1>
                <%--<div class="editor-box" style="display:none;height:280px;">--%>
                <%--<div id="jsEditorModuleBody" style="width:896px">--%>
                <%--<div id="jsCpn_3_component_0" style="position:relative;">--%>
                <%--<div class="ke-container ke-container-nowcoder" style="width: auto;">--%>
                <%--<div style="display: block; width: auto;" class="ke-toolbar" unselectable="on"><a--%>
                <%--class="ico-to-html js-2-md">MD编辑器</a>--%>
                <%--<div id="jsCpn_18_component_0" role="group" class="btn-group btn-group-sm">--%>
                <%--<button class="btn btn-default dropdown-toggle"><span class="dropdown-value">代码语言</span><span--%>
                <%--class="caret"></span></button>--%>
                <%--<ul class="dropdown-menu"></ul>--%>
                <%--</div>--%>
                <%--<span class="ke-outline" data-name="source" title="HTML代码" unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-source"--%>
                <%--unselectable="on"></span></span><span--%>
                <%--class="ke-inline-block ke-separator"></span><span class="ke-outline"--%>
                <%--data-name="bold"--%>
                <%--title="粗体(Ctrl+B)"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-bold"--%>
                <%--unselectable="on"></span></span><span class="ke-outline" data-name="italic"--%>
                <%--title="斜体(Ctrl+I)"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-italic"--%>
                <%--unselectable="on"></span></span><span class="ke-outline"--%>
                <%--data-name="underline"--%>
                <%--title="下划线(Ctrl+U)" unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-underline"--%>
                <%--unselectable="on"></span></span><span--%>
                <%--class="ke-inline-block ke-separator"></span><span class="ke-outline"--%>
                <%--data-name="bockquote"--%>
                <%--title="引用"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-bockquote"--%>
                <%--unselectable="on"></span></span><span class="ke-outline"--%>
                <%--data-name="insertorderedlist"--%>
                <%--title="编号" unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertorderedlist"--%>
                <%--unselectable="on"></span></span><span class="ke-outline"--%>
                <%--data-name="insertunorderedlist"--%>
                <%--title="项目符号" unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-insertunorderedlist"--%>
                <%--unselectable="on"></span></span><span--%>
                <%--class="ke-inline-block ke-separator"></span><span class="ke-outline"--%>
                <%--data-name="image"--%>
                <%--title="图片"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-image"--%>
                <%--unselectable="on"></span></span><span class="ke-outline" data-name="emoji"--%>
                <%--title="表情" unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-emoji"--%>
                <%--unselectable="on"></span></span><span--%>
                <%--class="ke-inline-block ke-separator"></span><span class="ke-outline"--%>
                <%--data-name="table"--%>
                <%--title="表格"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-table"--%>
                <%--unselectable="on"></span></span><span class="ke-outline"--%>
                <%--data-name="subscript" title="下标"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-subscript"--%>
                <%--unselectable="on"></span></span><span class="ke-outline"--%>
                <%--data-name="superscript" title="上标"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-superscript"--%>
                <%--unselectable="on"></span></span><span class="ke-outline" data-name="math"--%>
                <%--title="插入公式" unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-math"--%>
                <%--unselectable="on"></span></span><span class="ke-outline"--%>
                <%--data-name="removeformat" title="删除格式"--%>
                <%--unselectable="on"><span--%>
                <%--class="ke-toolbar-icon ke-toolbar-icon-url ke-icon-removeformat"--%>
                <%--unselectable="on"></span></span></div>--%>
                <%--<div style="display: block; height: 139px; overflow: hidden;" class="ke-edit">--%>
                <%--<iframe class="ke-edit-iframe" hidefocus="true" allowtransparency="true"--%>
                <%--frameborder="0" tabindex="" style="width: 100%; height: 139px;"></iframe>--%>
                <%--<textarea class="ke-edit-textarea" hidefocus="true" tabindex=""--%>
                <%--style="width: 100%; height: 139px; display: none;"></textarea></div>--%>
                <%--<div class="ke-statusbar"><span class="ke-inline-block ke-statusbar-center-icon"--%>
                <%--style="visibility: hidden;"></span><span--%>
                <%--class="ke-inline-block ke-statusbar-right-icon"--%>
                <%--style="visibility: hidden;"></span></div>--%>
                <%--</div>--%>
                <%--<div style="display: none;"></div>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--<div class="txtarea-foot clearfix">--%>
                <%--<a href="javascript:void(0);" class="btn float-right btn-primary click-pub-point">发表解析</a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <ul class="answer-list" id="commentList">
                    <li class="answer-list-item clearfix">
                        <div class="answer-content clearfix" data-cmt-id="1155848" data-dislikecnt="0"
                             data-isdisliked="" data-recommend="0">
                            <div class="answer-info">
                                <a href="/profile/759736" class="answer-head" data-card-uid="759736"
                                   data-card-index="1"><img
                                        src="https://images.nowcoder.com/images/20180618/759736_1529306501107_E97F9DED6CA601234AACEB9DFA543B6F@0e_100w_100h_0c_1i_1o_90Q_1x"
                                        alt=""></a>
                                <a class="answer-name 梦境迷离头像level-color-9" data-card-uid="759736" href="/profile/759736"
                                   data-card-index="2">梦境迷离</a>
                                <a href="/user/authentication" target="_blank" class=""
                                   data-title="趣头条_测试部_工具组_测试开发工程师(实习生)" data-tips-index="3"><img class="identity-icon"
                                                                                                  data-identity="2"
                                                                                                  src="//static.nowcoder.com/nc/image/identity/2.png"></a>
                            </div>
                            <div class="answer-brief">
                                我也觉得 选B &nbsp;链表的节点与节点之间当然是连续与否是无关的，，但是对于该节点内部的数据项和指针域应该是连续的
                            </div>
                            <div class="answer-legend">
                                <span class="answer-time">
                                发表于  2018-01-27 18:49:47
                                </span>
                                <a class="click-reply" href="javascript:void(0);">
                                    回复(0)
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class="answer-list-item clearfix">
                        <div class="answer-content clearfix" data-cmt-id="755452" data-dislikecnt="0" data-isdisliked=""
                             data-recommend="0">
                            <div class="answer-info">
                                <a href="/profile/3251312" class="answer-head" data-card-uid="3251312"
                                   data-card-index="3"><img
                                        src="https://images.nowcoder.com/head/149m.png@0e_100w_100h_0c_1i_1o_90Q_1x.png"
                                        alt="0xbadc0de头像"></a>
                                <a class="answer-name level-color-7" data-card-uid="3251312" href="/profile/3251312"
                                   data-card-index="4">0xbadc0de</a>
                            </div>
                            <div class="answer-brief">
                                个人认为选b，单个元素的内存地址必须连续，各元素间的内存地址不必连续。
                            </div>
                            <div class="answer-legend">
                                <span class="answer-time">
                                发表于  2017-09-08 09:55:31
                                </span>
                                <a class="click-reply" href="javascript:void(0);">
                                    回复(0)
                                </a>
                            </div>
                        </div>
                    </li>
                    <li class="answer-list-item clearfix">
                        <div class="answer-content clearfix" data-cmt-id="556450" data-dislikecnt="0" data-isdisliked=""
                             data-recommend="0">
                            <div class="answer-info">
                                <a href="/profile/223529" class="answer-head" data-card-uid="223529"
                                   data-card-index="5"><img
                                        src="https://images.nowcoder.com/images/20160303/223529_1457007518789_7C2C60506876716CCF0E706DB13D4511@0e_100w_100h_0c_1i_1o_90Q_1x"
                                        alt="杨尼玛头像"></a>
                                <a class="answer-name level-color-8" data-card-uid="223529" href="/profile/223529"
                                   data-card-index="6">杨尼玛</a>
                            </div>
                            <div class="answer-brief">
                                链表不需要存储空间连续，只需链表指针记录下一个地址即可
                            </div>
                            <div class="answer-legend">
                                <span class="answer-time">
                                发表于  2017-06-26 10:25:44
                                </span>
                                <a class="click-reply" href="javascript:void(0);">
                                    回复(2)
                                </a>
                            </div>
                            <div id="jsCpn_62_component_6" class=" reply-box">
                                <div class="reply-loading-tips js-loading" style="text-align: center; display: none;">
                                    评论加载中...
                                </div>
                                <div class="reply-container js-container" style="">
                                    <ul class="reply-list js-list" style="">
                                        <li class="ui-subcmt-item" data-id="684660">
                                            <div class="reply-main clearfix">
                                                <div class="reply-person" style="margin-right:5px;"><a
                                                        href="/profile/8816416" data-card-uid="8816416"
                                                        class="level-color-7" data-card-index="9">withoutio</a>：
                                                </div>
                                                <div class="reply-content">是不需要空间连续，但是你存储数据的地址和下一个元素的指针不应该必须连续吗</div>
                                            </div>
                                            <div class="answer-legend reply-info"><span class="reply-time">2017-08-26 20:53:50</span><a
                                                    href="javascript:void(0);"
                                                    class="reply-answer js-reply-answer">回复</a>
                                            </div>
                                        </li>
                                        <li class="ui-subcmt-item" data-id="731732">
                                            <div class="reply-main clearfix">
                                                <div class="reply-person" style="margin-right:5px;"><a
                                                        href="/profile/673221" data-card-uid="673221"
                                                        class="level-color-7" data-card-index="10">BernardKuo</a>：
                                                </div>
                                                <div class="reply-content">这里的存储单元大小是指链表中一个元素大小，不是指内存单元大小</div>
                                            </div>
                                            <div class="answer-legend reply-info"><span class="reply-time">2017-09-03 16:56:43</span><a
                                                    href="javascript:void(0);"
                                                    class="reply-answer js-reply-answer">回复</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <div class="js-pager" style="display: none;">
                                        <div id="jsCpn_63_component_6" class=" pagination" style="display: none;">
                                            <ul></ul>
                                        </div>
                                    </div>
                                    <div class="reply-editbox clearfix cmt-reply-to-main" style="margin-top:10px;">
                                        <div class="reply-write"><textarea placeholder="请输入你的观点"
                                                                           class="reply-input reply-input-textarea nc-req-auth js-main-ipt"
                                                                           style="width: 798px; resize: none; height: 20px;"></textarea>
                                        </div>
                                        <a class="btn btn-primary reply-btn js-main-reply"
                                           href="javascript:void(0);">回复</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="reply-editbox clearfix cmt-reply-to-main" style="margin-top:10px;">
                <div class="reply-write"><textarea placeholder="请输入你的观点"
                                                   class="reply-input reply-input-textarea nc-req-auth js-main-ipt"
                                                   style="width: 798px; resize: none; height: 20px;"></textarea>
                </div>
                <a class="btn btn-primary reply-btn js-main-reply"
                   href="javascript:void(0);">回复</a>
            </div>
            <h1 class="clearfix">
                <a href="/didTopic/returnHomeAndRemoveSession" id="jsDealAnswer" class="btn float-right btn-primary">返回首页</a>
            </h1>
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
