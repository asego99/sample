package com.xxx.bean;

import java.io.Serializable;

public class Mobile implements Serializable {
    private String num;
    private String brand;
    //get..set..略

    public Mobile() {
    }

    public Mobile(String num, String brand) {
        this.num = num;
        this.brand = brand;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "num='" + num + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}