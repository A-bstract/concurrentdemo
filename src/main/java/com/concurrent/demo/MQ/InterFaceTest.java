package com.concurrent.demo.MQ;

import com.concurrent.demo.MQ.config.RabbitMqEnum;
import com.concurrent.demo.MQ.product.MessageSender;
import com.concurrent.demo.comment.concurrentUtil.IConcurrent;
import com.concurrent.demo.comment.concurrentUtil.IRunnable;
import com.concurrent.demo.comment.concurrentUtil.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@RestController
public class InterFaceTest {

    @Autowired
    private MessageSender ms;

    @RequestMapping("/mq/test")
    public String test(){
        IConcurrent concurrent = new ThreadPool();
        CompletableFuture<Integer>[] execute = concurrent.execute(new IRunnable<Integer>() {
            @Override
            public Integer doRunnable() {
                //Thread.sleep();
                ms.sendRabbitmq(RabbitMqEnum.QueueEnum.TESTQUEUE.getCode(), "yy！！！", RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode());
                return 1;
            }
        });
        Arrays.asList(execute).stream().forEach((item) -> System.out.println(item));
        //阻塞
        CompletableFuture.allOf(execute).join();
        //ms.sendRabbitmq(RabbitMqEnum.QueueEnum.TESTQUEUE.getCode(),"yy！！！", RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode());
        return "成功！";
    }
}
