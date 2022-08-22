package com.xxx.service;

import com.xxx.bean.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountService
 * @Description
 * @Date 2022-08-10 18:34
 */
public interface AccountService {

    List<Account> findAll();

    Account findById(Integer id);

    Integer add(Account account);

    Integer update(Account account);

    Integer delete(Integer id);
}
