package org.lanqiao.educationaladministrationsystem.config;

import org.lanqiao.educationaladministrationsystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        // 登录拦截器
        registry.addInterceptor(loginInterceptor)
                //放行
                .excludePathPatterns(
                        "/login.html",
                        "/register.html",
                        "/code",
                        "/code2",
                        "/register",
                        "/login",
                        "/css/*",
                        "/images/*",
                        "/js/*",
                        "/index.html",
                        "/studentIndex.html",
                        "files/*"
                ).order(1);
    }
}
