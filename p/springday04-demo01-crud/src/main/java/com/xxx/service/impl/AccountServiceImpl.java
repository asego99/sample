package com.xxx.service.impl;

import com.xxx.bean.Account;
import com.xxx.dao.AccountDao;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-04 9:46
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;//null

//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    @Override
    @Transactional
    public void transfer(String StartName, String targetName, Float money) {
        Account startAccount = accountDao.findAccountByName(StartName);
        Account targetAccount = accountDao.findAccountByName(targetName);

        if (startAccount != null && targetAccount != null) {
            startAccount.setMoney(startAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);

            Integer result = accountDao.updateAccount(startAccount);
            System.out.println(result);

            System.out.println(10 / 0);

            Integer result2 = accountDao.updateAccount(targetAccount);
            System.out.println(result2);
        }

    }
}
