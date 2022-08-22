package com.xxx.service;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountService
 * @Description
 * @Date 2022-08-05 7:50
 */
public interface AccountService {

    //转账
    void transfer(String startName, String TargetName, Float money);
}
