package com.concurrent.demo.T1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java原子类在高并发情况下情况
 */
public class Atomic {
    public static void main(String args[]){
        AtomicInteger k = new AtomicInteger();

        //老规矩 线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int i1 = k.addAndGet(1);
                }
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){
        }
        System.out.println(k);
    }
}
