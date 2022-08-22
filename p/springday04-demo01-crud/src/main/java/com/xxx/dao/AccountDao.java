package com.xxx.dao;

import com.xxx.bean.Account;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountDao
 * @Description
 * @Date 2022-08-04 9:50
 */
public interface AccountDao {
    Account findAccountByName(String name);

    Integer updateAccount(Account account);
}
