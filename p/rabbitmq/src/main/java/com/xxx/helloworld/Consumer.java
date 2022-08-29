package com.xxx.helloworld;

import com.rabbitmq.client.*;
import com.xxx.utils.RabbitMQClient;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Consumer
 * @Description
 * @Date 2022-08-26 11:03
 */
public class Consumer {
    @Test
    public void consum() throws IOException, TimeoutException {
        Connection connection = RabbitMQClient.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("helloqueue", true, false, false, null);

        channel.basicConsume("helloqueue", true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(body);
                System.out.println(new String(body));
            }
        });

        //死循环,起监听效果
//        while (true) {
//
//        }

        channel.close();
        connection.close();

    }
}
