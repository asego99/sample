package com.xxx.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName PublisherConfirmAndReturnConfig
 * @Description
 * @Date 2022-08-26 19:25
 */

@Component
public class PublisherConfirmAndReturnConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("消息已经送达到Exchange");
        } else {
            System.out.println("消息没有送达到Exchange");
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("消息没有送达到Queue");
    }
}
