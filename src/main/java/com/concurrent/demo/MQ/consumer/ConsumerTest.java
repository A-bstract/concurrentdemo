package com.concurrent.demo.MQ.consumer;

import com.concurrent.demo.MQ.config.RabbitMQCustomerConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//注册bean 如果不注册的话预加载不了监听
@Component("ConsumerTest")
public class ConsumerTest {

    static Lock lock = new ReentrantLock();
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQCustomerConfig.class);

    /**
     * 接收到消息则MQ服务端将ready状态 转换成 Unacked状态。
     * 如果接收端服务停止了并且还有并未消费的消息 ，则将剩余的Unacked状态全部转换成ready状态
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @RabbitListener(containerFactory = "listenerTest", queues = "TOPICTEST1")
    @RabbitHandler // 此注解加上之后可以接受对象型消息
    public void onOrderMessage(Message message, @Headers Map<String, Object> headers,
                               Channel channel) throws IOException {
        logger.info("消息体：" + message);

        //模仿处理请求
        lock.lock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费消息
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // ACK
        channel.basicAck(deliveryTag, false);

        lock.unlock();
    }
}
