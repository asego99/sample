package com.xxx.service;

import com.github.pagehelper.PageInfo;
import com.xxx.bean.Account;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountSerivce
 * @Description
 * @Date 2022-08-13 9:29
 */
public interface AccountService {

    List<Account> findAll();

    PageInfo<Account> findPage(Integer page, Integer limit, Account account);

    Integer add(Account account);

    Integer update(Account account);

    Integer delete(Integer id);
}
