package com.xxx.Controller;

import com.xxx.bean.User;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserController
 * @Description
 * @Date 2022-08-25 15:11
 */
@RestController
@RequestMapping("/user")
//@MapperScan("com.xxx.mapper")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return service.findAll();
    }
}
