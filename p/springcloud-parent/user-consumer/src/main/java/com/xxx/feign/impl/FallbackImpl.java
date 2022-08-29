package com.xxx.feign.impl;

import com.xxx.bean.User;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName FallbackImpl
 * @Description
 * @Date 2022-08-29 10:26
 */
@Component
public class FallbackImpl{

    public User findById(Integer id) {
        User user = new User();
        user.setUsername("1111111111111111");
        return user;
    }
}
