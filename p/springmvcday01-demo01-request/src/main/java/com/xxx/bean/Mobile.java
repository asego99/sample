package com.xxx.bean;

import java.io.Serializable;

public class Mobile implements Serializable {
    //手机名字
    private String mobileName;
    //手机价格
    private Float price;

    public Mobile() {
    }

    public Mobile(String mobileName, Float price) {
        this.mobileName = mobileName;
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mobileName='" + mobileName + '\'' +
                ", price=" + price +
                '}';
    }
}