package com.concurrent.demo.T1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    public static void main(String args[]) throws InterruptedException {
        lock.lock();
        new Thread(new MyRunnable()).start();
        condition.await();
        new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        }).start();
        //lock.unlock();
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("111");
            lock.lock();
            condition.signal();
            lock.unlock();
        }
    }
}
