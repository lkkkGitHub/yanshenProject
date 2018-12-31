<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>疯自的个人主页_牛客网</title>
    <meta name="description" content="牛客网是IT求职神器,提供海量IT笔试题库,全面提升编程能力">
    <meta name="keywords" content="个人主页,笔试练习,编程学习,牛客网">
    <script type="text/javascript" src="../../static/js/jquery-1.8.3.min.js"></script>
    <script charset="utf-8" async="" src="../../static/collection/js/ownerprofile.js"></script>
    <script charset="utf-8" async="" src="../../static/collection/js/questions.js"></script>
    <script charset="utf-8" async="" src="../../static/collection/js/popupedittag.js"></script>
    <script charset="utf-8" async="" src="../../static/collection/js/collection.js"></script>
    <link media="all" href="../../static/collection/css/index.css" type="text/css" rel="stylesheet">
</head>
<body onload="getNum()">
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
    <div class="nk-main profile-page clearfix">
        <div class="profile-info-wrapper fixed" style="display: none;">
            <div class="profile-level level1"></div>
            <div class="profile-info-main">
                <a class="head-pic  js-self-avatar ">
                    <img alt="头像"
                         src="../../static/collection/no/328031526_1533893421047_7c2c60506876716ccf0e706db13d4511@0e_200w_200h_0c_1i_1o_90q_1x">
                    <div class="change-photo"></div>
                </a>
                <div class="profile-info-cont">
                    <section>
                        <a class="profile-user-name level-color-7" href="javascript:void(0);" data-title="疯自"
                           data-tips-index="3">疯自</a>
                        <span>
                        <a href="https://www.nowcoder.com/user/authentication" target="_top" class="profile-noauth" data-title="点击图标，点亮职业身份"
                           data-tips-index="4"><img class="identity-icon" data-identity="" src="../../static/collection/img/0.png"></a>
                        </span>
                    </section>
                    <ul class="profile-cont clearfix">
                        <li class="profile-city"><i class="ico-pcity"></i>未填写所在地区</li>
                        <li class="profile-work"><i class="ico-pwork"></i>道一</li>
                        <li class="profile-edu"><i class="ico-pedu"></i>吉首大学</li>
                        <li class="work-authentica"><i class="ico-auth"></i>暂未认证<a
                                href="https://www.nowcoder.com/user/authentication" class="link-green">点击申请 &gt; </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="profile-oprt-box">
                <a class="btn btn-primary btn-sm" href="https://www.nowcoder.com/profile/328031526/basicinfo#menubox"><i
                        class="icon-pencil"></i>编辑</a>
                <a href="javascript:void(0);" class="btn btn-primary btn-sm js-log-clock nc-req-auth" data-count="0"><i
                        class="icon-time"></i>打卡</a>
            </div>
        </div>
        <script src="../../static/collection/js/hm.js"></script>
        <script>
        </script>

        <div class="nk-content">
            <div class="module-box">

                <div class="module-head clearfix">
                    <h1>收藏的试题数(23)</h1>
                </div>
                <div class="module-body">
                    <ul class="common-list" id="commentList">
                        <%--<li>--%>
                            <%--<div class="cont-brief">--%>
                                <%--<a href="https://www.nowcoder.com/profile/328031526/myFollowings/detail/7095788"--%>
                                   <%--target="_top">增加一个用户的命令是什么</a>--%>
                            <%--</div>--%>
                            <%--<div class="tags-box">--%>
                                <%--<a href="https://www.nowcoder.com/questionCenter?mutiTagIds=618" class="tag-label"--%>
                                   <%--target="_top">Linux</a>--%>
                            <%--</div>--%>
                            <%--<div class="feed-foot">--%>
                                <%--<div class="feed-origin">--%>
                                    <%--<span>--%>
                                    <%--来自<a href="https://www.nowcoder.com/test/13484/summary" target="_top">运维工程师能力评估</a>--%>
                                    <%--</span>--%>
                                <%--</div>--%>
                                <%--<div class="feed-legend">--%>
                                    <%--<span><a href="javascript:void(0);" class="link-green click-editfollow nc-req-auth"--%>
                                             <%--data-id="23239">编辑收藏</a></span>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                    </ul>
                    <div class="statistical-list-btn" id="jsExeChosen">
                        <a href="javascript:void(0);" onclick="" class="btn btn-primary">加载更多</a>
                    </div>
                    <%--<div class="pagination">--%>
                        <%--<div class="pagination">--%>
                            <%--<ul data-total="3">--%>
                                <%--<li class="txt-pager disabled js-first-pager"><a data-page="1"--%>
                                                                                 <%--href="javascript:void(0)">首页</a></li>--%>
                                <%--<li class="txt-pager disabled js-pre-pager"><a data-page="1" href="javascript:void(0)">上一页</a>--%>
                                <%--</li>--%>
                                <%--<li class="active js-1-pager"><a href="javascript:void(0)" data-page="1">1</a></li>--%>
                                <%--<li class="js-2-pager"><a--%>
                                        <%--href="https://www.nowcoder.com/profile/328031526/myFollowings?tags=&amp;page=2"--%>
                                        <%--data-page="2">2</a></li>--%>
                                <%--<li class="js-3-pager"><a--%>
                                        <%--href="https://www.nowcoder.com/profile/328031526/myFollowings?tags=&amp;page=3"--%>
                                        <%--data-page="3">3</a></li>--%>
                                <%--<li class="txt-pager js-next-pager"><a data-page="2"--%>
                                                                       <%--href="https://www.nowcoder.com/profile/328031526/myFollowings?tags=&amp;page=2">下一页</a>--%>
                                <%--</li>--%>
                                <%--<li class="txt-pager js-last-pager"><a data-page="3"--%>
                                                                       <%--href="https://www.nowcoder.com/profile/328031526/myFollowings?tags=&amp;page=3">末页</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
        <div class="fixed-menu" style="display: block; bottom: 132px;">
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
                        <img src="../../static/collection/img/wx-rcode.jpg" alt="二维码">
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
                        <img src="../../static/collection/img/app.png" alt="二维码">
                        <p>下载牛客APP，随时随地刷题</p>
                    </div>
                </li>
            </ul>
        </div>
        <div class="ft-wrap">
            <div class="ft-cont clearfix">
                <div class="ft-app">
                    <div class="ft-qrcode-box">
                        <img src="../../static/collection/img/app_download.png">
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
                                    <img src="../../static/collection/no/59_1534321710941_41a541f87ae349e1d829b1b0b95c955d"
                                         width="110">
                                    <p>扫描二维码，进入QQ群</p>
                                </div>
                            </div>
                        </a>
                        <a href="javascript:void(0);" class="ft-wx-ico">
                            <div class="tooltip top">
                                <div class="tooltip-arrow"></div>
                                <div class="tooltip-inner">
                                    <img src="../../static/collection/no/59_1534321725995_22162f7114ac793718cc28f7f3f8b789"
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
                        <li>公司地址：北京市朝阳区大屯路东金泉时代3-2708北京牛客科技有限公司</li>
                        <li>联系方式：010-60728802(电话) <span class="contact-email">admin@nowcoder.com</span></li>
                        <li>牛客科技©2018 All rights reserved</li>
                        <li>京ICP备14055008号-4</li>
                        <li>
                            <span style="color: rgb(169, 184, 202);">
                            <img src="../../static/collection/img/ghs.png" style="width: 18px; height: 18px;">
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
               href="https://www.nowcoder.com/profile/328031526/myFollowings">点击查看&gt;&gt;</a>
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
<div id="jsCpn_3_component_1" style="display: none;">
    <div id="jsCpn_2_component_0" style="overflow: hidden; cursor: pointer; width: 60px; height: 60px;"><input
            class="  js-upload" style="display: block; opacity: 0; cursor: pointer; width: 60px; height: 60px;"
            type="file"></div>
</div>
<div id="jsCpn_5_component_2" style="display: none;">
    <div id="jsCpn_4_component_1" style="overflow: hidden; cursor: pointer; width: 40px; height: 40px;"><input
            class="  js-upload" style="display: block; opacity: 0; cursor: pointer; width: 40px; height: 40px;"
            type="file"></div>
</div>
</body>
</html>
