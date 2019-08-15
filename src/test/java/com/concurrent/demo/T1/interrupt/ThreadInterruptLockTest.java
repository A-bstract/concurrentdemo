package com.concurrent.demo.T1.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程中断测试 - 锁
 */
public class ThreadInterruptLockTest {

    static public Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        Thread t1 = new Thread(new MRunnable());
        t1.start();
        t1.interrupt();
        Thread t2 = new Thread(new MRunnable2());
        t2.start();
    }

    public static class MRunnable implements Runnable{

        @Override
        public void run() {
            //即使有线程中断标记也不能使他中断
            //lock.lock();

            //加上这个锁就可以进行线程中断的检查型异常了
            try {
                //此时锁被占用 获取锁失败就会有异常
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("线程锁等待 被抛出了线程中断异常...");
                System.out.println("此时的线程中断标识位是 " + Thread.currentThread().isInterrupted());
            }
            //lock.lockInterruptibly() 如果失败 那么就不是真获得到到锁
            System.out.println("线程继续工作。。。实际上业务不会让他继续工作的");
        }
    }

    public static class MRunnable2 implements Runnable{

        @Override
        public void run() {
            System.out.println("线程2启动");
            //尝试获取锁
            lock.lock();
            //此时获取不到锁 锁一直在main线程中
            System.out.println("获取锁成功");
        }
    }
}
