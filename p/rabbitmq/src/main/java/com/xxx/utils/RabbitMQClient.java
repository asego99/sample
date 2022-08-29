package com.xxx.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName RabbitMQClient
 * @Description
 * @Date 2022-08-26 10:23
 */
public class RabbitMQClient {
    public static Connection getConnection() {
        // 创建Connection工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.226.100");
        factory.setPort(5672);//注意图形化界面端口才是15672
        factory.setUsername("test");
        factory.setPassword("test");
        factory.setVirtualHost("/test");

        //创建Connection
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
