package com.xxx.service.impl;

import com.xxx.bean.User;
import com.xxx.mapper.UserMapper;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
