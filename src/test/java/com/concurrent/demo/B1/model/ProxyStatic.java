package com.concurrent.demo.B1.model;

import java.util.Map;

public class ProxyStatic implements ITestDao{
    private ITestDao testDao;

    public ProxyStatic(ITestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Map<String, Object> getInfo(String id) {
        testDao.getInfo("1");
        return null;
    }
}
