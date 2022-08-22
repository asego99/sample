package com.xxx.controller;

import com.xxx.bean.Account;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountController
 * @Description
 * @Date 2022-08-10 9:31
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> accounts = accountService.findAll();
        accounts.forEach(System.out::println);
        model.addAttribute("accounts", accounts);
        return "list";
    }

    @RequestMapping("/findById")
    public String findById(Integer id, Model model) {
        Account account = accountService.findById(id);
        System.out.println(account);
        model.addAttribute("account", account);
        return "update";
    }

    @RequestMapping("/add")
    public String add(Account account) {
        System.out.println(accountService.add(account));
        return "redirect:/account/findAll";
    }

    @RequestMapping("/update")
    public String update(Account account) {
        System.out.println(accountService.update(account));
        return "redirect:/account/findAll";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        System.out.println(accountService.delete(id));
        return "redirect:/account/findAll";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }
}
