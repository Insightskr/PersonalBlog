package com.ins.blog.dao;

import com.ins.blog.entity.Article;
import com.ins.blog.entity.ArticleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Article mapper.
 */
public interface ArticleMapper {
    /**
     * Count by example long.
     *
     * @param example the example
     * @return the long
     */
    long countByExample(ArticleExample example);

    /**
     * Delete by example int.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(ArticleExample example);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(Article record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(Article record);

    /**
     * Select by example with blo bs list.
     *
     * @param example the example
     * @return the list
     */
    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * Select by example with blo bs and author list.
     *
     * @param example the example
     * @return the list
     */
    List<Article> selectByExampleWithBLOBsAndAuthor(ArticleExample example);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * Update by example with blo bs int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);
}