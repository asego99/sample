package com.xxx.service;

import com.xxx.bean.Account;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountService
 * @Description
 * @Date 2022-08-02 10:03
 */
public interface AccountService {
    List<Account> findAll();
}
