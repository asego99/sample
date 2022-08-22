package com.xxx.controller;

import com.xxx.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName HelloController
 * @Description
 * @Date 2022-08-09 9:05
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
//        System.out.println(10 / 0);
        System.out.println("hello");
        return "success";
    }

    @RequestMapping("/v")
    public void v(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("v");
//        response.getWriter().print("back to browser");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("返回给浏览器一句话");

//        response.sendRedirect("/index.jsp");
//        response.sendRedirect("http://www.baidu.com");//重定向


//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);//(内部)转发
    }

    @RequestMapping("/mv")
    public ModelAndView mv() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "fbb");
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/rd")
    public String rd(Model model) {
        System.out.println("rd");
        model.addAttribute("name", "lbb");
        return "redirect:http://www.baidu.com";
    }

    @RequestMapping("fw")
    public String fw(Model model) {
        System.out.println("fw");
        model.addAttribute("name", "lbb");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/json")
    @ResponseBody
    public User json(@RequestBody User user) {
        System.out.println(user);
        user.setName("gd");
        return user;
    }

}
