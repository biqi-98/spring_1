package com.lagou.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
    通知类
 */
@Component
@Aspect  //升级为切面类：配置切入点和通知的关系
public class MyAdvice {

    @Pointcut("execution(* com.lagou.servlet.impl.ArticleServiceImpl.*(..))")
    public void myPoint(){}

    @Before("MyAdvice.myPoint()")
    public void before(){
        System.out.println("前置增强..");
    }

}
