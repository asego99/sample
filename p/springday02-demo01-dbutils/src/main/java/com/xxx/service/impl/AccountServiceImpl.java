package com.xxx.service.impl;

import com.xxx.bean.Account;
import com.xxx.dao.AccountDao;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-02 10:02
 */
//@Component("accountService")
@Service("accountService")
//@Controller
//@Repository
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
