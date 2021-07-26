package com.cya.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //用户处于登录状态
        if (session.getAttribute("user") != null)
            return true;

        if (request.getRequestURI().contains("login"))
            return true;

        if (request.getRequestURI().contains("register"))
            return true;

        request.getRequestDispatcher("/WEB-INF/JSP/Error.jsp").forward(request,response);
        return false;
    }
}
