package com.concurrent.demo.springtest;

import com.concurrent.demo.MQ.config.RabbitMqEnum;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({TestProperties.class})
public class ConfigTest {

    private TestProperties testProperties;

    public ConfigTest(TestProperties testProperties) {
        this.testProperties = testProperties;
        System.out.println(testProperties.getConfig().getCode());
        System.out.println(testProperties.getConfig().getName());
        System.out.println(testProperties.getServer_address());
    }
}
