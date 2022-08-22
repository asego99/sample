package com.xxx.service;

import com.xxx.bean.Admin;

public interface AdminService {
    Admin login(String email, String password);
}