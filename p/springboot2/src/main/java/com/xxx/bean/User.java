package com.xxx.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "user")//批量赋值通过set方法
public class User implements Serializable {//UserProperties
    //@Value("${user.username}")//一个个赋值,通过反射,麻烦
    private String username;
    private String address;
    private List<String> nikename;
    private List<Mobile> mobiles;
    private Map<String,String> map;
    //get..set..略

    public User() {
    }

    public User(String username, String address, List<String> nikename, List<Mobile> mobiles, Map<String, String> map) {
        this.username = username;
        this.address = address;
        this.nikename = nikename;
        this.mobiles = mobiles;
        this.map = map;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("set方法执行啦");
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getNikename() {
        return nikename;
    }

    public void setNikename(List<String> nikename) {
        this.nikename = nikename;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", nikename=" + nikename +
                ", mobiles=" + mobiles +
                ", map=" + map +
                '}';
    }
}