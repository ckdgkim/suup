package com.example.spring_swagger.config;

import com.example.spring_swagger.interceptor.LogInterceptor;
import com.example.spring_swagger.interceptor.LoginInterceptor;
import lombok.extern.java.Log;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SpringConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**");

        registry.addInterceptor(new LoginInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/users/register", "/login", "/posts");
    }
}
