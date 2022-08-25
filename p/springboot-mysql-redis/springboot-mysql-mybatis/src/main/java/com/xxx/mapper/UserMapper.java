package com.xxx.mapper;

import com.xxx.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserMapper
 * @Description
 * @Date 2022-08-25 15:07
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();
}
