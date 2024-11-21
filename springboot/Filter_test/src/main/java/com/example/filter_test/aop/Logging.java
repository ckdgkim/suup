//package com.example.filter_test.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class Logging {
//
//    @Before("execution(* com.example.filter_test.controller.*.*(..))")
////    @Before("execution(* * (..))")
//    public void leavinglog(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//        String className = jp.getTarget().getClass().getSimpleName();
//        log.info("{} : {} 가 실행되기 전", className, methodName);
//    }
//}
