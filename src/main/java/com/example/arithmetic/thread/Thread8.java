package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/17
 */
public class Thread8 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("current thread" + Thread.currentThread() + " hello");
                }
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread interrupt child thread");
        thread.interrupt();

        thread.join();
        System.out.println("main over");
    }
}
