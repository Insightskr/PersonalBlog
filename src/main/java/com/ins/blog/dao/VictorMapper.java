package com.ins.blog.dao;

import com.ins.blog.entity.Victor;
import com.ins.blog.entity.VictorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Victor mapper.
 */
public interface VictorMapper {
    /**
     * Count by example long.
     *
     * @param example the example
     * @return the long
     */
    long countByExample(VictorExample example);

    /**
     * 检查用户名和密码
     *
     * @param name     the name
     * @param password the password
     * @return the long 如果记录存在，则返回用户 id，如果不存在，则返回 0
     */
    Integer loginCheck(@Param("name") String name, @Param("password") String password);

    /**
     * Delete by example int.
     *
     * @param example the example
     * @return the int
     */
    int deleteByExample(VictorExample example);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(Victor record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(Victor record);

    /**
     * Select by example list.
     *
     * @param example the example
     * @return the list
     */
    List<Victor> selectByExample(VictorExample example);

    /**
     * Update by example selective int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExampleSelective(@Param("record") Victor record, @Param("example") VictorExample example);

    /**
     * Update by example int.
     *
     * @param record  the record
     * @param example the example
     * @return the int
     */
    int updateByExample(@Param("record") Victor record, @Param("example") VictorExample example);

    Victor selectById(@Param("id")int id);
}