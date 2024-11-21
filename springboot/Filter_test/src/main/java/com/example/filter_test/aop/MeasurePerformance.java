//package com.example.filter_test.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class MeasurePerformance {
//
//    @Around("execution(* com.example.filter_test.controller.*.*(..))")
//    public void measurePerformance(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        pjp.proceed();
//        long end = System.currentTimeMillis();
//        log.info("Aspect measurePerformance : {} ms", end - start);
//    }
//}
