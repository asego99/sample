package com.xxx.service.impl;

import com.xxx.bean.User;
import com.xxx.dao.UserDao;
import com.xxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Description
 * @Date 2022-08-27 10:25
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {

        return userDao.findById(id).get();
    }
}
