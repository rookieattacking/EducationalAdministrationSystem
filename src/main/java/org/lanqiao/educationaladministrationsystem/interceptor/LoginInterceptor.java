package org.lanqiao.educationaladministrationsystem.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("requestURI:{}", requestURI);
        if(requestURI.equals("/login.html")) {
            return true;
        }
        /* 判断当前的用户是否已登录 */
        Object id = request.getSession().getAttribute("id");
        if(id == null){
            // response.sendRedirect("/login.html");
            /* 解决重定向在当前index.html中显示使用的javascript的方法强制跳转 */
            response.getWriter().write("<script type='text/javascript'>window.top.location.href = '/login.html';</script>");
            return false;
        }
        /* 判断用户在使用的时候如何还在页面中就添加存活时间 30m */
        if(id == null){
            request.getSession().setMaxInactiveInterval(30 * 60);
        }
        return true;
    }
}
