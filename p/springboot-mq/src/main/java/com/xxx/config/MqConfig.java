package com.xxx.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName MqConfig
 * @Description
 * @Date 2022-08-26 14:14
 */
@Configuration
public class MqConfig {
    public static final String BOOT_RABBIT_EXCHANGE = "boot_rabbit_exchange";
    public static final String BOOT_RABBIT_QUEUE = "boot_rabbit_queue";

    @Bean
    public Exchange BOOT_RABBIT_EXCHANGE() {
        return ExchangeBuilder.topicExchange(BOOT_RABBIT_EXCHANGE).durable(true).build();
    }

    @Bean
    public Queue BOOT_RABBIT_QUEUE() {
        return new Queue(BOOT_RABBIT_QUEUE, true, false, false, null);
    }

    @Bean
    public Binding binding(Queue BOOT_RABBIT_QUEUE, Exchange BOOT_RABBIT_EXCHANGE) {
        return BindingBuilder.bind(BOOT_RABBIT_QUEUE).to(BOOT_RABBIT_EXCHANGE).with("*.ai.*").noargs();
    }
}
