package com.xxx.mapper;

import com.xxx.bean.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AdminMapper
 * @Description
 * @Date 2022-08-13 14:47
 */
public interface AdminMapper {

    @Select("select * from admin where email = #{email} and password = #{password}")
    Admin login(@Param("email") String email,@Param("password") String password);
}
