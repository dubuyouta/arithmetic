package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/17
 */
public class Thread9 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println(Thread.currentThread() + " threadOne begin sleep 10s");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " threadOne is interrupted while sleeping");
                }
                System.out.println(Thread.currentThread() + "threadOne " + Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread() + "threadOne over");
            }
        });

        threadOne.start();

        Thread.sleep(1000);

        /***
         * 如果当前线程处于阻塞挂起状态，当被中断之后，当前线程会被激活。然后中断标志会被清除。
         *
         *
         */
        threadOne.interrupt();
        System.out.println("threadOne1 " + threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main over");
    }
}
