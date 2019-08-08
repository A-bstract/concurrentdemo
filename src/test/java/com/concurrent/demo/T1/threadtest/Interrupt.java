package com.concurrent.demo.T1.threadtest;

public class Interrupt {

    public static volatile Integer state = 0;

    public static void main(String args[]){
        Thread t1 = new Thread(new TestRun());
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

        state = 1;
        System.out.println("main线程退出");
    }

    public static class TestRun implements Runnable{
        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            }

            while (true){
                if(state == 1){
                    System.out.println("线程已逻辑退出");
                    return;
                }else{
                    System.out.println("线程执行中。。。");
                }
            }
        }
    }
}
