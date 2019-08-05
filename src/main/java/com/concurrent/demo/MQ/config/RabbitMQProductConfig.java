package com.concurrent.demo.MQ.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProductConfig {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProductConfig.class);

    /**
     * 声明通配符交换机
     * @param rabbitAdmin
     * @return
     */
    @Bean
    TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin){
        TopicExchange contractTopicExchange = new TopicExchange(RabbitMqEnum.Exchange.CONTRACT_TOPIC.getCode());
        rabbitAdmin.declareExchange(contractTopicExchange);
        logger.info("完成主题型交换机bean实例化");
        return contractTopicExchange;
    }

    /**
     * 通配符交换机2
     * @param rabbitAdmin
     * @return
     */
    @Bean
    TopicExchange contractTopicExchangeDurable2(RabbitAdmin rabbitAdmin){
        TopicExchange contractTopicExchange = new TopicExchange(RabbitMqEnum.Exchange.CONTRACT_TOPIC.getCode());
        rabbitAdmin.declareExchange(contractTopicExchange);
        logger.info("完成主题型交换机bean实例化");
        return contractTopicExchange;
    }
    
    /**
     * 直连型交换机
     */
    @Bean
    DirectExchange contractDirectExchange(RabbitAdmin rabbitAdmin) {
        DirectExchange contractDirectExchange = new DirectExchange(RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode());
        rabbitAdmin.declareExchange(contractDirectExchange);
        logger.info("完成直连型交换机bean实例化");
        return contractDirectExchange;
    }

   /*构建队列*/

    @Bean
    Queue queueTest(RabbitAdmin rabbitAdmin){
        Queue queue = new Queue(RabbitMqEnum.QueueName.TESTQUEUE.getCode());
        rabbitAdmin.declareQueue(queue);
        logger.info("测试队列实例化完成");
        return queue;
    }

    //topic 1
    @Bean
    Queue queueTopicTest1(RabbitAdmin rabbitAdmin){
        Queue queue = new Queue(RabbitMqEnum.QueueName.TOPICTEST1.getCode());
        rabbitAdmin.declareQueue(queue);
        logger.info("话题测试队列1实例化完成");
        return queue;
    }
    //topic 2
    @Bean
    Queue queueTopicTest2(RabbitAdmin rabbitAdmin){
        Queue queue = new Queue(RabbitMqEnum.QueueName.TOPICTEST2.getCode());
        rabbitAdmin.declareQueue(queue);
        logger.info("话题测试队列2实例化完成");
        return queue;
    }


    /*在此处完成队列和交换机绑定*/
    @Bean
    Binding bindingQueueTest(@Qualifier("queueTopicTest1")Queue queueTopicTest1, @Qualifier("contractDirectExchange") DirectExchange exchange, RabbitAdmin rabbitAdmin){
        Binding binding = BindingBuilder.bind(queueTopicTest1).to(exchange).with(RabbitMqEnum.QueueEnum.TESTQUEUE.getCode());
        rabbitAdmin.declareBinding(binding);
        logger.info("测试队列与直连型交换机绑定完成");
        return binding;
    }
    //topic binding1
    @Bean
    Binding bindingQueueTopicTest1(Queue queueTopicTest1, @Qualifier("contractTopicExchangeDurable") TopicExchange exchange, RabbitAdmin rabbitAdmin){
        Binding binding = BindingBuilder.bind(queueTopicTest1).to(exchange).with(RabbitMqEnum.QueueEnum.TESTTOPICQUEUE1.getCode());
        rabbitAdmin.declareBinding(binding);
        logger.info("测试队列与话题交换机1绑定完成");
        return binding;
    }

    //topic binding2
    @Bean
    Binding bindingQueueTopicTest2(Queue queueTopicTest2, @Qualifier("contractTopicExchangeDurable2") TopicExchange exchange,RabbitAdmin rabbitAdmin){
        Binding binding = BindingBuilder.bind(queueTopicTest2).to(exchange).with(RabbitMqEnum.QueueEnum.TESTTOPICQUEUE2.getCode());
        rabbitAdmin.declareBinding(binding);
        logger.info("测试队列与话题交换机2绑定完成");
        return binding;
    }
}
