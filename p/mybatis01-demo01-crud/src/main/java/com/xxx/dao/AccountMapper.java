package com.xxx.dao;


import com.xxx.bean.Account;
import com.xxx.bean.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {


    Account testFindAccountById(Integer aid);

    User testFindUserById(Integer uid);

    @Results(value = {
            @Result(column = "uid", property = "uid"),
            @Result(property = "user", column = "uid", one = @One(select = "com.xxx.dao.UserMapper.findUserById"))
    })
    @Select("select * from account where id = #{id}")
    Account findAccountById(Integer id);

    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountByUid(Integer uid);
}
