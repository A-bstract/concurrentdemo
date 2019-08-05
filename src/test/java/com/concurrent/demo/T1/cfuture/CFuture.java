package com.concurrent.demo.T1.cfuture;

import java.util.concurrent.*;

public class CFuture {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {

        }
        Future<?> submit = executorService.submit(new Test());
        Object o = submit.get();
        System.out.println(o);
        System.out.println("rrr");
    }

    static class Test implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
           // Thread.sleep(10000);
            return 1;
        }
    }
}
