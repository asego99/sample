package com.xxx.controller;

import com.xxx.bean.User;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserController
 * @Description
 * @Date 2022-08-27 10:33
 */
@RestController
@RequestMapping("/provide")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public User findById(@PathVariable Integer id) {

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return userService.findById(id);
    }
}