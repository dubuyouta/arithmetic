package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/17
 */
public class Thread12 {

    private static Object resourceA = new Object();

    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + "get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "wait get resourceB");
                }
            }
        });

        //设置为守护线程。
        threadA.setDaemon(true);
        threadA.start();
        System.out.println("main over");
    }
}
