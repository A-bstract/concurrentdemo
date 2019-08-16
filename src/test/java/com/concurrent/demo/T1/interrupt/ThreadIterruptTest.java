package com.concurrent.demo.T1.interrupt;

/**
 * 线程中断测试 - 常规
 * 线程中断异常会自动将中断标识执为false因为线程为了处理异常已经重新处于就绪状态
 * interrupt标识位是Thread类里的一个属性 ，逻辑flag 但是功能比普通flag多 1、它与线程中断检查性异常相呼应 2、可以处理阻塞 3、他可以判断线程是否中断（系统原因）
 */
public class ThreadIterruptTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MRunnable());
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
    public static class MRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("子线程启动！");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //抛出异常以后  中断标识会被清空 因为线程为了处理异常已经重新处于就绪状态
                System.out.println(Thread.currentThread().isInterrupted());
                //再将它执为中断
                Thread.currentThread().interrupt();
                //这回为true了
                System.out.println(Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    System.out.println("线程阻塞 倒了catch");
                }
                //InterruptedException检查异常会自动清除中断状态
                System.out.println(Thread.currentThread().isInterrupted());
            }

            //让该线程继续工作
            System.out.println("继续工作...");
            //再次中断
            Thread.currentThread().interrupt();
            //这个静态方法会清除中断标记（副作用）
            System.out.println(Thread.interrupted());
            //返回false
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}
