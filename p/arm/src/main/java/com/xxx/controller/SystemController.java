package com.xxx.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xxx.bean.Admin;
import com.xxx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller//如果之前写的是@RestController,下面有了登录成功跳转首页页面,所以要改为@Controller
@RequestMapping("/sys")
public class SystemController {
    @Autowired
    private AdminService adminService;

    //登录
    @RequestMapping("/doLogin")
    @ResponseBody//下面有了登录成功跳转首页页面,上面改为@Controller,如果不是页面跳转返回json要加上响应体
    public String doLogin(HttpSession session, Admin admin){//HttpSession,用于存凭证,存数据参数
        System.out.println("admin--->"+admin);
        Admin result = adminService.login(admin.getEmail(),admin.getPassword());

        if(result != null){//登录成功,设置凭证
            session.setAttribute("user",admin.getEmail());
            return "1";  //"1"代表成功,"0"代表失败
        }

        return "0";
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");//清除session
        return "redirect:/login.html";
    }

    //得到邮箱账号名,说白了就是得到登录凭证即可,这里存储邮箱到会话中作为凭证
    @RequestMapping(value = "/user",produces = "text/html;charset=utf-8")//处理响应的中文乱码比如下面的请登录中文↓
    @ResponseBody
    public String user(HttpSession session){
        String user = (String) session.getAttribute("user");

        if(user==null){
            return "请登录";//没有凭证,返回请登录,注意用上面的方式来解决中文乱码↑
        }

        return user;//有凭证,则返回邮箱账户
    }
}