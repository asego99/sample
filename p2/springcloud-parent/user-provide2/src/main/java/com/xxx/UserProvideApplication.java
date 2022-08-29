package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserProvideApplication
 * @Description
 * @Date 2022-08-27 10:35
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class UserProvideApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProvideApplication.class, args);
    }
}
