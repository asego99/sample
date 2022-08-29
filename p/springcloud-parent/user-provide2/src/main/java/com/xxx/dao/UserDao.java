package com.xxx.dao;

import com.xxx.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserDao
 * @Description
 * @Date 2022-08-27 10:20
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
