package com.xxx.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.xxx.bean.User;
import com.xxx.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserController
 * @Description
 * @Date 2022-08-27 11:01
 */
@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class UserController {
//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeign userFeign;

//    @Bean
//    public IRule iRule() {
//        return new RandomRule();
//    }

//    @HystrixCommand(fallbackMethod = "fallbackMethod")
//    @HystrixCommand(fallbackMethod = "fallbackMethod", defaultFallback = "defaultFallback")
//    @HystrixCommand(defaultFallback = "defaultFallback")
    @RequestMapping("/find/{id}")
    public User queryById(@PathVariable Integer id){
//        ServiceInstance serviceInstance = discoveryClient.getInstances("user-provide").get(0);
//
//        //在user-consumer服务中通过RestTemplate调用user-provider服务
//        String url = "http://"+ serviceInstance.getHost() +":"+ serviceInstance.getPort() +"/provide/find/"+id;
//        String url = "http://user-provide/provide/find/"+id;
//
//        User user = restTemplate.getForObject(url, User.class);

        User user = userFeign.findById(id);

        return user;
    }

//    public User defaultFallback() {
//        User user = new User();
//        user.setUsername("全局降级方法调用");
//        return user;
//    }

//    public User fallbackMethod(Integer id) {
//        User user = new User();
//        user.setUsername("局部降级方法调用");
//        return user;
//    }

}
