package com.xxx.controller;

import com.xxx.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName HelloController
 * @Description
 * @Date 2022-08-08 10:10
 */
@Controller
public class HelloController {

    //    @RequestMapping(value = "hello", method = RequestMethod.GET, params = {"name", "address!=rb", "work=sz"})
//    @RequestMapping("/hello")
//    public String hello(@RequestBody String body) throws UnsupportedEncodingException {
//        body = URLDecoder.decode(body,"UTF-8");
//        System.out.println(body);
//        return "success";
//    }
//    @RequestMapping("/hello/{id}")
//    public String hello(@PathVariable("id") Integer id2) throws UnsupportedEncodingException {
//        System.out.println(id2);
//        return "success";
//    }
    @RequestMapping("/hello")
    public String hello(Model model) throws UnsupportedEncodingException {
        model.addAttribute("name","fbb");
        return "success";
    }

}
