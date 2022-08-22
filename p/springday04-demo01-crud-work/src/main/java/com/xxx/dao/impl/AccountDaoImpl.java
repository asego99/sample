package com.xxx.dao.impl;

import com.xxx.bean.Account;
import com.xxx.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountDaoImpl
 * @Description
 * @Date 2022-08-05 8:02
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccountByName(String name) {
        Account account = jdbcTemplate.queryForObject("select id,name,account as money from account where name = ?",
                new BeanPropertyRowMapper<>(Account.class), name);
        return account;
    }

    @Override
    public Integer update(Account account) {
        Integer result = jdbcTemplate.update("update account set account = ? where id = ?", account.getMoney(), account.getId());
        return result;
    }
}
