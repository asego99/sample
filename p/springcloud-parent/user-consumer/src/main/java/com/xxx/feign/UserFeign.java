package com.xxx.feign;

import com.xxx.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName UserFeign
 * @Description
 * @Date 2022-08-29 9:20
 */
@FeignClient(name = "user-provide")
public interface UserFeign {
    @RequestMapping("/consumer/find/{id}")
    User findById(@PathVariable("id") Integer id);
}
