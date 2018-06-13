package com.ins.blog.controller;

import com.ins.blog.entity.Msg;
import com.ins.blog.entity.Victor;
import com.ins.blog.service.VictorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 登录用户控制器
 *
 * @author blue
 */
@Controller
public class VictorController {
    /**
     * The Victor service.
     */
    @Autowired
    VictorService victorService;

    /**
     * 用户登录验证
     *
     * @param victorName     the victor name
     * @param victorPassword the victor password
     * @param session        the session
     * @return the msg
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Msg victorLogin(@RequestParam("victorName") String victorName, @RequestParam("victorPassword") String victorPassword, HttpSession session) {
        Integer victorId = victorService.loginCheck(victorName,victorPassword);
        // 如果返回的 victorId 大于零，说明输入的用户名和密码正确
        if (victorId > 0) {
            session.setAttribute("victorId",victorId);
            session.setAttribute("name",victorName);
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    /**
     * 用户登出
     *
     * @param session the session
     * @return the msg
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Msg logout(HttpSession session){
        session.removeAttribute("name");
        //返回提示信息,通过 Ajax 来刷新页面
        return Msg.success();
    }

    /**
     * 检查用户名是否存在
     *
     * @param name the name
     * @return the msg
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Msg checkName(@RequestParam("val")String name){
        boolean flag = victorService.usernameIsExist(name);
        if (flag){
            return Msg.success("用户名可用");
        }else {
            return Msg.fail("用户名已存在");
        }
    }

    /**
     * 检查邮箱是否存在
     *
     * @param email the email
     * @return the msg
     */
    @RequestMapping("/checkEmail")
    @ResponseBody
    public Msg checkEmail(@RequestParam("val")String email){
        boolean flag = victorService.emailIsExist(email);
        if (flag){
            return Msg.success("该邮箱尚未注册");
        }else {
            return Msg.fail("该邮箱已被注册");
        }
    }

    /**
     * 注册用户
     *
     * @param victor  the victor
     * @param session the session
     * @return the msg
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Msg victorRegister(Victor victor,HttpSession session){
        //获得新注册用户的 id
        int victorId = victorService.insertVictor(victor);
        session.setAttribute("victorId",victorId);
        session.setAttribute("name",victor.getVictorName());
        return Msg.success();
    }
}
