package com.xxx.controller;

import com.xxx.factory.BeanFactory;
import com.xxx.service.AccountService;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountController
 * @Description
 * @Date 2022-08-01 10:25
 */
public class AccountController {
    private static AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
    private static AccountService accountService1 = (AccountService) BeanFactory.getBean("accountService");

    public static void main(String[] args) {
        accountService.save();
        System.out.println(accountService==accountService1);
    }
}
