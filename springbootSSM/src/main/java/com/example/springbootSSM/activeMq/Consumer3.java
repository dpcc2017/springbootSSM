package com.example.springbootSSM.activeMq;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer3 {
    private static Logger logger = Logger.getLogger(Consumer3.class);

    @JmsListener(destination = "${spring.activemq.topic_destination}",containerFactory = "jmsListenerContainerFactory")
    public void receieveMsg(String message) {
        logger.info("Consumer3可收到持久化消息：" + message);
    }
}
