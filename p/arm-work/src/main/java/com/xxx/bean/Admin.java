package com.xxx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Admin
 * @Description
 * @Date 2022-08-13 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private  Integer id;
    private  String  email;
    private  String  password;
}
