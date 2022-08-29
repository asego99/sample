package com.xxx.test;

import com.rabbitmq.client.Connection;
import com.xxx.utils.RabbitMQClient;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName TestConnection
 * @Description
 * @Date 2022-08-26 10:32
 */
public class TestConnection {
    @Test
    public void test1(){
        Connection connection = RabbitMQClient.getConnection();
        System.out.println(connection);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
