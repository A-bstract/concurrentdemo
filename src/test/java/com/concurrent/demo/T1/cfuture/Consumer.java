package com.concurrent.demo.T1.cfuture;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer extends MysqlConcurrentCatcher {
    @Override
    public List fetch(Object condition) {
        return null;
    }

    @Override
    protected void after() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
