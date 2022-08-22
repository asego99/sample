package com.xxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.bean.Account;
import com.xxx.mapper.AccountMapper;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-13 13:35
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll(null);
    }

    @Override
    public PageInfo<Account> findPage(Integer page, Integer limit, Account account) {
        PageHelper.startPage(page, limit);
        List<Account> accounts = accountMapper.findAll(account);
        return new PageInfo<>(accounts);
    }

    @Override
    public Integer add(Account account) {
        return accountMapper.add(account);
    }

    @Override
    public Integer update(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public Integer delete(Integer id) {
        return accountMapper.delete(id);
    }
}
