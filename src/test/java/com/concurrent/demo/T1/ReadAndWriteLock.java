package com.concurrent.demo.T1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLock {

    private static Integer k = 0;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String args[]){
        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new WriteRunnable());
        }*/
        //executorService.shutdown();
        new Thread(new WriteRunnable()).start();
        new Thread(new WriteRunnable()).start();
        new Thread(new ReadRunnable()).start();
    }

    /**
     *  读和读是不互斥的
     */
    static class ReadRunnable implements Runnable{
        Lock readLock = readWriteLock.readLock();
        @Override
        public void run() {
            readLock.lock();
            System.out.println(k);
            readLock.unlock();
        }
    }

    /**
     *  同一个ReadWriteLock对象 未等一个Lock对象释放锁 另一个线程是不能锁住的
     */
    static class WriteRunnable implements Runnable{
        @Override
        public void run() {

            //同一个ReadWriteLock对象
            Lock writeLock = readWriteLock.writeLock();

            //未释放锁之前 另一个线程是不能锁的
            writeLock.lock();
            System.out.println("正在写。。。");
            k++;
            writeLock.unlock();
        }
    }
}
