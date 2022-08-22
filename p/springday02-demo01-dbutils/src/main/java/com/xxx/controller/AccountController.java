package com.xxx.controller;

import com.xxx.config.BeanXml;
import com.xxx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountController
 * @Description
 * @Date 2022-08-02 10:05
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BeanXml.class)
public class AccountController {
    public static void main(String[] args) {
//        ApplicationContext act = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext act = new AnnotationConfigApplicationContext(BeanXml.class);
//        AccountService accountService = (AccountService) act.getBean("accountService");
//        accountService.findAll().forEach(System.out::println);
    }

    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        accountService.findAll().forEach(System.out::println);
    }

}
