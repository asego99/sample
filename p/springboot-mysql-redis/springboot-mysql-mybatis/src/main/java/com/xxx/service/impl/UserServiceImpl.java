package com.xxx.service.impl;

import com.xxx.bean.User;
import com.xxx.mapper.UserMapper;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Description
 * @Date 2022-08-25 15:09
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAll() {

        List<User> users = (List<User>) redisTemplate.boundValueOps("users").get();
        if (users != null) {
            System.out.println("数据来自redis");
            return users;
        }

        users = userMapper.findAll();
        redisTemplate.boundValueOps("users").set(users);
        System.out.println("数据来自mysql");
        return userMapper.findAll();
    }
}
