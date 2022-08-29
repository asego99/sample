package com.xxx.listener;

import com.rabbitmq.client.Channel;
import com.xxx.config.MqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Consumer
 * @Description
 * @Date 2022-08-26 14:26
 */
@Component
public class Consumer {



    //监听队列
    @RabbitListener(queues = MqConfig.BOOT_RABBIT_QUEUE)
    public void getMsg(String msg, Channel channel, Message message) {
//        System.out.println(10/0);//模拟断电异常
        System.out.println("消费者监听到的消息是:"+ msg);

        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
