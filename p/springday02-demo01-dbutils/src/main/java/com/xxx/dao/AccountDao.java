package com.xxx.dao;

import com.xxx.bean.Account;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountDao
 * @Description
 * @Date 2022-08-02 10:02
 */
public interface AccountDao {

    List<Account> findAll();
}
