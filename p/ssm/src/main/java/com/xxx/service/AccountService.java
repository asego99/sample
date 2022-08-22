package com.xxx.service;

import com.xxx.bean.Account;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountService
 * @Description
 * @Date 2022-08-10 9:29
 */
public interface AccountService {

    List<Account> findAll();

    Account findById(Integer id);

    Integer add(Account account);

    Integer update(Account account);

    Integer delete(Integer id);
}
