package com.concurrent.demo.MQ;

import com.concurrent.demo.MQ.product.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MQ {

    @Autowired
    private MessageSender ms;
    @Test
    public void test(){
        ms.sendRabbitmq(RabbitMqEnumTest.QueueEnum.TESTQUEUE.getCode(),"擦！！！", RabbitMqEnumTest.Exchange.CONTRACT_DIRECT.getCode());
    }
}
