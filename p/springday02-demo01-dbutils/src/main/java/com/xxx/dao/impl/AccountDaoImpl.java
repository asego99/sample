package com.xxx.dao.impl;

import com.xxx.bean.Account;
import com.xxx.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountDaoImpl
 * @Description
 * @Date 2022-08-02 10:01
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner qr;

//    public void setQr(QueryRunner qr) {
//        this.qr = qr;
//    }

    @Override
    public List<Account> findAll() {
        try {
            List<Account> accounts = qr.query("select * from account ", new BeanListHandler<>(Account.class));
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
