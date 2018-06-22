var detail = {
    URL:{
        articleId:function (article_id) {
            return '/article/' + article_id;
        }
    },
    // 显示文章内容
    showDetails:function (EditormdView,article_id) {
        $.ajax({
            url: detail.URL.articleId(article_id),
            type: "get",
            success: function (result) {
                var article = result.extend.article;
                //添加标题
                $("#title").append(article.name);
                //添加作者和时间
                //todo:优化时间显示的问题。
                $('#author').append("作者：" + article.author.victorName + "&nbsp;&nbsp;&nbsp;&nbsp; 发表日期：" + new Date(article.updateDate).toLocaleString());
                EditormdView = editormd.markdownToHTML("article-editormd-view", {
                    markdown: article.context,  //这个位置设置文本内容
                    htmlDecode: "style,script,iframe",  // you can filter tags decode
                    width: "100%"
                });
            }
        });
    },
    // 绑定删除文章按钮监听
    bindDeleteButton:function (article_id) {
        $("#delete_article").click(function () {
            if (confirm("确认删除该文章吗？")) {
                $.ajax({
                    url: detail.URL.articleId(article_id),
                    type: "post",
                    data: "_method=DELETE",
                    success: function () {
                        alert("删除成功");
                        $(location).attr("href", "/index.jsp");
                    }
                })
            }
        });
    },
    // 初始化
    init:function (EditormdView,article_id) {
        detail.showDetails(EditormdView,article_id);
        detail.bindDeleteButton(article_id);
    }
};