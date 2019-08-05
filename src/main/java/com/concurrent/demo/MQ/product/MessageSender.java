package com.concurrent.demo.MQ.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 消息发送
 */
@Component("MessageSender")
public class MessageSender implements RabbitTemplate.ConfirmCallback{

    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送
     * @param routeKey 路由key
     * @param obj 消息体
     * @param modeCode 交换机名
     */
    public int sendRabbitmq(String routeKey,Object obj,String modeCode) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.info("send: " + correlationData.getId());
        this.rabbitTemplate.convertAndSend(modeCode, routeKey , obj, correlationData);
        return 1;
    }

    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean b, @Nullable String s) {

    }
}
