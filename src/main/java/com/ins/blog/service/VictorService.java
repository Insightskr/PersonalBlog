package com.ins.blog.service;

import com.ins.blog.dao.VictorMapper;
import com.ins.blog.entity.Victor;
import com.ins.blog.entity.VictorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author blue
 */
@Service
public class VictorService {
    @Autowired
    VictorMapper mapper;


    /**
     * Login check integer.
     *
     * @param name     the name
     * @param password the password
     * @return the integer 返回id值
     */
    public Integer loginCheck(String name,String password){
        //返回id
        return mapper.loginCheck(name,password);
    }

    /**
     * Username is exist boolean.
     *
     * @param name the name
     * @return the boolean true代表用户名不存在
     */
    public boolean usernameIsExist(String name){
        VictorExample example = new VictorExample();
        VictorExample.Criteria criteria = example.createCriteria();
        criteria.andVictorNameEqualTo(name);
        long number = mapper.countByExample(example);
        return number <=0;
    }

    /**
     * Email is exist boolean.
     *
     * @param email the email
     * @return the boolean true代表邮箱不存在
     */
    public boolean emailIsExist(String email){
        VictorExample example = new VictorExample();
        VictorExample.Criteria criteria = example.createCriteria();
        criteria.andVictorEmailEqualTo(email);
        long number = mapper.countByExample(example);
        return number <=0;
    }

    /**
     * Insert victor.
     *
     * @param victor the victor
     */
    public int insertVictor(Victor victor){
        return mapper.insertSelective(victor);
    }
}
