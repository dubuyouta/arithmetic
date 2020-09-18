package com.example.arithmetic.thread;

/**
 * ThreadLocal
 *
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class TreadLocalTest {


    private static ThreadLocal<String> local1 = new ThreadLocal<>();

    private static ThreadLocal<String> local2 = new ThreadLocal<>();

    private static ThreadLocal<String> local3 = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                local1.set(Thread.currentThread() + "set valueA1");
                System.out.println(Thread.currentThread() + local1.get());
                local1.remove();
                System.out.println(Thread.currentThread() + local1.get());

                local2.set(Thread.currentThread() + "set valueA2");
                System.out.println(Thread.currentThread() + local2.get());
                local2.remove();
                System.out.println(Thread.currentThread() + local2.get());

                local3.set(Thread.currentThread() + "set valueA3");
                System.out.println(Thread.currentThread() + local3.get());
                local3.remove();
                System.out.println(Thread.currentThread() + local3.get());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                local1.set(Thread.currentThread() + "set valueB1");
                System.out.println(Thread.currentThread() + local1.get());
                local1.remove();
                System.out.println(Thread.currentThread() + local1.get());

                local2.set(Thread.currentThread() + "set valueB2");
                System.out.println(Thread.currentThread() + local2.get());
                local2.remove();
                System.out.println(Thread.currentThread() + local2.get());

                local3.set(Thread.currentThread() + "set valueB3");
                System.out.println(Thread.currentThread() + local3.get());
                local3.remove();
                System.out.println(Thread.currentThread() + local3.get());
            }
        });

        threadA.start();
        threadB.start();
    }
}
