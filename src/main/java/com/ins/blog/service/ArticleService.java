package com.ins.blog.service;

import com.ins.blog.dao.ArticleMapper;
import com.ins.blog.entity.Article;
import com.ins.blog.entity.ArticleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author blue
 */
@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;


    /**
     * Insert article int.
     *
     * @param article the article
     * @return the int
     */
    public int insertArticle(Article article){
        articleMapper.insert(article);
        return article.getId();
    }

    /**
     * Select article by id article.
     *
     * @param id the id
     * @return the article
     */
    public Article selectArticleById(int id){
        ArticleExample example=new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Article> articles = articleMapper.selectByExampleWithBLOBsAndAuthor(example);
        return articles.get(0);
    }

    /**
     * 删除一篇文章
     *
     * @param id the id
     */
    public void deleteArticle(int id) {
        ArticleExample example=new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        articleMapper.deleteByExample(example);
    }

    /**
     * 获得所有文章
     *
     * @return the list
     */
    public List<Article> selectAll() {
        return articleMapper.selectByExampleWithBLOBsAndAuthor(null);
    }

    /**
     * 根据主键更新文章
     *
     * @param id      the id
     * @param article the article
     */
    public void updateArticle(int id,Article article){
        ArticleExample example=new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        articleMapper.updateByExampleSelective(article,example);
    }
}
