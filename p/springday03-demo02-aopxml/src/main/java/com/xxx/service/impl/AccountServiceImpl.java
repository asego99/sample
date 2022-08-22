package com.xxx.service.impl;

import com.xxx.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description
 * @Date 2022-08-03 13:44
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public String add(String name) {
        System.out.println("add");
//        int i = 1 / 0;
        return "ok";
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }
}
