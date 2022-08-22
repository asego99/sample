package com.xxx.controller;

import com.github.pagehelper.PageInfo;
import com.xxx.bean.Account;
import com.xxx.bean.TableData;
import com.xxx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName AccountController
 * @Description
 * @Date 2022-08-13 13:37
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
        return "list";
    }

    @RequestMapping("/find2")
    @ResponseBody
    public TableData<Account> findPage(Integer page, Integer limit, Account account) {
        PageInfo<Account> pageInfo = accountService.findPage(page, limit, account);
        return new TableData<Account>("ok", 0, pageInfo.getList(), pageInfo.getTotal());
    }

    @RequestMapping("/add2")
    @ResponseBody
    public Integer add(@RequestBody Account account) {
        Integer count = accountService.add(account);
        return count;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Integer update(@RequestBody Account account) {
        Integer count = accountService.update(account);
        return count;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Integer delete(@PathVariable Integer id) {
        Integer count = accountService.delete(id);
        return count;
    }

    @RequestMapping("/batDel")
    @ResponseBody
    public Integer batDel(@RequestParam List<Integer> ids) {
        int count = 0;
        if (ids != null && ids.size() > 0) {
            for (Integer id : ids) {
                count += accountService.delete(id);
            }
        }
        return count;
    }

    //account

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "forward:/WEB-INF/pages/index.html";
    }

    @RequestMapping("/toUsers")
    public String toUsers() {
        return "forward:/WEB-INF/pages/users.html";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate() {
        return "forward:/WEB-INF/pages/update.html";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "forward:/WEB-INF/pages/add.html";
    }
}
