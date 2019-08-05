package com.concurrent.demo.lock.redislock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public abstract class AbstractRedisSynchronizer{

    protected abstract boolean tryAcquire();


}
