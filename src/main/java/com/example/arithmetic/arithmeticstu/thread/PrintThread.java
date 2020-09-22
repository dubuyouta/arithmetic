package com.example.arithmetic.arithmeticstu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 交替打印
 *
 * @author xiaobao.chen
 * Create at 2020/9/21
 */
public class PrintThread {

    private static Semaphore semaphoreA = new Semaphore(1);

    private static Semaphore semaphoreB = new Semaphore(0);

    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        /**
                         * 默认传参是1。
                         * */
                        semaphoreA.acquire();
                        System.out.println("A");
                        semaphoreB.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoreB.acquire();
                        System.out.println("B");
                        semaphoreC.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoreC.acquire();
                        System.out.println("C");
                        semaphoreA.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executorService.shutdown();
    }
}
