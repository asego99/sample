package com.xxx.mapper;

import com.xxx.bean.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AdminDao
 * @Description
 * @Date 2022-08-12 15:45
 */
public interface AdminMapper {
    @Select("select * from admin where email = #{email} and password = #{password}")
    Admin login(@Param("email") String email, @Param("password") String password);//根据email,返回一个对象
}
