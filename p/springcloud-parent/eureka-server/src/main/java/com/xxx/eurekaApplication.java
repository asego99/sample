package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName eurekaApplication
 * @Description
 * @Date 2022-08-27 11:45
 */
@SpringBootApplication
@EnableEurekaServer
public class eurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(eurekaApplication.class, args);
    }
}
