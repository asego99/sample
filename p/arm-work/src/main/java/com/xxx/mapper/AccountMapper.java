package com.xxx.mapper;

import com.xxx.bean.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountMapper
 * @Description
 * @Date 2022-08-13 13:34
 */
public interface AccountMapper {

//    @Select("select * from account ")
    List<Account> findAll(Account account);

    @Insert("insert into account (name, money) values (#{name}, #{money})")
    Integer add(Account account);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    Integer update(Account account);

    @Delete("delete from account where id = #{id}")
    Integer delete(Integer id);
}
