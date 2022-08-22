package com.xxx.service.impl;

import com.xxx.bean.Account;
import com.xxx.mapper.AccountMapper;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-10 18:35
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    @Override
    @Transactional
    public Integer add(Account account) {
        Integer count = accountMapper.add(account);
//        int i = 10 / 0;
        return count;
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
