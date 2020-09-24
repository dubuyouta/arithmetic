package com.example.arithmetic.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaobao.chen
 * Create at 2020/9/23
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        //        Executors.newFixedThreadPool(2);
        //        Executors.newSingleThreadExecutor();
        //     Executors.newCachedThreadPool();
        //        Executors.newScheduledThreadPool();
        //        Executors.newSingleThreadScheduledExecutor();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程池任务执行1");
//            }
//        });


        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 1, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor1.allowCoreThreadTimeOut(true);
        threadPoolExecutor1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程池任务执行1");
            }
        });

        threadPoolExecutor1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程池任务执行2");
            }
        });

        threadPoolExecutor1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程池任务执行3");
            }
        });



    }
}
