<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    <title></title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300">
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="/static/index/css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="/static/index/fontawesome/css/fontawesome-all.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" type="text/css" href="/static/index/slick/slick.css"/>
    <!-- http://kenwheeler.github.io/slick/ -->
    <link rel="stylesheet" type="text/css" href="/static/index/slick/slick-theme.css"/>
    <link rel="stylesheet" href="/static/index/css/tooplate-style.css">
    <script>document.documentElement.className = "js";
    var supportsCssVars = function () {
        var e, t = document.createElement("style");
        return t.innerHTML = "root: { --tmp-var: bold; }", document.head.appendChild(t), e = !!(window.CSS && window.CSS.supports && window.CSS.supports("font-weight", "var(--tmp-var)")), t.parentNode.removeChild(t), e
    };
    supportsCssVars() || alert("Please view this in a modern browser such as latest version of Chrome or Microsoft Edge.");</script>

</head>
<body>
<div id="tm-bg"></div>
<div id="tm-wrap">
    <div class="tm-main-content">
        <div class="container tm-site-header-container">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-lg-6 col-md-col-xl-6 mb-md-0 mb-sm-4 mb-4 tm-site-header-col">
                    <div class="tm-site-header">
                        <p>
                            <c:choose>
                                <c:when test="${sessionScope.sessionAccount==null}">
                                    <a href="/User/login">登录</a>
                                </c:when>
                                <c:otherwise>
                                    ${sessionScope.username} <a href="/User/exit">注销</a>
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <h1 class="mb-4">POP design</h1>
                        <img src="/static/index/img/underline.png" class="img-fluid mb-4">
                        <p>New HTML Template with pop up pages and use this layout for your website</p>
                    </div>
                </div>

                <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                    <div class="content">
                        <div class="grid">
                            <div class="grid__item" id="home-link">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-home fa-3x tm-nav-icon"></i>
                                        <span class="tm-nav-text">创建投票</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">
                                        <div class="row mb-3">
                                            <div class="col-12">
                                                <h2 class="tm-page-title">Welcome to Pop Design</h2>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                                <p>
                                                    <%--<c:choose>--%>
                                                        <%--<c:when test="${sessionScope.sessionAccount==null}">--%>
                                                            <%--<a href="user/login">请登陆</a>--%>
                                                        <%--</c:when>--%>
                                                        <%--<c:otherwise>--%>
                                                            <iframe src="vote/createVote" scrolling="no" frameborder="0"
                                                                    height="75%" width="100%">
                                                            </iframe>
                                                        <%--</c:otherwise>--%>
                                                    <%--</c:choose>--%>
                                                </p>
                                            </div>
                                            <div class="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                                                <p>Donec eu lectus ligula. Aenean pulvinar dolor et massa lacinia
                                                    rhoncus sit amet sed mauris. Aliquam dictum nibh et consequat
                                                    finibus.</p>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In magna
                                                    mauris, malesuada ut diam eu, pellentesque fringilla orci.</p>
                                                <img src="/static/index/img/welcome-2.jpg" class="img-fluid">
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="grid__item" id="team-link">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-users fa-3x tm-nav-icon"></i>
                                        <span class="tm-nav-text">投票</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">
                                        <div class="p-sm-4 p-2">
                                            <div class="row mb-3">
                                                <div class="col-12">
                                                    <h2 class="tm-page-title">Background of Our Team</h2>
                                                </div>
                                            </div>
                                            <div class="row tm-reverse-sm">
                                                <div class="col-sm-12 col-md-8 col-lg-8 col-xl-8">
                                                    <p class="mb-4">
                                                        <iframe src="vote/findVote" scrolling="no"
                                                                frameborder="0" height="60%" width="100%">
                                                        </iframe>
                                                    </p>
                                                </div>
                                                <div class="col-sm-12 col-md-4 col-lg-4 col-xl-4 mb-lg-0 mb-sm-4 mb-4">
                                                    <img src="/static/index/img/team.jpg" class="img-fluid">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tlinks">Collect from <a href="http://www.cssmoban.com/">网页模板</a></div>

                            <div class="grid__item">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-handshake fa-3x t m-nav-icon"></i>
                                        <span class="tm-nav-text">我参与过的投票</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">
                                        <div class="p-sm-4 p-2">
                                            <div class="row mb-3">
                                                <div class="col-12">
                                                    <h2 class="tm-page-title">投票</h2>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-12">
                                                    <iframe src="vote/findUserVoted" scrolling="no" frameborder="0"
                                                            height="75%" width="100%">
                                                    </iframe>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="grid__item">
                                <div class="product">
                                    <div class="tm-nav-link">
                                        <i class="fas fa-comments fa-3x tm-nav-icon"></i>
                                        <span class="tm-nav-text">我的投票</span>
                                        <div class="product__bg"></div>
                                    </div>
                                    <div class="product__description">
                                        <div class="pt-sm-4 pb-sm-4 pl-sm-5 pr-sm-5 pt-2 pb-2 pl-3 pr-3">
                                            <div class="row mb-3">
                                                <div class="col-12">
                                                    <h2 class="tm-page-title">我的投票</h2>
                                                </div>
                                            </div>
                                            <div class="row mb-4">
                                                <div class="col-12">
                                                    <p class="mb-4">
                                                        <iframe src="" scrolling="no"
                                                                frameborder="0" height="60%" width="100%">
                                                        </iframe>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- .tm-main-content -->
</div>
<!-- load JS -->
<script src="/static/index/js/jquery-3.2.1.slim.min.js"></script>         <!-- https://jquery.com/ -->
<script src="/static/index/slick/slick.min.js"></script>                  <!-- http://kenwheeler.github.io/slick/ -->
<script src="/static/index/js/anime.min.js"></script>                     <!-- http://animejs.com/ -->
<script src="/static/index/js/main.js"></script>
<script>

    function setupFooter() {
        var pageHeight = $('.tm-site-header-container').height() + $('footer').height() + 100;

        var main = $('.tm-main-content');

        if ($(window).height() < pageHeight) {
            main.addClass('tm-footer-relative');
        }
        else {
            main.removeClass('tm-footer-relative');
        }
    }

    /* DOM is ready
    ------------------------------------------------*/
    $(function () {

        setupFooter();

        $(window).resize(function () {
            setupFooter();
        });

        $('.tm-current-year').text(new Date().getFullYear());  // Update year in copyright
    });

</script>

</body>
</html>