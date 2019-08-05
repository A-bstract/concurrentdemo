package com.concurrent.demo.lock.redislock;

import com.concurrent.demo.lock.Lock;

public class RedisLock implements Lock {

    @Override
    public boolean lock() {


        return false;
    }

    @Override
    public boolean unLock() {
        return false;
    }

    private class sync extends AbstractRedisSynchronizer{

        @Override
        protected boolean tryAcquire() {
            return false;
        }
    }
}
