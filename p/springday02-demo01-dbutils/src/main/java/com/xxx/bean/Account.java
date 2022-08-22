package com.xxx.bean;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Account
 * @Description
 * @Date 2022-08-02 9:29
 */
public class Account {
    private Integer id;
    private String name;
    private Float account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAccount() {
        return account;
    }

    public void setAccount(Float account) {
        this.account = account;
    }

    public Account() {
    }

    public Account(Integer id, String name, Float account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}
