package com.concurrent.demo.lock.copy;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

public abstract class MyCopyAQS {

    protected static volatile int state;

    protected static long offSet;

    public static Unsafe UNSAFE = null;

    static {
        try {
            //初始化Unsafe
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);

            //初始化offSet
            offSet = UNSAFE.objectFieldOffset(MyCopyAQS.class.getField("state"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void lock(){
        //用户 + CAS
        for (;;) {
            if(this.tryCondition()){
                //锁成功
                if(compareAndSwap(0,1)){
                    return;
                }else{
                    LockSupport.park();
                }
            }
        }
    }

    public abstract boolean tryCondition();

    public boolean compareAndSwap(int expect,int update){
        return UNSAFE.compareAndSwapInt(this,offSet,expect,update);
    }
}
