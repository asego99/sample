package com.xxx.service;

import com.github.pagehelper.PageInfo;
import com.xxx.bean.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountService
 * @Description
 * @Date 2022-08-13 13:36
 */
public interface AccountService {

    List<Account> findAll();

    PageInfo<Account> findPage(Integer page, Integer limit, Account account);

    Integer add(Account account);

    Integer update(Account account);

    Integer delete(Integer id);
}
