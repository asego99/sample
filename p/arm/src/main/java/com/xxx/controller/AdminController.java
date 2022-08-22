package com.xxx.controller;

import com.xxx.bean.Admin;
import com.xxx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sys")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/doLogin")
    @ResponseBody
    public int doLogin(String email, String password, HttpSession session) {
        Admin admin = adminService.login(email, password);

        if (admin != null) {
            //增加了登录拦截器,登录成功要存储登录凭证到会话中,否则拦截器一直拦截
            session.setAttribute("login", admin.getEmail());
            return 1;
        }
        return 0;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("login");

        return "redirect:/login.html";
    }

    @PostMapping(value = "/user", produces = "text/html;charset=utf-8")
    @ResponseBody
    public Object getEmail(HttpSession session) {
        return session.getAttribute("login");
    }
}