package com.xxx.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.xxx.utils.RabbitMQClient;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Publisher
 * @Description
 * @Date 2022-08-26 10:25
 */
public class Publisher {
    @Test
    public void publish() throws IOException, TimeoutException {
        Connection connection = RabbitMQClient.getConnection();

        Channel channel = connection.createChannel();

        channel.basicPublish("", "helloqueue", null, "你好".getBytes());

        channel.close();
        connection.close();
    }
}
