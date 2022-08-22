package com.xxx.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName User
 * @Description
 * @Date 2022-08-08 14:02
 */
public class User implements Serializable {
    private String name;
    private Integer age;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    //一对一,一个用户有一个身份证属性
    private IdCard idCard;//idCard.number=666

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //一对多,比如一个用户拥有多部手机,即手机集合
    private List<Mobile> mobiles;//mobiles[0].mobileName=huawei

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idCard=" + idCard +
                '}';
    }
}
