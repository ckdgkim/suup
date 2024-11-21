package com.example.spring_swagger.Logindomain.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter { // login 여부를 check하는 필터

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);// 기존 세션이 있으면 있는 세션을 반환. 없으면 null
        //true = 세션이 없으면 세션을 생성, 세션이 있으면 있는 세션을 반환해준다.
        if (session != null) {
            log.info("로그인 되었습니다.");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            log.info("로그인 되지 않았습니다.");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}