package com.concurrent.demo.T1;

import org.junit.Test;

/**
 * 1、synchronized加在非静态方法前和synchronized(this)都是锁住了这个类的对象，如果多线程访问，对象不同，就锁不住，对象固定是一个，就可锁住。

 2、synchronized(类名.class)和加在静态方法前，是锁住了代码块，不管多线程访问的时候对象是不是同一个，能缩小代码段的范围就尽量缩小，能在代码段上加同步就不要再整个方法上加同步，缩小锁的粒度。

 ***对象监视器于对象完全隔离 加 synchronized 才是启动对象监视器 所以要想同步 每一个被同步的对象都要加上 synchronized
 */
public class DeadLock {

    public static Integer a = 1;

    public static Integer b = 2;

    class runnablea implements Runnable{
        @Override
        public void run() {
            synchronized (a){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(b.intValue());
            }
        }
    }

    class runnableb implements Runnable{
        @Override
        public void run() {
            synchronized (b){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(a.intValue());
            }
        }
    }

    @Test
    public void demo() throws InterruptedException {
        System.out.println("111");
        Thread t1 = new Thread(new runnablea());
        Thread t2 = new Thread(new runnableb());
        t1.start();
        t2.start();
        Thread.sleep(10000);
    }

    public static void main(String args[]) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (DeadLock.a){
                    System.out.println("锁住a");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(2000);
        synchronized (DeadLock.a){
            DeadLock.a = 8;
        }
        System.out.println("main线程：" + DeadLock.a);
    }
}
