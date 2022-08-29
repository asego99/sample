package com.xxx;

import com.xxx.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springboot2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Springboot2Application.class, args);

        User user = context.getBean(User.class);
        System.out.println(user.toString());
    }

}
