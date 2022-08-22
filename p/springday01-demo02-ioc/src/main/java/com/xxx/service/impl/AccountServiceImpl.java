package com.xxx.service.impl;

import com.xxx.dao.AccountDao;
import com.xxx.dao.impl.AccountDaoImpl;
import com.xxx.service.AccountService;

import java.util.*;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-01 14:13
 */
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao = new AccountDaoImpl();
//    String name;
//    Integer age;
//    Date date;

    //    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
    @Override
    public void save() {
        System.out.println("com.xxx.service.impl.AccountServiceImpl.save");
        accountDao.save();
    }
//
//    public AccountServiceImpl() {
//    }
//
//    public AccountServiceImpl(AccountDao accountDao, String name, Integer age, Date date) {
//        this.accountDao = accountDao;
//        this.name = name;
//        this.age = age;
//        this.date = date;
//    }
//
//    @Override
//    public String toString() {
//        return "AccountServiceImpl{" +
//                "accountDao=" + accountDao +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", date=" + date +
//                '}';
//    }

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "accountDao=" + accountDao +
                ", myStrs=" + Arrays.toString(myStrs) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }
}
