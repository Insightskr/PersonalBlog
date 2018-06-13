
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Insight's Blog</title>
    <!-- CORE JQUERY -->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.2.4.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- BOOTSTRAP SCRIPTS -->
    <script type="text/javascript" src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 重定义标题栏格式，使之可以渐变显示 -->
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
        }

        /*非常重要的样式让背景图片100%适应整个屏幕*/
        .bg {
            display: table;
            width: 100%;
            height: 100%;
            padding: 100px 0;
            text-align: center;
            color: #fff;
            background-color: #000;
            background-size: cover;
        }

        .my-navbar {
            padding: 10px 10px 10px 100px;
            transition: background 0.5s ease-in-out, padding 0.5s ease-in-out;
        }

        .my-navbar a {
            background: transparent !important;
            color: #fff !important
        }

        .my-navbar a:hover {
            color: #45bcf9 !important;
            background: transparent;
            outline: 0
        }

        .my-navbar a {
            transition: color 0.5s ease-in-out;
        }

        /*-webkit-transition ;-moz-transition*/
        .top-nav {
            padding: 0;
            background: #000;
        }

        button.navbar-toggle {
            background-color: #fbfbfb;
        }

        /*整个背景都是transparent透明的，会看不到，所以再次覆盖一下*/
        button.navbar-toggle > span.icon-bar {
            background-color: #dedede
        }
    </style>

    <!-- FONT AWESOME ICON STYLE -->
    <link href="${APP_PATH}/static/css/font-awesome.css" rel="stylesheet"/>
    <!-- CUSTOM STYLE CSS -->
    <link href="${APP_PATH}/static/css/style.css" rel="stylesheet"/>
</head>
<body>
<!--登录模态框-->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">登录</h4>
            </div>
            <div class="modal-body">
                <form id="login_form">
                    <div class="form-group">
                        <label for="login_name_input">用户名</label>
                        <input type="text" class="form-control" id="login_name_input" name="victorName"
                               placeholder="请输入用户名">
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="login_password_input">密码</label>
                        <input type="password" class="form-control" id="login_password_input" name="victorPassword"
                               placeholder="请输入密码">
                        <span class="help-block"></span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="login_btn" login-able="false">登录</button>
            </div>
        </div>
    </div>
</div>

<!--注册模态框-->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">注册</h4>
            </div>
            <div class="modal-body">
                <form id="register_form" class="form-horizontal">
                    <div class="form-group">
                        <label for="register_name_input" class="col-sm-2 col-sm-offset-1 control-label">用户名</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="register_name_input" name="victorName"
                                   placeholder="请输入用户名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="register_email_input" class="col-sm-2 col-sm-offset-1 control-label">邮箱</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="register_email_input" name="victorEmail"
                                   placeholder="请输入邮箱">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="register_password_input" class="col-sm-2 col-sm-offset-1 control-label">密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="register_password_input"
                                   name="victorPassword"
                                   placeholder="请输入密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm_password_input" class="col-sm-2 col-sm-offset-1 control-label">确认密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="confirm_password_input"
                                   placeholder="请再次输入密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="register_btn" register-able="false">注册</button>
            </div>
        </div>
    </div>
</div>
<!--标题栏-->
<div id="header">
    <div class="overlay">
        <nav class="navbar navbar-fixed-top my-navbar" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#my-nav"
                            aria-expanded="false">
                        <span class="sr-only">切换导航条</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">Insight</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="my-nav">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${APP_PATH}/index.jsp">主页</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${empty sessionScope.name}">
                            <li><a href="javascript:loginModel();">登录</a></li>
                            <li><a href="javascript:registerModel();">注册</a></li>
                        </c:if>
                        <c:if test="${!empty sessionScope.name}">
                            <li><a href="#">你好，${sessionScope.name}</a></li>
                            <li><a href="${APP_PATH}/article" >写博客</a></li>
                            <li><a href="javascript:logout()">退出登录</a></li>
                        </c:if>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-4 logo-div">
                    <div class="logo-inner text-center">
                        <div class="logo-name">
                            <a href="${APP_PATH}/index.jsp">
                                <img src="${APP_PATH}/static/img/me.jpg" class="img-circle"/>
                            </a>
                        </div>

                    </div>

                </div>
                <div class="col-md-8 header-text-top " id="about">

                    <h1>宋科儒的个人博客</h1>
                    这个博客是基于 Bootstrap 和 SSM 制作的 <br/>
                    这里的文章记录了我的学习过程中的笔记<br/>

                </div>
            </div>
        </div>
    </div>
</div>
<!--标题底栏-->
<div class="info-sec">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                可以通过我的邮箱 <strong>729885929</strong>@qq.com 联系我
            </div>
        </div>
    </div>
</div>

<!--END INFO SECTION-->
<%--自定义的 JS 文件--%>
<script type="text/javascript" src="${APP_PATH}/static/js/title.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/navigation.js"></script>


