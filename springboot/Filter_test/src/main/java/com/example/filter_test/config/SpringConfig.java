//package com.example.filter_test.config;
//
//import com.example.filter_test.filter.LogFilter;
//import com.example.filter_test.filter.LoginFilter;
//import com.example.filter_test.interceptor.LogInterceptor;
//import com.example.filter_test.interceptor.LoginInterceptor;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class SpringConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").order(1);
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").order(2).excludePathPatterns("/members/registrer", "/members/login", "/posts");
//    }

    //    @Bean
//    public FilterRegistrationBean logfilterRB() {
//        FilterRegistrationBean frb = new FilterRegistrationBean(new LogFilter());
//        frb.addUrlPatterns("/*");
//        frb.setOrder(1);
//        return frb;
//    }
//
//    @Bean
//    public FilterRegistrationBean loginfilterRB() {
//        FilterRegistrationBean frb = new FilterRegistrationBean(new LoginFilter());
//        frb.addUrlPatterns("/members/register", "/members/login", "/members/logout");
//        frb.setOrder(2);
//        return frb;
//    }
//}
