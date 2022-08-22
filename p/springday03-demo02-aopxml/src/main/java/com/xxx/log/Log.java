package com.xxx.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Log
 * @Description
 * @Date 2022-08-03 14:07
 */
@Component("log")
@EnableAspectJAutoProxy
@Aspect
public class Log {

    @Pointcut("execution(* com.xxx.service.impl.*ServiceImpl.*(..))")
    public void pc(){}

    @Before("pc()")
    public void before() {
        System.out.println("前置增强");
    }

    @AfterReturning("pc()")
    public void afterReturning() {
        System.out.println("后置增强");
    }

    @AfterThrowing("pc()")
    public void afterThrowing() {
        System.out.println("异常增强");
    }

    @After("pc()")
    public void after() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终增强");
    }

//    @Around("pc()")
    public String around(ProceedingJoinPoint pj) {//

        String result = null;
        try {
            System.out.println("前置增强1");
            result = (String) pj.proceed();//proceed() 类似于invoke() 方法
            System.out.println("后置增强1");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("异常增强1");
        } finally {
            System.out.println("最终增强1");
        }
        return result;
    }
}
