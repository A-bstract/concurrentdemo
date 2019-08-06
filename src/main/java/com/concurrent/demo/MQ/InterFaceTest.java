package com.concurrent.demo.MQ;

import com.concurrent.demo.MQ.config.RabbitMqEnum;
import com.concurrent.demo.MQ.product.MessageSender;
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

        Integer threadNum = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        List<String> listIteration = Arrays.asList("1","1","1","1","1","1","1","1","1","1");

        Stream<CompletableFuture<Integer>> rStream = listIteration.stream().map((s) -> {
            return CompletableFuture.supplyAsync(() -> {
                return excute();
            },executorService);
        });
        CompletableFuture[] futures = rStream.toArray(CompletableFuture[]::new);
        //阻塞
        //CompletableFuture.anyOf(futures).join();
        //ms.sendRabbitmq(RabbitMqEnum.QueueEnum.TESTQUEUE.getCode(),"yy！！！", RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode());
        return "成功！";
    }

    private int excute(){
        return ms.sendRabbitmq(RabbitMqEnum.QueueEnum.TESTQUEUE.getCode(),"yy！！！", RabbitMqEnum.Exchange.CONTRACT_DIRECT.getCode());
    }
}
