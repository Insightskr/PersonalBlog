<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%@include file="/WEB-INF/pages/common/tag.jsp" %>
<head>
    <%@include file="/WEB-INF/pages/common/head.jsp" %>
</head>
<body>
<%--插入模态框--%>
<%@include file="/WEB-INF/pages/common/modal.jsp" %>
<%--插入导航栏--%>
<%@include file="/WEB-INF/pages/common/naviagtion.jsp" %>



<!-- 日志栏 -->
<div class="container">

    <div class="row">
        <!-- 文章 -->
        <div class="col-md-8 " id="blog-article">

        </div>

        <div class="col-md-1"></div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item"><strong>文章类别</strong></li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Morbi leo risus</li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                    <li class="list-group-item">Dapibus ac facilisis in</li>
                    <li class="list-group-item">Morbi leo risus</li>
                    <li class="list-group-item">Porta ac consectetur ac</li>
                    <li class="list-group-item">Vestibulum at eros</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8" id="navigation-bar">
        </div>
    </div>
</div>

<!-- 主页底部信息 -->
<div class="footer-sec" style="margin-top: 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-12 foo-inner">
                &copy; 2015 Yourdomain.com
            </div>
        </div>
    </div>
</div>
<!-- END FOOTER SECTION -->
<%--自定义的 JS 文件--%>
<script type="text/javascript" src="${APP_PATH}/static/js/title.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/navigation.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/index.js"></script>
<script type="text/javascript">
    $(function () {
        articles.init();
    });
</script>
</body>
</html>
