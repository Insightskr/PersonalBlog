package com.ins.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录验证拦截器
 * @author blue
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.preHandle(request, response, handler);
        HttpSession session = request.getSession();
        Object name = session.getAttribute("name");
        //如果用户名这个属性存在，则说明以及登录
        if (name != null){
            return true;
        }else {
            //如果没有登录则跳转回主页
            response.sendRedirect("/index.jsp");
            return false;
        }
    }
}
