package com.xxx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName HelloController
 * @Description
 * @Date 2022-08-25 10:04
 */
@RestController
public class HelloController {

    @RequestMapping("/hello2")
    public String hello2() {
        System.out.println("hello2");
        return "hello2";
    }
}
