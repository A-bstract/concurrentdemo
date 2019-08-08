package com.concurrent.demo.comment.concurrentUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class NativeThread implements IConcurrent{
    @Override
    public <T> CompletableFuture<T>[] execute(IRunnable<T> runnable) {
        return null;
    }
}
