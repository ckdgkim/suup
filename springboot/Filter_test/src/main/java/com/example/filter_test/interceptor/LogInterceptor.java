//package com.example.filter_test.interceptor;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.lang.reflect.Method;
//
//@Slf4j
//public class LogInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//
//            log.info("Inter , preHandle : request ==> {}", request.getRequestURI());
//            log.info("Inter , preHandle : handler ==> {}", handler.getClass().getMethods()[0].getName());
//            return true;
//        }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("Inter , postHandle : request ==> {}", request.getRequestURI());
//        log.info("Inter , postHandle : handler ==> {}", handler.getClass().getMethods()[0].getName());
//        log.info("Inter , postHandle : handler method ==> {}", ((HandlerMethod) handler).getMethod().getName());
////        log.info("Inter , postHandle : modelAndView ==> {}", modelAndView.getViewName());
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
