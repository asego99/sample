package com.xxx.service;

import com.github.pagehelper.PageInfo;
import com.xxx.bean.Account;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountService
 * @Description
 * @Date 2022-08-12 9:37
 */
public interface AccountService {

    List<Account> findAll();

    Integer add(Account account);

    Integer delete(Integer id);

    Integer update(Account account);

    PageInfo<Account> findPage(Integer page, Integer limit, Account account);
}
