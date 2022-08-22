package com.xxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.bean.Account;
import com.xxx.mapper.AccountMapper;
import com.xxx.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-12 9:37
 */

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll(null);
    }

    @Override
    public Integer add(Account account) {
        return accountMapper.add(account);
    }

    @Override
    public Integer delete(Integer id) {
        return accountMapper.delete(id);
    }

    @Override
    public Integer update(Account account) {
        return accountMapper.update(account);
    }

    //分页业务拦截集合, 返回分页信息
    @Override
    public PageInfo<Account> findPage(Integer page, Integer limit, Account account) {
        PageHelper.startPage(page, limit);
        List<Account> accounts = accountMapper.findAll(account);
        log.info("com.xxx.service.impl.AccountServiceImpl#findPage");
        return new PageInfo<Account>(accounts);
    }
}
