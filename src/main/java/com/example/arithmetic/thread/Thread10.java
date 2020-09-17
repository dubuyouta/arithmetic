package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/17
 */
public class Thread10 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        System.out.println("isInterrupted " + threadOne.isInterrupted());

        System.out.println("isInterrupted " + Thread.interrupted());

        System.out.println("isInterrupted " + threadOne.isInterrupted());

        /***
         * Thread.interrupted():获取当前线程的中断标识，并且清除
         * threadOne.isInterrupted(): 获取当前线程的中断标识，但是不清除
         */

        threadOne.join();
        System.out.println("main over");
    }
}
