package com.concurrent.demo.comment.concurrentUtil;

import java.util.concurrent.CompletableFuture;

public interface IConcurrent {
     <T> CompletableFuture<T>[] execute(IRunnable<T> runnable);
}
