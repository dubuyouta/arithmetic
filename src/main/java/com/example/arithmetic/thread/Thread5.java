package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/16
 */
public class Thread5 {
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("being");
                synchronized (obj){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end");
                }
            }
        });

        threadA.start();

        Thread.sleep(2000);

        System.out.println("begin interrupt");
        threadA.interrupt();
        System.out.println("end interrupt");


    }
}
