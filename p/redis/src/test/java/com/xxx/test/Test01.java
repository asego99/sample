package com.xxx.test;

import com.alibaba.fastjson.JSON;
import com.xxx.bean.User;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void test04() {
        Jedis jedis = new Jedis("192.168.226.100", 6379);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(3, "lbb", new Date()));
        users.add(new User(4, "lbb", new Date()));
        users.add(new User(5, "lbb", new Date()));
        users.add(new User(6, "lbb", new Date()));

        jedis.set("user3", JSON.toJSONString(users));

        String user3 = jedis.get("user3");

        List<User> userList = JSON.parseArray(user3, User.class);
        System.out.println(userList);

        jedis.close();
    }

    @Test
    public void test05() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

        poolConfig.setMaxTotal(100);
        poolConfig.setMaxIdle(10);
        poolConfig.setMinIdle(5);
        poolConfig.setMaxWaitMillis(3000);//3秒拿不到连接就超时

        JedisPool jedisPool = new JedisPool(poolConfig, "192.168.226.100", 6379);

        Jedis jedis = jedisPool.getResource();
        jedis.set("k2", "v2");
        String value = jedis.get("k2");
        System.out.println(value);

        jedis.close();
    }

    @Test
    public void test06() {
        long start = System.currentTimeMillis();

        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

        poolConfig.setMaxTotal(100);
        poolConfig.setMaxIdle(10);
        poolConfig.setMinIdle(5);
        poolConfig.setMaxWaitMillis(3000);//3秒拿不到连接就超时

        JedisPool jedisPool = new JedisPool(poolConfig, "192.168.226.100", 6379);

        Jedis jedis = jedisPool.getResource();//管道
        Pipeline pipelined = jedis.pipelined();

        for (int i = 0; i < 10000; i++) {
            pipelined.incr("key");
        }

        List<Object> objects = pipelined.syncAndReturnAll();
        System.out.println(objects);

        jedis.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
