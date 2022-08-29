package com.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserConsumerApplication
 * @Description
 * @Date 2022-08-27 10:59
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
//@EnableFeignClients("com.xxx.feign")
public class UserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public Logger.Level feignLoggerLevel(){
//        return Logger.Level.FULL;
//    }

}
