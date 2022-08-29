package com.xxx.service;

import com.xxx.bean.User;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserService
 * @Description
 * @Date 2022-08-27 10:25
 */
public interface UserService {
    User findById(Integer id);
}
