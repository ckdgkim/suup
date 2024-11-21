package com.example.spring_swagger.interceptor;

import com.example.spring_swagger.userdomain.session.SessionConst;
import com.example.spring_swagger.userdomain.session.UserSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String redirectURI = request.getRequestURI(); // 로그인 후에 돌아갈 URI
        //로그인 여부 확인 (세션, 로그인?)
        HttpSession session = request.getSession(false);//로그인 되어 있으면 세션get, 로그인 안되어 있으면 null
        if (session != null) {
            Object attribute = session.getAttribute(SessionConst.SESSION_NAME);
            response.sendRedirect(request.getContextPath() + "/login?redirectURI=" + redirectURI);
            return false;
        } else {
            Object objSession = session.getAttribute(SessionConst.SESSION_NAME);
            if (objSession instanceof UserSession) {
                UserSession userSession = (UserSession) objSession;
                log.info("user session: {} ", userSession);
            }else {
                Object objSession = session.getAttribute(SessionConst.SESSION_NAME);
                if(objSession == null) {
                    response.sendRedirect(request.getContextPath() + "/login?redirectURI=" + redirectURI);
                    return false;
                }
            }
        }
    }
}


