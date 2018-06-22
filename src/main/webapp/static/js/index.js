var articles = {
    URL:{
        articles: '/articles',
        detail:function (article_id) {
            return "/article/detail/"+article_id;
        }
    },
    //发送分页请求
    to_page:function(pn) {
        $.ajax({
            url: articles.URL.articles,
            data: "pageNum=" + pn,
            type: "GET",
            success: function (result) {
                articles.build_article_info(result);
                articles.build_nav_info(result);
            }
        })
    },
    //显示文章内容
    build_article_info: function (result) {
        //清空原先数据
        $("#blog-article").empty();
        var articleContext = result.extend.articles.list;
        $.each(articleContext, function (index, item) {
            $("<div class=\"blog-post\"></div>").append("<h2>" + item.name + "</h2>")
                .append("<h4>作者：" + item.author.victorName + "&nbsp;&nbsp;&nbsp;编辑于：" + new Date(item.updateDate).toLocaleString() + "</h4>")
                .append("<p>" + item.context + "</p>").append('<a href="' + articles.URL.detail(item.id) + '"class="btn btn-default btn-lg ">阅读更多 <i class="fa fa-angle-right"></i></a>')
                .appendTo("#blog-article");
        });
    },
    // 显示分页信息
    build_nav_info:function(result) {
        $("#navigation-bar").empty();

        //获取页码数据
        var pageInfo = result.extend.articles;
        var ul = $("<ul></ul>").addClass("pagination");
        var fristPageLi = $("<li></li>").append($("<a></a>").append("首页"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        //给各个分页标签绑定点击事件
        prePageLi.click(function () {
            articles.to_page(pageInfo.prePage);
        });
        nextPageLi.click(function () {
            articles.to_page(pageInfo.nextPage);
        });
        //判断是否有上一页,据此决定是否要隐藏标签和绑定首页点击事件
        if (!pageInfo.hasPreviousPage) {
            prePageLi.addClass("hidden");
            fristPageLi.addClass("disabled");
        }
        if (!pageInfo.isFirstPage) {
            fristPageLi.click(function () {
                articles.to_page(1);
            });
        }
        //添加首页和上一页
        ul.append(fristPageLi).append(prePageLi);
        $.each(pageInfo.navigatepageNums, function (index, item) {
            var page = $("<li></li>").append($("<a></a>").append(item));
            //使用<a> 的 href 属性转为监听点击事件
            page.click(function () {
                articles.to_page(item);
            });
            //判断是否是当前页面,如果是，给其加上高亮属性
            if (item === pageInfo.pageNum) {
                page.addClass("active");
            }
            //添加页码
            ul.append(page);
        });
        if (!pageInfo.hasNextPage) {
            nextPageLi.addClass("hidden");
            lastPageLi.addClass("disabled");
        }
        if (!pageInfo.isLastPage) {
            lastPageLi.click(function () {
                articles.to_page(pageInfo.pages);
            });
        }
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        //将所有标签加入导航栏
        $("<nav></nav>").append(ul).appendTo($("#navigation-bar"));
    },
    // 初始化
    init: function () {
        $.ajax({
            url:articles.URL.articles,
            type: 'get',
            success: function (result) {
                articles.build_article_info(result);
                articles.build_nav_info(result);
            }
        })
    }
};

//显示文章内容
// function build_article_info(result) {
//     //清空原先数据
//     $("#blog-article").empty();
//     var articles = result.extend.articles.list;
//     $.each(articles, function (index, item) {
//         $("<div class=\"blog-post\"></div>").append("<h2>" + item.name + "</h2>")
//             .append("<h4>作者：" + item.author.victorName + "&nbsp;&nbsp;&nbsp;编辑于：" + new Date(item.updateDate).toLocaleString() + "</h4>")
//             .append("<p>" + item.context + "</p>").append('<a href="' + '/article/detail/' + item.id + '"class="btn btn-default btn-lg ">阅读更多 <i class="fa fa-angle-right"></i></a>')
//             .appendTo("#blog-article");
//     })
// }
//
// 显示分页信息
// function build_nav_info(result) {
//     $("#navigation-bar").empty();
//
//     //获取页码数据
//     var pageInfo = result.extend.articles;
//     var ul = $("<ul></ul>").addClass("pagination");
//     var fristPageLi = $("<li></li>").append($("<a></a>").append("首页"));
//     var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
//     var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
//     var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
//     //给各个分页标签绑定点击事件
//     prePageLi.click(function () {
//         to_page(pageInfo.prePage);
//     });
//     nextPageLi.click(function () {
//         to_page(pageInfo.nextPage);
//     });
//     //判断是否有上一页,据此决定是否要隐藏标签和绑定首页点击事件
//     if (!pageInfo.hasPreviousPage) {
//         prePageLi.addClass("hidden");
//         fristPageLi.addClass("disabled");
//     }
//     if (!pageInfo.isFirstPage) {
//         fristPageLi.click(function () {
//             to_page(1);
//         });
//     }
//     //添加首页和上一页
//     ul.append(fristPageLi).append(prePageLi);
//     $.each(pageInfo.navigatepageNums, function (index, item) {
//         var page = $("<li></li>").append($("<a></a>").append(item));
//         //使用<a> 的 href 属性转为监听点击事件
//         page.click(function () {
//             to_page(item);
//         });
//         //判断是否是当前页面,如果是，给其加上高亮属性
//         if (item === pageInfo.pageNum) {
//             page.addClass("active");
//         }
//         //添加页码
//         ul.append(page);
//     })
//     if (!pageInfo.hasNextPage) {
//         nextPageLi.addClass("hidden");
//         lastPageLi.addClass("disabled");
//     }
//     if (!pageInfo.isLastPage) {
//         lastPageLi.click(function () {
//             to_page(pageInfo.pages);
//         });
//     }
//     //添加下一页和末页
//     ul.append(nextPageLi).append(lastPageLi);
//     //将所有标签加入导航栏
//     $("<nav></nav>").append(ul).appendTo($("#navigation-bar"));
// }

//发送分页请求
// function to_page(pn) {
//     $.ajax({
//         url: articles.URL.articles,
//         data: "pageNum=" + pn,
//         type: "GET",
//         success: function (result) {
//             build_article_info(result);
//             build_nav_info(result);
//         }
//     })
// }