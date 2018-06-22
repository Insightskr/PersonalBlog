<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--顶部导航栏加标题栏-->
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











