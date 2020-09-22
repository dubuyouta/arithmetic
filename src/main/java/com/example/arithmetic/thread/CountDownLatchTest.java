package com.example.arithmetic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author xiaobao.chen
 * Create at 2020/9/21
 */
public class CountDownLatchTest {

    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
                System.out.println("child threadA over!");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
                System.out.println("child threadB over!");
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");
    }
}
