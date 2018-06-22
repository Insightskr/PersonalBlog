var edit = {
    URL: {
        articleId:function (article_id) {
            return '/article/' + article_id;
        },
        detailArticleId:function(article_id){
            return "/article/detail/"+article_id;
        },
        article:"/article"
    },
    // 更新页面初始化
    updateInit: function (article_id) {
        edit.getUpdateArticle(article_id);
        edit.bindUpdateButton(article_id);
    },
    // 新建页面初始化
    newInit:function(){
        edit.bindSubmitButton();
    },
    //获取被修改文章
    getUpdateArticle: function (article_id) {
        $.ajax({
            url: edit.URL.articleId(article_id),
            type: 'get',
            success: function (result) {
                var article = result.extend.article;
                $("[name='name']").attr('value', article.name);
                testEditor = editormd("article-editormd", {
                    markdown: article.context,
                    width: "100%",
                    height: 540,
                    syncScrolling: "single",
                    path: "/editormd/lib/",
                });
            }
        });
    },
    // 绑定更新按钮
    bindUpdateButton:function (article_id) {
        $("#update_article").click(function () {
            $("#article_context").attr("value", testEditor.getMarkdown());
            $.ajax({
                url: edit.URL.articleId(article_id),
                type: "post",
                data: $("form").serialize(),
                success: function (result) {
                    if (200 === result.code) {
                        $(location).attr("href", edit.URL.detailArticleId(result.extend.articleId));
                    }
                }
            });
            return false;
        });
    },
    // 绑定提交按钮
    bindSubmitButton:function () {
        //将 md 内容放入,然后提交文章
        $("#sumbit_article").click(function () {
            $("#article_context").attr("value", testEditor.getMarkdown());
            $.ajax({
                url:edit.URL.article,
                type: "post",
                data: $("form").serialize(),
                success: function (result) {
                    if (200 === result.code) {
                        $(location).attr("href", edit.URL.detailArticleId(result.extend.articleId));
                    }
                }
            });
            return false;
        });
    }
};