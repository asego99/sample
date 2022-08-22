package com.xxx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName MyLoginHandlerInterceptor
 * @Description
 * @Date 2022-08-13 11:43
 */
public class MyLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object login = request.getSession().getAttribute("login");
        if (login != null) {
            return true;
        }
        response.sendRedirect("/login.html");
        return false;
    }
}
