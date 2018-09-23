package com.example.springbootSSM.activeMq;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者1接受主题消息
 */
@Component
public class Consumer1 {
    private static Logger logger = Logger.getLogger(Consumer1.class);

    @JmsListener(destination = "${spring.activemq.topic_destination}",containerFactory = "jmsListenerContainerFactory1")
    public void onMessage(String message) {
        logger.info("消费者1收到的消息是：" + message);

    }
}
