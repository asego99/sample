package com.xxx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data//相当于进行了set/get,tostring
@AllArgsConstructor//相当于全参构造器
@NoArgsConstructor//无参构造
public class Admin implements Serializable {
    private  Integer id;
    private  String  email;
    private  String  password;
}