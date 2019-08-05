package com.concurrent.demo.lock;

public interface Lock {

    boolean lock();

    boolean unLock();
}
