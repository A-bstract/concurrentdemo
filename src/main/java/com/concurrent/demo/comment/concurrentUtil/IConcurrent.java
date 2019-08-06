package com.concurrent.demo.comment.concurrentUtil;

public interface IConcurrent {
     <T> T execute(IRunnable<T> runnable);
}
