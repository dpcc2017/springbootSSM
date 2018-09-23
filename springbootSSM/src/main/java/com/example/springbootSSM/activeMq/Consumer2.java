package com.example.springbootSSM.activeMq;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者2接受主题消息
 */
@Component
public class Consumer2 {
    private static Logger logger = Logger.getLogger(Consumer2.class);

    @JmsListener(destination = "${spring.activemq.topic_destination}",containerFactory = "jmsListenerContainerFactory1")

    public void recieveMessage(String message) {
        logger.info("消费者2收到的消息是：" + message);
    }
}
