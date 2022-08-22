package com.xxx.service.impl;

import com.xxx.dao.AccountDao;
import com.xxx.dao.impl.AccountDaoImpl;
import com.xxx.service.AccountService;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-01 10:21
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    public void save(){
        System.out.println("com.xxx.service.impl.AccountDaoServiceImpl");
        accountDao.save();
    }
}
