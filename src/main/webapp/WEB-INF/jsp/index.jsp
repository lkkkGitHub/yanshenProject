<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>牛客网- 互联网求职神器和备考学习平台</title>
    <meta name="google-site-verification" content="lFSmn0rlLR-OPkas5c2GxdhTKP4J4PyaahhQ2TNanjs">
    <meta name="description"
          content="牛客网是互联网求职神器，C++、Java、前端、产品、运营技能学习/备考/求职题库，在线进行百度阿里腾讯网易等互联网名企笔试面试模拟考试练习,和牛人一起讨论经典试题,全面提升你的技术能力">
    <meta name="keywords" content="牛客网,C++笔试面试，Java笔试面试，计算机笔试,计算机面试, IT笔试,笔试题库,笔试练习,IT面试,在线编程,编程学习,牛客网">


    <script charset="utf-8" async="" src="../../static/home/js/loginedv2.js"></script>
    <script charset="utf-8" async="" src="../../static/home/js/echarts-plain.js"></script>
    <script src="../../static/person/js/jquery-1.8.3.min.js"></script>
    <link media="all" href="../../static/home/css/index.css" type="text/css" rel="stylesheet">

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <!-- favicon icon -->
    <%--<link rel="shortcut icon" type="image/png" href="favicon.ico"/>--%>
    <!-- WEB FONTS -->
    <link href="../../static/index/css/index.css" rel="stylesheet">
    <!-- Stylesheets -->
    <link rel="stylesheet" href="../../static/index/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../static/index/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../static/index/css/bootstrap-theme.min.css">
    <!-- color css -->
    <link rel="stylesheet" href="../../static/index/switcher/switcher.css"/>
    <link rel="stylesheet" href="../../static/index/css/main.css">
    <link rel="stylesheet" href="../../static/index/css/colors/blue.css">
    <script src="../../static/index/js/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    <script src="../../static/js/ajaxTools.js"></script>
</head>
<body onload="ajaxCyclic(),findReplyCount()">


<div class="nk-container     ">
    <div class="nowcoder-header">
        <div class="header-main clearfix">
            <a class="nowcoder-logo" href="/index" title="牛客网"></a>
            <ul class="nowcoder-navbar">
                <li class="active">
                    <a href="/index">首页</a>
                </li>
                <li>
                    <a href="#">题库</a>
                    <ul class="sub-nav">
                        <li><a href="javascript:void(0)" >顺序练习</a></li>
                        <li><a href="javascript:void(0)" >随机练习</a></li>
                        <li><a href="javascript:void(0)" >章节练习</a></li>
                        <li><a href="javascript:void(0)" >专项练习</a></li>
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


    <%--图片轮播--%>
    <section id="slides" class="pb">
        <div class="slides-container">
            <div class="slide active">
                <div class="img"><img src="../../static/index/images/slider/slide1.jpg" alt="slide"
                                      class="img-responsive">
                </div>
                <div class="overlay"></div>
                <div class="slide-caption">
                    <div class="container">
                        <div class="box">
                            <h1>Preparing for study</h1>
                            <span>necessary weapon!</span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end slide1 -->
            <div class="slide">
                <div class="img"><img src="../../static/index/images/slider/slide2.jpg" alt="slide"
                                      class="img-responsive">
                </div>
                <div class="overlay"></div>
                <div class="slide-caption">
                    <div class="container">
                        <div class="box">
                            <h1>necessary weapon</h1>
                            <span>Preparing for study!</span>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end slide2 -->
        </div>
        <!-- end slides-container -->
        <div class="slides-navigation">
            <a class="prev sqaureIconSec" href="#"> <i class="fa fa-chevron-left"></i></a>
            <a class="next sqaureIconSec" href="#"> <i class="fa fa-chevron-right"></i></a>
        </div>
        <!-- end slides-navigation -->
        <div class="holder">

	  <span class="scroll-btn">
		<a href="#karbar-how-it-works-section">
			<span class="mouse">
				<span>
				</span>
			</span>
		</a>
	</span>
            <i class="fa fa-chevron-down moreArrow moving"></i>
        </div>

    </section>

    <div class="ft-wrap">
        <div class="ft-cont clearfix">
            <div class="ft-app">
                <div class="ft-qrcode-box">
                    <img src="../../static/home/img/app_download.png">
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
                                <img src="59_1534321710941_41a541f87ae349e1d829b1b0b95c955d" width="110">
                                <p>扫描二维码，进入QQ群</p>
                            </div>
                        </div>
                    </a>
                    <a href="javascript:void(0);" class="ft-wx-ico">
                        <div class="tooltip top">
                            <div class="tooltip-arrow"></div>
                            <div class="tooltip-inner">
                                <img src="59_1534321725995_22162f7114ac793718cc28f7f3f8b789" width="110">
                                <p>扫描二维码，关注牛客网公众号</p>
                            </div>
                        </div>
                    </a>
                    <a href="https://weibo.com/nowcoder" class="ft-wb-ico" target="_top"></a>
                    <a href="https://www.zhihu.com/org/niu-ke-wang-53/activities" class="ft-zh-ico" target="_top"></a>
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
<img src="ghs.png" style="width: 18px; height: 18px;">
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
           href="https://www.nowcoder.com/328031526">点击查看&gt;&gt;</a>
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

<script type="text/javascript">
    seajs.use('../../static/home/js/loginedV2.js');
</script>


<div id="jsCpn_12_component_1" style="display: none;">
    <div id="jsCpn_11_component_0" class="  btn-group open" style="display: block;">
        <ul class="dropdown-menu"
            style="position: static; float: none; border-bottom: 0px none; overflow-x: hidden;"></ul>
        <div style="padding: 20px 0px; text-align: center; font-size: 14px; display: none; background: rgb(255, 255, 255) none repeat scroll 0% 0%; border: 1px solid rgb(212, 212, 212);"
             class="js-none">没有结果
        </div>
    </div>
</div>
</body>
</html>
