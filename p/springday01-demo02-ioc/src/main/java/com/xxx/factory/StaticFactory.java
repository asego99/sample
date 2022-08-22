package com.xxx.factory;

import com.xxx.dao.AccountDao;
import com.xxx.service.AccountService;
import com.xxx.service.impl.AccountServiceImpl;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName StaticFactory
 * @Description
 * @Date 2022-08-01 15:35
 */
public class StaticFactory {
    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public static AccountService getObject(){
        AccountServiceImpl accountService = new AccountServiceImpl();
        return accountService;
    }
}
