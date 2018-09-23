package com.example.springbootSSM.config;

import com.sun.deploy.security.TrustRecorder;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

@Configuration
public class ActivemqConfig {
    @Value("${spring.activemq.topic_destination}")
    String destination;

    /**
     * 配置topic地址
     * @return
     */
    @Bean
    public Topic topic() {
        return new ActiveMQTopic(destination);

    }

   /* *//**
     * 配置持久连接的jmsListenerContainerFactory，可收离线消息
     * @param connectionFactory 连接工厂
     * @return
     */
    @Bean(name = "jmsListenerContainerFactory")
    public JmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListener = new DefaultJmsListenerContainerFactory();
        jmsListener.setConnectionFactory(connectionFactory);
        jmsListener.setPubSubDomain(true);
        jmsListener.setClientId("client");
        jmsListener.setSubscriptionDurable(true);
        return jmsListener;
    }
    @Bean(name = "jmsListenerContainerFactory1")
    public JmsListenerContainerFactory jmsListenerContainerFactory1(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListener = new DefaultJmsListenerContainerFactory();
        jmsListener.setConnectionFactory(connectionFactory);
        jmsListener.setPubSubDomain(true);
        return jmsListener;
    }

}
