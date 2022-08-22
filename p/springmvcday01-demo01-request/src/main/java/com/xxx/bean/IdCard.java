package com.xxx.bean;

import java.io.Serializable;

public class IdCard implements Serializable {
    //身份证号
    private String number;
    //身份证地址
    private String address;

    public IdCard() {
    }

    public IdCard(String number, String address) {
        this.number = number;
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}