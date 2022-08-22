package com.xxx.controller;

import com.xxx.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountController
 * @Description
 * @Date 2022-08-01 14:14
 */
public class AccountController {
    public static void main(String[] args) {
        ApplicationContext act = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) act.getBean("accountService");
        System.out.println(accountService.toString());
        accountService.save();
    }
}
