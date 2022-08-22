package com.xxx.service;

import com.xxx.bean.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AdminService
 * @Description
 * @Date 2022-08-13 14:50
 */
public interface AdminService {

    Admin login(String email, String password);
}
