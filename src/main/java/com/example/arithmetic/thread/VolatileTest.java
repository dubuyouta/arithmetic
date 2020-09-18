package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class VolatileTest implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
        }
        System.out.println("thread " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        new Thread(test).start();

        Thread.sleep(2000);

        test.count = 100;

        System.out.println(test.count);
    }
}
