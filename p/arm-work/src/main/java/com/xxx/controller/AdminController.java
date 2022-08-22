package com.xxx.controller;

import com.xxx.bean.Admin;
import com.xxx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AdminController
 * @Description
 * @Date 2022-08-13 14:51
 */
@Controller
@RequestMapping("/sys")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("doLogin")
    @ResponseBody
    public Integer doLogin(String email, String password, HttpSession session) {
        Admin admin = adminService.login(email, password);
        if (admin != null) {
            session.setAttribute("login", admin.getEmail());
            return 1;
        }
        return 0;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("login");
        //重定向至登录页面
        return "redirect:/login.html";
    }

    @RequestMapping(value = "user", produces ="text/html;charset=utf-8" )
    @ResponseBody
    public Object getEmail(HttpSession session) {
        Object login = session.getAttribute("login");
        return login;
    }
}
