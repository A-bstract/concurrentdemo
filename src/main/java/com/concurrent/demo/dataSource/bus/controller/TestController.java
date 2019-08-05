package com.concurrent.demo.dataSource.bus.controller;

import com.concurrent.demo.dataSource.bus.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Autowired
    @Qualifier("testService2")
    private ITestService rr;

    @RequestMapping("/test")
    public String test(){
        Class<? extends ITestService> aClass = rr.getClass();
        String name = aClass.getName();
        return name;
    }
}
