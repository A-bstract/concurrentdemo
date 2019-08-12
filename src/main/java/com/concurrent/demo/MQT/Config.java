package com.concurrent.demo.MQT;

import com.bld365.mq.core.template.MQTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public MQTemplate mqTemplate(){
        return new MQTemplate();
    }
}
