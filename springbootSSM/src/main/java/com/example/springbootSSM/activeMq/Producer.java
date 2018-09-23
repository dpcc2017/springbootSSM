package com.example.springbootSSM.activeMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 主题的生产者
 */
@Service
public class Producer {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }

}
