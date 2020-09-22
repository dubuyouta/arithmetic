package com.example.arithmetic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author xiaobao.chen
 * Create at 2020/9/21
 */
public class SemaphoreTest1 {

    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadA IS over");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadB IS over");
                semaphore.release();
            }
        });

        semaphore.acquire(2);

        System.out.println("child thread1,2 is over!");

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadC IS over");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadD IS over");
                semaphore.release();
            }
        });

        semaphore.acquire(2);

        System.out.println("child thread3,4 is over!");

        executorService.shutdown();
    }
}
