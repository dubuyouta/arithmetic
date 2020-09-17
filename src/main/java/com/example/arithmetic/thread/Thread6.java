package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/16
 */
public class Thread6 {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin");
                synchronized (obj) {
                    try {
                        obj.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end");
                }
            }
        });

        threadA.start();

        Thread.sleep(4000);
        System.out.println("main over");
    }
}
