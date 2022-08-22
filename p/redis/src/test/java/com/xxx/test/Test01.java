package com.xxx.test;

import com.alibaba.fastjson.JSON;
import com.xxx.bean.User;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Test01
 * @Description
 * @Date 2022-08-22 9:02
 */
public class Test01 {

    @Test
    public void test01() {
        Jedis jedis = new Jedis("192.168.226.100", 6379);

        jedis.set("k", "v");
        System.out.println(jedis.get("k"));

        jedis.close();
    }

    @Test
    public void test02() {
        Jedis jedis = new Jedis("192.168.226.100", 6379);

        jedis.set(SerializationUtils.serialize("user"), SerializationUtils.serialize(new User(1, "fbb", new Date())));
        byte[] users = jedis.get(SerializationUtils.serialize("user"));
        User user = (User) SerializationUtils.deserialize(users);
        jedis.close();
    }

    @Test
    public void test03() {
        Jedis jedis = new Jedis("192.168.226.100", 6379);

        jedis.set("user2", JSON.toJSONString(new User(2, "lbb", new Date())));

        String jsonStr = jedis.get("user2");

        User user = JSON.parseObject(jsonStr, User.class);
        System.out.println(user);

        jedis.close();
    }


}
