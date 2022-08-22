package com.xxx.bean;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private Double money;
    private Integer uid;

    //一对一,一个账号对应一个用户对象↓
    private User user;

    public Account() {
    }

    public Account(Integer id, Double money, Integer uid, User user) {
        this.id = id;
        this.money = money;
        this.uid = uid;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}