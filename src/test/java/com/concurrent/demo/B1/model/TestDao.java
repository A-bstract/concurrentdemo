package com.concurrent.demo.B1.model;

import java.util.Map;

public class TestDao implements ITestDao{

    @Override
    public Map<String, Object> getInfo(String id) {
        System.out.println("开始事务。。。");
        return null;
    }
}
