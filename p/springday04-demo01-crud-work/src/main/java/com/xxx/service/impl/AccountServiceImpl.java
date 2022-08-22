package com.xxx.service.impl;

import com.xxx.bean.Account;
import com.xxx.dao.AccountDao;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-05 7:50
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfer(String startName, String TargetName, Float money) {
        //dao:判断账户是否存在
        Account startAccount = accountDao.getAccountByName(startName);
        Account targetAccount = accountDao.getAccountByName(TargetName);

        if (startAccount != null && targetAccount != null) {
            //service:转账操作
            startAccount.setMoney(startAccount.getMoney() - money);
            targetAccount.setMoney(targetAccount.getMoney() + money);
        }

        //dao:更新数据库数据
        Integer sResult = accountDao.update(startAccount);
        System.out.println("start: "+ sResult);

        System.out.println(10 / 0);

        Integer tResult = accountDao.update(targetAccount);
        System.out.println("target: " + tResult);
    }
}
