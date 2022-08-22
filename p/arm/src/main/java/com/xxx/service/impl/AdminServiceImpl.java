package com.xxx.service.impl;

import com.xxx.bean.Admin;
import com.xxx.mapper.AdminMapper;
import com.xxx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String email, String password) {
        return adminMapper.login(email, password);
    }
}