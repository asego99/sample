package com.xxx.service;

import com.xxx.bean.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AdminService
 * @Description
 * @Date 2022-08-13 11:11
 */
public interface AdminService {

    Admin findAdmin(String email, String password);
}
