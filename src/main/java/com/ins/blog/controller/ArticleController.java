package com.ins.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ins.blog.entity.Article;
import com.ins.blog.entity.Msg;
import com.ins.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The type Article controller.
 */
@Controller
public class ArticleController {

    /**
     * The Article service.
     */
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    @ResponseBody
    public Msg getAll(@RequestParam(value = "pageNum",defaultValue = "1")Integer pn){
        //todo:查询之前先做分页
        PageHelper.startPage(pn,3);
        List<Article> articles = articleService.selectAll();
        //todo:将里面的 > 、-号等过滤掉。
        String regax = "(#*)|(>)";
        for (Article article : articles) {
            if (article.getContext().length()>100){
                article.setContext(article.getContext().substring(0,100)+"...");
            }
           article.setContext( article.getContext().replaceAll(regax,""));
        }
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);
        return Msg.success().add("articles",articlePageInfo);
    }

    /**
     * 插入一篇文章
     *
     * @param article the article
     * @return the msg
     */
    @RequestMapping(value = "/article",method = RequestMethod.POST)
    @ResponseBody
    public Msg insertArticle(Article article){
        Date date = new Date();
        //设置创建日期的更新日期
        article.setCommitDate(date);
        article.setUpdateDate(date);
        int articleId = articleService.insertArticle(article);
        return Msg.success().add("articleId",articleId);
    }

    /**
     * 进入新建页面 .
     *
     * @return the string
     */
    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public String newArticle(){
        return "edit";
    }

    /**
     * 跳转文章详情页
     *
     * @param id  the id
     * @param map the map
     * @return the string
     */
    @RequestMapping(value = "/article/detail/{id}")
    public String showDetail(@PathVariable("id")Integer id,Map<String,Object> map){
        map.put("articleId",id);
        return "detail";
    }

    /**
     * 获取文章内容
     *
     * @param id the id
     * @return the article
     */
    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getArticle(@PathVariable("id") int id){
        Article article = articleService.selectArticleById(id);
        return Msg.success().add("article",article);
    }

    /**
     * 删除一篇文章
     *
     * @param id the id
     * @return the msg
     */
    @RequestMapping(value = "/article/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteArticle(@PathVariable("id")int id){
        articleService.deleteArticle(id);
        return Msg.success();
    }

    /**
     * 跳转到修改页面
     *
     * @param id  the id
     * @param map the map
     * @return the string
     */
    @RequestMapping(value = "/article/edit/{id}",method = RequestMethod.GET)
    public String showEdit(@PathVariable("id")int id,Map<String,Object>map){
        map.put("articleId",id);
        return "edit";
    }

    @RequestMapping(value = "/article/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateArticle(@PathVariable("id")int id, Article article){
        Date date = new Date();
        //设置创建日期的更新日期
        article.setUpdateDate(date);
        articleService.updateArticle(id,article);
        return Msg.success().add("articleId",id);
    }
}
