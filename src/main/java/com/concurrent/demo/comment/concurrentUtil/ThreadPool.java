package com.concurrent.demo.comment.concurrentUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ThreadPool implements IConcurrent{

    @Override
    public CompletableFuture[] execute(IRunnable runnable) {
        Integer threadNum = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        List<String> listIteration = Arrays.asList("1","1","1","1","1","1","1","1","1","1");

        Stream<CompletableFuture<Integer>> rStream = listIteration.stream().map((s) -> {
            return CompletableFuture.supplyAsync(() -> {
                return runnable.doRunnable();
            },executorService);
        });
        CompletableFuture[] futures = rStream.toArray(CompletableFuture[]::new);
        return futures;
    }
}
