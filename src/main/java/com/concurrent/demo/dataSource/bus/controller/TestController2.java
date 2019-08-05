package com.concurrent.demo.dataSource.bus.controller;

import com.concurrent.demo.dataSource.bus.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    @Autowired
    @Qualifier("testService2")
    private ITestService rr3;

    @RequestMapping("/test2")
    public String test(){
        Class<? extends ITestService> aClass = rr3.getClass();
        String name = aClass.getName();
        return name;
    }
}

