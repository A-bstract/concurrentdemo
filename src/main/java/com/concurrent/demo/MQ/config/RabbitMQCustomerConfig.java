package com.concurrent.demo.MQ.config;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Headers;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class RabbitMQCustomerConfig {

    static Lock lock = new ReentrantLock();
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQCustomerConfig.class);

    @Bean(name="listenerTest")
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer> listenerTest(ConnectionFactory connectionFactory){
        //ConcurrentKafkaListenerContainerFactory

        //消息的统一过滤器
        //MessageConverter messageConverter = new ObjConsert();
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(5);//允许同时消费数量为5
        factory.setMaxConcurrentConsumers(10);//允许同时最大消费数量为10
        factory.setReceiveTimeout(10000L);//10秒
        //factory.setMessageConverter(messageConverter);//具体的逻辑要自己在ObjConsert里面写
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置手动提交
        factory.setConnectionFactory(connectionFactory);
        return  factory;
    }

}
