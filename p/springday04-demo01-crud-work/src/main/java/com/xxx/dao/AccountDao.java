package com.xxx.dao;

import com.xxx.bean.Account;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountDao
 * @Description
 * @Date 2022-08-05 7:53
 */
public interface AccountDao {

    Account getAccountByName(String name);

    Integer update(Account account);

}
