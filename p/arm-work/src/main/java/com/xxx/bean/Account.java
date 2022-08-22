package com.xxx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Account
 * @Description
 * @Date 2022-08-13 13:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;
}
