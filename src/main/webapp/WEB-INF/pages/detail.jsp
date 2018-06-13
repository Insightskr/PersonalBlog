<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
        <%
            pageContext.setAttribute("APP_PATH", request.getContextPath());
        %>
    <%--引入 editormd 的 CSS--%>
    <link rel="stylesheet" href="${APP_PATH}/editormd/css/editormd.preview.css"/>
    <%--引入 editormd 需要的 JS--%>
    <script src="${APP_PATH}/static/js/jquery-2.2.4.min.js"></script>
    <script src="${APP_PATH}/editormd/lib/marked.min.js"></script>
    <script src="${APP_PATH}/editormd/lib/prettify.min.js"></script>

    <script src="${APP_PATH}/editormd/lib/raphael.min.js"></script>
    <script src="${APP_PATH}/editormd/lib/underscore.min.js"></script>
    <script src="${APP_PATH}/editormd/lib/sequence-diagram.min.js"></script>
    <script src="${APP_PATH}/editormd/lib/flowchart.min.js"></script>
    <script src="${APP_PATH}/editormd/lib/jquery.flowchart.min.js"></script>

    <script src="${APP_PATH}/editormd/editormd.js"></script>
    <%@include file="head.jsp" %>
    <!-- 日志栏 -->
    <div class="container">
        <div class="row">
            <div class="col-md-8 ">
                <div class="blog-post">
                    <div class="">
                        <h1 id="title"></h1>
                        <h4 id="author"></h4>
                    </div>
                    <%--文本展现域--%>
                    <div id="article-editormd-view">
                    <textarea style="display:none;" name="test-editormd-markdown-doc">
                    </textarea>
                    </div>
                    <c:if test="${empty sessionScope.name}">
                        <a href="${APP_PATH}/index.jsp" class="btn btn-default btn-lg ">返回主页</a>
                    </c:if>
                    <c:if test="${!empty sessionScope.name}">
                        <a href="${APP_PATH}/index.jsp" class="btn btn-default btn-lg ">返回主页</a>
                        <a class="btn btn-default btn-lg" href="${APP_PATH}/article/edit/${articleId}" >修改文章</a>
                        <button class="btn btn-default btn-lg" id="delete_article">删除文章</button>
                    </c:if>
                </div>
                <br/>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-3" style="padding-top: 30px;">
                <div class="row">
                    <ul class="list-group">
                        <li class="list-group-item"><strong>类别</strong></li>
                        <li class="list-group-item">Django</li>
                        <li class="list-group-item">Bootstrap</li>
                        <li class="list-group-item">Python</li>
                        <li class="list-group-item">MySQL</li>
                    </ul>
                </div>
                <div class="row">
                </div>
            </div>
        </div>
    </div>

    <!-- 主页底部信息 -->
    <div class="footer-sec" style="margin-top: 0px;">
        <div class="container">
            <div class="row">
                <div class="col-md-12 foo-inner">
                    &copy; 2015 Yourdomain.com
                </div>
            </div>
        </div>
    </div>
    <!-- END FOOTER SECTION -->
    <%--网页渲染脚本--%>
    <script type="text/javascript">
        var EditormdView;
        $(function () {
            $.ajax({
                url: '/article/' +${articleId},
                type: "get",
                success: function (result) {
                    var article = result.extend.article;
                    //添加标题
                    $("#title").append(article.name);
                    //添加作者和时间
                    //todo:优化时间显示的问题。
                    $('#author').append("作者："+article.author.victorName+"&nbsp;&nbsp;&nbsp;&nbsp; 发表日期："+new Date(article.updateDate).toLocaleString());
                    EditormdView = editormd.markdownToHTML("article-editormd-view", {
                        markdown: article.context,  //这个位置设置文本内容
                        htmlDecode: "style,script,iframe",  // you can filter tags decode
                        width: "100%",
                    });
                }
            });
        });

        //删除文章按钮监听
        $("#delete_article").click(function () {
            if (confirm("确认删除该文章吗？")){
                $.ajax({
                    url: '/article/' +${articleId},
                    type: "post",
                    data:"_method=DELETE",
                    success:function (result) {
                        alert("删除成功");
                        $(location).attr("href", "/index.jsp");
                    }
                })
            }
        });


    </script>
    </body>
</html>
