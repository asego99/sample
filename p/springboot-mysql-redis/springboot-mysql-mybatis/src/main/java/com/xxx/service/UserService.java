package com.xxx.service;

import com.xxx.bean.User;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserService
 * @Description
 * @Date 2022-08-25 15:09
 */
public interface UserService {

    List<User> findAll();
}
