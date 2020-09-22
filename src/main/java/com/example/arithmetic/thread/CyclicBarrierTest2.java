package com.example.arithmetic.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xiaobao.chen
 * Create at 2020/9/21
 */
public class CyclicBarrierTest2 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("wait all child thread over!");
    }
}
