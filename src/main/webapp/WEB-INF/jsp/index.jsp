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


    <script charset="utf-8" async="" src="../../static/index/js/loginedv2.js"></script>
    <script charset="utf-8" async="" src="../../static/index/js/echarts-plain.js"></script>
    <link media="all" href="../../static/index/css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="nk-container     ">
    <div class="nowcoder-header">
        <div class="header-main clearfix">
            <a class="nowcoder-logo" href="https://www.nowcoder.com/" title="牛客网"></a>
            <ul class="nowcoder-navbar">
                <li class="active">
                    <a href="https://www.nowcoder.com/">首页</a>
                </li>
                <li>
                    <a href="https://www.nowcoder.com/contestRoom">题库</a>
                    <ul class="sub-nav">
                        <li><a href="https://www.nowcoder.com/contestRoom">公司真题</a></li>
                        <li><a href="https://www.nowcoder.com/intelligentTest">专项练习</a></li>
                        <li><a href="https://www.nowcoder.com/activity/oj">在线编程</a></li>
                        <li><a href="https://www.nowcoder.com/mockexam/MockExam">模拟笔试</a></li>
                        <li><a href="https://www.nowcoder.com/schoolbooks">教材全解</a></li>
                        <li><a href="https://www.nowcoder.com/kaoyan">考研真题</a></li>
                        <li><a href="https://www.nowcoder.com/finalexam">期末考题</a></li>
                        <li><a href="https://www.nowcoder.com/activity/topics">精华专题</a></li>
                        <li><a href="https://www.nowcoder.com/questionCenter">试题广场</a></li>
                    </ul>
                </li>
                <li>
                    <a href="https://www.nowcoder.com/courses">学习</a>
                    <ul class="sub-nav">
                        <li><a href="https://www.nowcoder.com/courses">课程</a></li>
                        <li><a href="https://www.nowcoder.com/project/recommend">项目实战</a></li>
                        <li><a href="https://www.nowcoder.com/stacks">技术栈</a></li>
                    </ul>
                </li>
                <li>
                    <span class="ico-nav-new"></span>
                    <a href="https://www.nowcoder.com/recommend">求职</a>
                </li>
                <li>
                    <a href="https://www.nowcoder.com/discuss">讨论区</a>
                </li>
                <li>
                    <a href="https://ac.nowcoder.com/acm/contest/vip-index" target="_top">发现</a>
                    <ul class="sub-nav">
                        <li><a href="https://ac.nowcoder.com/acm/contest/vip-index" target="_top">竞赛</a></li>
                        <li><a href="https://www.nowcoder.com/show-offer/index">Offer神器</a></li>
                        <li><a href="https://www.nowcoder.com/ranking">排行榜</a></li>
                        <li><a href="https://www.nowcoder.com/coin/index">牛币兑换中心</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nowcoder-navbar nowcoder-other-nav">
                <li class="nav-search">
                    <a href="javascript:void(0);" class="icon-search js-search-btn">搜索</a>
                    <div class="newnav-search-wrap">
                        <div class="newnav-search-cont">
                            <form method="get" action="https://www.nowcoder.com/search">
                                <input class="nav-search-txt" name="query" autocomplete="off" value="" type="text">
                                <input name="type" value="all" type="hidden">
                                <input class="nk-invisible" type="submit">
                                <a href="javascript:void(0);" class="icon-search-colse js-close-search-btn"></a>
                            </form>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="https://www.nowcoder.com/app" class="icon-mobile-phone">APP</a>
                </li>
                <c:choose>
                    <c:when test="${user!=null}">
                        <li class="nav-msg">
                            <a class="icon-envelope"
                               href="https://www.nowcoder.com/sns/message/328031526/conversation-list?type=1"
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
                                    <a href="https://www.nowcoder.com/profile" class="profile-hover-btn">个人主页</a>
                                </div>
                                <div class="item-profile-box">
                                    <a href="https://www.nowcoder.com/profile/328031526/resume" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico1"></i>
                                        我的简历
                                    </a>
                                    <a href="https://www.nowcoder.com/profile/328031526/tests" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico2"></i>
                                        刷题
                                    </a>
                                    <a href="https://www.nowcoder.com/profile/328031526/courses" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico3"></i>
                                        课程
                                    </a>
                                    <a href="https://www.nowcoder.com/profile/328031526/project/mine" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico4"></i>
                                        项目
                                    </a>
                                    <a href="https://www.nowcoder.com/profile/328031526/note" class="item-profile">
                                        <i class="hover-item-ico hover-item-ico5"></i>
                                        笔记
                                    </a>
                                    <a href="https://www.nowcoder.com/profile/328031526/myFollowings" class="item-profile">
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
    <div class="nk-main clearfix">
        <!--主体内容-->
        <div class="nk-content">
            <div class="module-box home-items">
                <a class="real-exercise" href="https://www.nowcoder.com/contestRoom">
                    <i></i>
                    <h2 class="new-items-txt">真题练习</h2>
                </a>
                <a class="devote-exercise" href="https://www.nowcoder.com/intelligentTest">
                    <i></i>
                    <h2 class="new-items-txt">专项练习</h2>
                </a>
                <a class="wrong-exercise" href="https://www.nowcoder.com/profile/328031526/wrongset">
                    <i></i>
                    <h2 class="new-items-txt">错题练习</h2>
                </a>
                <a class="subject-exercise" href="https://www.nowcoder.com/activity/oj">
                    <i></i>
                    <h2 class="new-items-txt">在线编程</h2>
                </a>
                <a class="check-discuss" href="https://www.nowcoder.com/profile/328031526/courses">
                    <i></i>
                    <h2 class="new-items-txt">课程学习</h2>
                </a>
                <a class="items-collect" href="https://www.nowcoder.com/profile/328031526/myFollowings">
                    <i></i>
                    <h2 class="new-items-txt">我的收藏</h2>
                </a>
            </div>
            <div class="module-box mod-setting  mod-setting-hidden " id="jsPartSetTag">
                <div class="mod-set-oprt">
                    <a href="javascript:void(0);" class="icon-home-sort js-oprt-tab">排序</a>
                    <span class="mod-set-pipe">|</span>
                    <a href="javascript:void(0);" class="ico-setting  js-oprt-tab">设置</a>
                </div>
                <div class="mod-choice-body">
                    <div class="arrow-up-box">
                        <i class="arrow-up"></i>
                        <i class="arrow-up-min"></i>
                    </div>
                    <div class="module-head clearfix">
                        <h1>选择你感兴趣的内容，以下内容的更新将出现在你的首页。</h1>
                    </div>
                    <div class="module-body">
                        <dl class="home-tags-mod">
                            <dt class="htm-head">职位</dt>
                            <dd class="tags-box js-type-job">
                                <a href="javascript:void(0);" class="tag-label selected" data-id="639">Java工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="640">C++工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="641">iOS工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="642">安卓工程师</a>
                                <a href="javascript:void(0);" class="tag-label selected" data-id="643">运维工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="644">前端工程师</a>
                                <a href="javascript:void(0);" class="tag-label selected" data-id="645">算法工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="649">PHP工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="680">测试工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="682">安全工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="683">C#工程师</a>
                                <a href="javascript:void(0);" class="tag-label selected" data-id="684">数据库工程师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="894">数据分析师</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="891">产品</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="892">运营</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="685">其它</a>
                            </dd>
                        </dl>
                        <dl class="home-tags-mod">
                            <dt class="htm-head">公司</dt>
                            <dd class="tags-box js-type-company">
                                <a href="javascript:void(0);" class="tag-label" data-id="134">阿里巴巴</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="138">腾讯</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="139">百度</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="140">人人</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="141">去哪儿</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="144">Google</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="146">微软</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="147">小米</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="148">搜狐</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="149">网易</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="151">京东</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="153">携程</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="157">奇虎360</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="160">完美世界</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="171">迅雷</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="179">美团</a>
                            </dd>
                        </dl>
                        <dl class="home-tags-mod">
                            <dt class="htm-head">编程专题</dt>
                            <dd class="tags-box js-type-topic">
                                <a href="javascript:void(0);" class="tag-label" data-id="6">剑指offer</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="7">PAT</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="12">程序员面试金典</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="9">前端大挑战</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="11">JS测评</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="13">编程马拉松</a>
                            </dd>
                        </dl>
                        <dl class="home-tags-mod">
                            <dt class="htm-head">文章</dt>
                            <dd class="tags-box js-type-discuss">
                                <a href="javascript:void(0);" class="tag-label" data-id="2">笔经面经</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="1">技术交流</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="5">资源分享</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="7">求职招聘</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="4">站内公告</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="3">随便聊聊</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="6">我要提问</a>
                                <a href="javascript:void(0);" class="tag-label" data-id="9">工作感受</a>
                            </dd>
                        </dl>
                        <div class="model-btn-box">
                            <a href="javascript:void(0);" class="btn btn-primary">保存并收起</a>
                            <a href="javascript:void(0);" class="btn btn-default">重 选</a>
                        </div>
                    </div>
                </div>
                <div class="mod-sort-body">
                    <div class="arrow-up-box">
                        <i class="arrow-up"></i>
                        <i class="arrow-up-min"></i>
                    </div>
                    <div class="module-head clearfix">
                        <h1>拖动下面的模块到你想要的位置</h1>
                        <div class="float-right">
                            <a href="javascript:void(0);" class="btn btn-primary">保存</a>
                            <a href="javascript:void(0);" class="btn btn-default">取消</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- mod-toggle默认添加open,当去掉open时模块内容隐藏 -->
            <div class="module-box mod-toggle  open" id="jsPartSetSkill" data-type="1">
                <div class="module-head clearfix">
                    <h1>专项练习</h1>
                    <a href="javascript:void(0);" class="icon-drag"></a>
                </div>
                <div class="module-body">
                    <div class="model-count">
                        <div class="count-item">
                            <span>共刷题：</span>
                            <a href="javascript:void(0);">1020题</a>
                        </div>
                        <div class="count-item">
                            <span>做对题目：</span>
                            <a href="javascript:void(0);">693题</a>
                        </div>
                        <div class="count-item">
                            <span>最近一周平均分：</span>
                            <a href="javascript:void(0);">56</a>
                        </div>
                        <div class="count-item">
                            <span>排名：</span>
                            <!-- 切换相应class出现3种不同效果count-rank-up、count-rank、count-rank-down -->
                            <a chref="javascript:void(0);">3376</a>
                        </div>
                    </div>
                    <div class="statistical-list">
                        <div class="statistical-item statistical-item-head clearfix">
                            <div class="s-item-cell s-checkbox"></div>
                            <div class="s-item-cell s-column1">最近练习知识点</div>
                            <div class="s-item-cell s-column2">做题数/题目总数</div>
                            <div class="s-item-cell s-column3">正确率</div>
                        </div>
                        <div class="statistical-item clearfix js-statistical-item" data-id="570">
                            <div class="s-item-cell s-checkbox">
                                <label class="checkbox" id="jsCpn_4_checkbox_2">
                                    <span class="icons"></span>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <div class="s-item-cell s-column1">Java</div>
                            <div class="s-item-cell s-column2">967
                                /967
                            </div>
                            <div class="s-item-cell s-column3">68%</div>
                            <div class="s-item-cell s-column4">
                                <form class="form-box" method="post"
                                      action="https://www.nowcoder.com/makePaper?tagIds=570">
                                    <button data-left="303" class="btn btn-primary nc-js-make-paper">专项练习</button>
                                </form>
                            </div>
                            <div class="s-item-oprt">
                                <a class="js-del-skill" href="javascript:void(0);">删除</a>
                            </div>
                        </div>
                        <div class="statistical-item clearfix js-statistical-item" data-id="636">
                            <div class="s-item-cell s-checkbox">
                                <label class="checkbox" id="jsCpn_5_checkbox_3">
                                    <span class="icons"></span>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <div class="s-item-cell s-column1">并发</div>
                            <div class="s-item-cell s-column2">15
                                /46
                            </div>
                            <div class="s-item-cell s-column3">33%</div>
                            <div class="s-item-cell s-column4">
                                <form class="form-box" method="post"
                                      action="https://www.nowcoder.com/makePaper?tagIds=636">
                                    <button data-left="41" class="btn btn-primary nc-js-make-paper">专项练习</button>
                                </form>
                            </div>
                            <div class="s-item-oprt">
                                <a class="js-del-skill" href="javascript:void(0);">删除</a>
                            </div>
                        </div>
                        <div class="statistical-item clearfix js-statistical-item" data-id="637">
                            <div class="s-item-cell s-checkbox">
                                <label class="checkbox" id="jsCpn_6_checkbox_4">
                                    <span class="icons"></span>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <div class="s-item-cell s-column1">Spring</div>
                            <div class="s-item-cell s-column2">24
                                /24
                            </div>
                            <div class="s-item-cell s-column3">87%</div>
                            <div class="s-item-cell s-column4">
                                <form class="form-box" method="post"
                                      action="https://www.nowcoder.com/makePaper?tagIds=637">
                                    <button data-left="3" class="btn btn-primary nc-js-make-paper">专项练习</button>
                                </form>
                            </div>
                            <div class="s-item-oprt">
                                <a class="js-del-skill" href="javascript:void(0);">删除</a>
                            </div>
                        </div>
                        <div class="statistical-item clearfix js-statistical-item" data-id="606" style="display: none;">
                            <div class="s-item-cell s-checkbox">
                                <label class="checkbox" id="jsCpn_7_checkbox_5">
                                    <span class="icons"></span>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <div class="s-item-cell s-column1">数据库</div>
                            <div class="s-item-cell s-column2">16
                                /1878
                            </div>
                            <div class="s-item-cell s-column3">56%</div>
                            <div class="s-item-cell s-column4">
                                <form class="form-box" method="post"
                                      action="https://www.nowcoder.com/makePaper?tagIds=606">
                                    <button data-left="1869" class="btn btn-primary nc-js-make-paper">专项练习</button>
                                </form>
                            </div>
                            <div class="s-item-oprt">
                                <a class="js-del-skill" href="javascript:void(0);">删除</a>
                            </div>
                        </div>
                        <div class="statistical-item clearfix js-statistical-item" data-id="598" style="display: none;">
                            <div class="s-item-cell s-checkbox">
                                <label class="checkbox" id="jsCpn_8_checkbox_6">
                                    <span class="icons"></span>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <div class="s-item-cell s-column1">高级算法</div>
                            <div class="s-item-cell s-column2">7
                                /74
                            </div>
                            <div class="s-item-cell s-column3">57%</div>
                            <div class="s-item-cell s-column4">
                                <form class="form-box" method="post"
                                      action="https://www.nowcoder.com/makePaper?tagIds=598">
                                    <button data-left="70" class="btn btn-primary nc-js-make-paper">专项练习</button>
                                </form>
                            </div>
                            <div class="s-item-oprt">
                                <a class="js-del-skill" href="javascript:void(0);">删除</a>
                            </div>
                        </div>
                        <div class="statistical-item clearfix js-statistical-item" data-id="578" style="display: none;">
                            <div class="s-item-cell s-checkbox">
                                <label class="checkbox" id="jsCpn_9_checkbox_7">
                                    <span class="icons"></span>
                                    <input type="checkbox">
                                </label>
                            </div>
                            <div class="s-item-cell s-column1">数组</div>
                            <div class="s-item-cell s-column2">15
                                /318
                            </div>
                            <div class="s-item-cell s-column3">53%</div>
                            <div class="s-item-cell s-column4">
                                <form class="form-box" method="post"
                                      action="https://www.nowcoder.com/makePaper?tagIds=578">
                                    <button data-left="310" class="btn btn-primary nc-js-make-paper">专项练习</button>
                                </form>
                            </div>
                            <div class="s-item-oprt">
                                <a class="js-del-skill" href="javascript:void(0);">删除</a>
                            </div>
                        </div>
                    </div>
                    <div class="statistical-more">
                        <a href="javascript:void(0);" class="icon-angle-up js-skill-angle"></a>
                        <a href="javascript:void(0);" class="icon-angle-down js-skill-angle"></a>
                    </div>
                    <div class="statistical-list-btn">
                        <a href="javascript:void(0);" id="jsExeChosen" class="btn btn-primary">练习选中技能</a>
                        <a href="javascript:void(0);" id="jsExeOther" class="btn btn-default">练习其他技能</a>
                    </div>
                </div>
            </div>
            <%--<div class="module-box mod-toggle open" data-type="2">--%>
                <%--<div class="module-head clearfix">--%>
                    <%--<h1>公司真题练习</h1>--%>
                    <%--<a href="javascript:void(0);" class="icon-drag"></a>--%>
                <%--</div>--%>
                <%--<div class="module-body">--%>
                    <%--<ul class="content-item-box clearfix">--%>
                        <%--<li>--%>
                            <%--<div class="content-item-brief">--%>
                                <%--<a href="https://www.nowcoder.com/test/12398581/summary">--%>
                                    <%--<!-- <div class="done-tag"></div> -->--%>
                                    <%--<h1>2018迅雷校园招聘计算机视觉在线笔试B卷</h1>--%>
                                    <%--<div class="web-logoimg">--%>
                                        <%--<img src="../../static/index/img/40.png">--%>
                                    <%--</div>--%>
                                    <%--<div class="exam-foot">热度指数：2146</div>--%>
                                    <%--<div class="brief-mask"></div>--%>
                                    <%--<dl class="exam-info">--%>
                                        <%--<dd>题目数量:27道</dd>--%>
                                        <%--<dd>试卷平均分:6分</dd>--%>
                                        <%--<dd class="exam-btn">--%>
                                            <%--<span class="btn btn-block btn-primary">马上练习</span>--%>
                                        <%--</dd>--%>
                                    <%--</dl>--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div class="difficulty">--%>
                                <%--<span class="item-label">难度系数：</span>--%>
                                <%--<span title="难度系数" class="stars-new star-3"></span>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="content-item-brief">--%>
                                <%--<a href="https://www.nowcoder.com/test/12398504/summary">--%>
                                    <%--<!-- <div class="done-tag"></div> -->--%>
                                    <%--<h1>2018迅雷校园招聘计算机视觉在线笔试A卷</h1>--%>
                                    <%--<div class="web-logoimg">--%>
                                        <%--<img src="../../static/index/img/40.png">--%>
                                    <%--</div>--%>
                                    <%--<div class="exam-foot">热度指数：1202</div>--%>
                                    <%--<div class="brief-mask"></div>--%>
                                    <%--<dl class="exam-info">--%>
                                        <%--<dd>题目数量:27道</dd>--%>
                                        <%--<dd>试卷平均分:6分</dd>--%>
                                        <%--<dd class="exam-btn">--%>
                                            <%--<span class="btn btn-block btn-primary">马上练习</span>--%>
                                        <%--</dd>--%>
                                    <%--</dl>--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div class="difficulty">--%>
                                <%--<span class="item-label">难度系数：</span>--%>
                                <%--<span title="难度系数" class="stars-new star-3"></span>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                        <%--<li>--%>
                            <%--<div class="content-item-brief">--%>
                                <%--<a href="https://www.nowcoder.com/test/12398104/summary">--%>
                                    <%--<!-- <div class="done-tag"></div> -->--%>
                                    <%--<h1>2018迅雷校园招聘C++在线笔试A卷</h1>--%>
                                    <%--<div class="web-logoimg">--%>
                                        <%--<img src="../../static/index/img/40.png">--%>
                                    <%--</div>--%>
                                    <%--<div class="exam-foot">热度指数：1427</div>--%>
                                    <%--<div class="brief-mask"></div>--%>
                                    <%--<dl class="exam-info">--%>
                                        <%--<dd>题目数量:27道</dd>--%>
                                        <%--<dd>试卷平均分:5分</dd>--%>
                                        <%--<dd class="exam-btn">--%>
                                            <%--<span class="btn btn-block btn-primary">马上练习</span>--%>
                                        <%--</dd>--%>
                                    <%--</dl>--%>
                                <%--</a>--%>
                            <%--</div>--%>
                            <%--<div class="difficulty">--%>
                                <%--<span class="item-label">难度系数：</span>--%>
                                <%--<span title="难度系数" class="stars-new star-3"></span>--%>
                            <%--</div>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%--<div class="model-btn-box">--%>
                        <%--<a href="https://www.nowcoder.com/contestRoom?filter=2&amp;page=1"--%>
                           <%--class="btn btn-block btn-primary">查看全部未练习试卷</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="module-box mod-toggle open" data-type="3">--%>
                <%--<div class="module-head clearfix">--%>
                    <%--<h1>在线编程练习</h1>--%>
                    <%--<a href="javascript:void(0);" class="icon-drag"></a>--%>
                <%--</div>--%>
                <%--<div class="module-body">--%>
                    <%--<div class="model-count">--%>
                        <%--<div class="count-item">--%>
                            <%--<span>共刷题：</span>--%>
                            <%--<a href="javascript:void(0);">0题</a>--%>
                        <%--</div>--%>
                        <%--<div class="count-item">--%>
                            <%--<span>做对题目：</span>--%>
                            <%--<a href="javascript:void(0);">0</a>--%>
                        <%--</div>--%>
                        <%--<div class="count-item">--%>
                            <%--<span>最近一周做对题目：</span>--%>
                            <%--<a href="javascript:void(0);">0</a>--%>
                        <%--</div>--%>
                        <%--<div class="count-item">--%>
                            <%--<span>排名：</span>--%>
                            <%--<a href="javascript:void(0);">0</a>--%>
                            <%--<!-- 切换相应class出现3种不同效果count-rank-up、count-rank、count-rank-down -->--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<table>--%>
                        <%--<tbody>--%>
                        <%--<tr>--%>
                            <%--<th style="padding-left: 30px;" width="300">题目</th>--%>
                            <%--<th width="160">来自专题</th>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="offer-pot"><a href="https://www.nowcoder.com/pat/6/problem/4077" target="_top">A+B和C--%>
                                <%--(15)</a></td>--%>
                            <%--<td class="txt-left"><a href="https://www.nowcoder.com/pat">PAT真题在线练习</a></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="offer-pot"><a href="https://www.nowcoder.com/pat/6/problem/4078" target="_top">数字分类--%>
                                <%--(20)</a></td>--%>
                            <%--<td class="txt-left"><a href="https://www.nowcoder.com/pat">PAT真题在线练习</a></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="offer-pot"><a href="https://www.nowcoder.com/pat/6/problem/4079" target="_top">数素数--%>
                                <%--(20)</a></td>--%>
                            <%--<td class="txt-left"><a href="https://www.nowcoder.com/pat">PAT真题在线练习</a></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="offer-pot"><a href="https://www.nowcoder.com/pat/6/problem/4040" target="_top">福尔摩斯的约会--%>
                                <%--(20)</a></td>--%>
                            <%--<td class="txt-left"><a href="https://www.nowcoder.com/pat">PAT真题在线练习</a></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td class="offer-pot"><a href="https://www.nowcoder.com/pat/6/problem/4041" target="_top">德才论--%>
                                <%--(25)</a></td>--%>
                            <%--<td class="txt-left"><a href="https://www.nowcoder.com/pat">PAT真题在线练习</a></td>--%>
                        <%--</tr>--%>
                        <%--</tbody>--%>
                    <%--</table>--%>
                    <%--<a href="https://www.nowcoder.com/activity/topics" class="btn btn-block btn-primary">查看全部专题</a>--%>
                <%--</div>--%>

        </div>
        <div class="nk-bar">
            <div class="module-box">
                <div class="sign-mod clearfix">
                    <div class="sign-time">
                        <div class="sign-week">周四</div>
                        <div>11-01</div>
                    </div>
                    <div class="sign-main">
                        <div class="sign-info">
                            <p>已打卡<span><a href="https://www.nowcoder.com/profile/328031526/clockInfo">0</a></span>天</p>
                            <p>排名<span>0</span></p>
                        </div>
                        <a href="javascript:void(0);" class="btn btn-primary js-log-clock nc-req-auth" data-count="0">今日打卡</a>
                    </div>
                </div>
            </div>
            <div class="module-box complete-info-box">
                <p class="complete-tip">完善信息，快速找到战友！</p>
                <div class="complete-identity">
                    <div class="clearfix">
                        <label class="radio" id="jsCpn_2_checkbox_0">
                            <span class="icons"></span>
                            <input value="1" type="radio">我还在上学
                        </label>
                        <label class="radio checked" id="jsCpn_3_checkbox_1">
                            <span class="icons"></span>
                            <input value="2" checked="checked" type="radio">我已经工作
                        </label>
                    </div>
                    <div class="control-group" id="jsInfoSchool">
                        <input value="吉首大学" placeholder="毕业的学校" type="text">
                        <i class="input-icon fui-cross"></i><i class="input-icon fui-check-inverted"></i><span
                            class="input-tip"></span></div>
                    <div class="control-group" id="jsInfoCompany">
                        <input value="" placeholder="效力的公司" type="text">
                        <i class="input-icon fui-cross"></i><i class="input-icon fui-check-inverted"></i><span
                            class="input-tip"></span></div>
                    <div class="control-group" id="jsInfoJobNow">
                        <a href="javascript:void(0);" id="jsInfoJobIpt" class="jobs-choose">从事或感兴趣的工作</a>
                        <div class="tags-box complete-tag-box">
                            <a href="javascript:void(0);" class="tag-label  selected " data-id="639">Java工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="640">C++工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="641">iOS工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="642">安卓工程师</a>
                            <a href="javascript:void(0);" class="tag-label  selected " data-id="643">运维工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="644">前端工程师</a>
                            <a href="javascript:void(0);" class="tag-label  selected " data-id="645">算法工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="649">PHP工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="680">测试工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="682">安全工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="683">C#工程师</a>
                            <a href="javascript:void(0);" class="tag-label  selected " data-id="684">数据库工程师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="894">数据分析师</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="891">产品</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="892">运营</a>
                            <a href="javascript:void(0);" class="tag-label " data-id="685">其它</a>
                        </div>
                    </div>
                    <a href="javascript:void(0);" class="btn btn-block btn-primary">确定</a>
                </div>
            </div>
            <div class="module-box side-profile-box">
                <div class="side-profile-info">
                    <div class="side-profile-avatar">
                        <a class="side-profile-pic" data-card-uid="328031526"
                           href="https://www.nowcoder.com/profile/328031526" data-card-index="21">
                            <img src="../../static/index/328031526_1533893421047_7c2c60506876716ccf0e706db13d4511@0e_200w_200h_0c_1i_1o_90q_1x"
                                 width="60" height="60">
                        </a>
                    </div>
                    <h3 class="side-profile-name">
                        <a href="https://www.nowcoder.com/profile/328031526" class="level-color-7"
                           data-card-uid="328031526" data-card-index="22">
                            疯自
                        </a>
                    </h3>
                </div>
                <!-- 切换相应class出现3种不同效果count-rank-up、count-rank、count-rank-down -->
                <div class="profile-count-box">
                    <span class="pc-item">&nbsp;&nbsp;&nbsp;成就值&nbsp;<a href="javascript:void(0);">693</a></span>
                    <span class="pc-pipe">|</span>
                    <span class="pc-item">&nbsp;本周新增&nbsp;<a href="javascript:void(0);">44</a></span>
                    <span class="pc-pipe">|</span>
                    <span class="pc-item">&nbsp;排名&nbsp;</span><a href="javascript:void(0);">
                    21159
                </a>
                </div>
                <ul class="web-statistics">
                    <li>
                        <p>被采纳</p>
                        <p class="ws-num">0</p>
                    </li>
                    <li>
                        <p>获赞</p>
                        <p class="ws-num">0</p>
                    </li>
                    <li>
                        <p>答对题</p>
                        <p class="ws-num">693</p>
                    </li>
                    <li>
                        <p>编程通过</p>
                        <p class="ws-num">0</p>
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
    seajs.use('../../static/index/js/loginedV2.js');
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
