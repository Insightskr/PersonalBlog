<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="/WEB-INF/pages/common/tag.jsp" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <%@include file="common/head.jsp" %>
    <%@include file="common/editor-edit.jsp" %>
</head>

<body>
<%--插入模态框--%>
<%@include file="/WEB-INF/pages/common/modal.jsp" %>
<%--插入导航栏--%>
<%@include file="/WEB-INF/pages/common/naviagtion.jsp" %>
<%--自定义的 JS 文件--%>


<!-- 日志栏 -->
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="blog-post">
                <form role="form" method="post">
                    <%--<input type="hidden" name="_method" value="PUT">--%>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <input type="text" class="form-control" name="name" placeholder="文章标题">
                                <input type="hidden" name="authorId" value="${sessionScope.victorId}">
                                <input type="hidden" name="context" id="article_context">
                                <%--如果是修改页面,则增加一个隐藏域，用来提交put请求--%>
                                <c:if test="${!empty requestScope.articleId}">
                                    <input type="hidden" name="_method" value="PUT">
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="editormd" id="article-editormd">
                                    <textarea class="editormd-markdown-textarea"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-3 col-md-offset-9 text-right">
                                <a href="${APP_PATH}/index.jsp" class="btn btn-default btn-lg ">返回主页</a>

                                <c:if test="${empty requestScope.articleId}">
                                    <input type="submit" class="btn btn-default btn-lg " id="sumbit_article" value="提交">
                                </c:if>

                                <c:if test="${!empty requestScope.articleId}">
                                    <input type="submit" class="btn btn-default btn-lg " id="update_article" value="修改">
                                </c:if>
                            </div>
                        </div>
                    </div>
            </div>

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

<!-- JAVASCRIPT 文件 -->
<script type="text/javascript" src="${APP_PATH}/static/js/title.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/navigation.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/js/edit.js"></script>
<script>
    var testEditor;

    $(function () {
        <%--如果不为空，则说明是修改页面--%>
        <c:if test="${!empty requestScope.articleId}">
        var article_id = ${requestScope.articleId};
        edit.updateInit(article_id);
        </c:if>


        <%--如果为空，则说明是新建文章页面--%>
        <c:if test="${empty requestScope.articleId}">
        testEditor = editormd("article-editormd", {
            width: "100%",
            height: 540,
            syncScrolling: "single",
            path: "${APP_PATH}/editormd/lib/",
        });
        edit.newInit();
        </c:if>
    });


</script>
</body>
</html>
