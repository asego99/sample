package com.xxx;

import com.xxx.config.MqConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.UUID;

@SpringBootTest
class SpringbootMqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() throws IOException {
        CorrelationData messageId = new CorrelationData(UUID.randomUUID().toString());

        rabbitTemplate.convertAndSend(MqConfig.BOOT_RABBIT_EXCHANGE, "wo.ai.ni", "我爱你", messageId);

        System.in.read();
    }


}
