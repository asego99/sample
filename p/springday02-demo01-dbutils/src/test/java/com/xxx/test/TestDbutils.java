package com.xxx.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xxx.bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName TestDbutils
 * @Description
 * @Date 2022-08-02 9:34
 */
public class TestDbutils {
    @Test
    public void TestInsert() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        //模拟数据
        Account account = new Account(2, "lbb", 1000f);

        QueryRunner qr = new QueryRunner(dataSource);
        int update = qr.update("insert into account values (?,?,?)", account.getId(), account.getName(), account.getAccount());
        System.out.println(update);
    }

    @Test
    public void TestGetOne() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        QueryRunner qr = new QueryRunner(dataSource);
        Account account = qr.query("select * from account where id = ? ", new BeanHandler<Account>(Account.class),1);
        System.out.println(account);
    }

    @Test
    public void TestGetAll() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        QueryRunner qr = new QueryRunner(dataSource);
        List<Account> accounts = qr.query("select * from account ", new BeanListHandler<>(Account.class));
        System.out.println(accounts);
    }
}
