package com.xxx.controller;

import com.xxx.config.BeanXml;
import com.xxx.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountController
 * @Description
 * @Date 2022-08-03 13:46
 */
public class AccountController {
    public static void main(String[] args) {
//        ApplicationContext act = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext act = new AnnotationConfigApplicationContext(BeanXml.class);
        AccountService accountService = (AccountService) act.getBean("accountService");
        System.out.println(accountService.add("fbb"));
        accountService.delete();
    }
}
