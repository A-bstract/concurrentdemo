package com.concurrent.demo.T1.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class BaseTest extends AbstractQueuedSynchronizer{

    private static final int LOCK_STATE = 1;

    private static final int UNLOCK_STATE = 0;

    @Override
    protected boolean tryAcquire(int unused) {
        //使用compareAndSetState控制AQS中的同步变量
        if (compareAndSetState(UNLOCK_STATE, LOCK_STATE)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int unused) {
        setExclusiveOwnerThread(null);
        //使用setState控制AQS中的同步变量
        setState(UNLOCK_STATE);
        return true;
    }

    public void lock() {
        acquire(LOCK_STATE);
    }

    public boolean tryLock() {
        return tryAcquire(LOCK_STATE);
    }

    public void unlock() {
        release(LOCK_STATE);
    }

    public static void main(String[] args) throws InterruptedException {
        final BaseTest lock = new BaseTest();
        lock.lock();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getId() + " acquired the lock!");
                    lock.unlock();
                }
            }).start();
            // 简单的让线程按照for循环的顺序阻塞在lock上
            //目的是让线程顺序启动
            Thread.sleep(100);
        }

        System.out.println("main thread unlock!");
        lock.unlock();
    }
}
