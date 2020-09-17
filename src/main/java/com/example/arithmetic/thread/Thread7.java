package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/16
 */
public class Thread7 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadone is over");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadtwo is over");
            }
        });

        threadA.start();
        threadB.start();
        System.out.println("wait child thread over");

        threadA.join();
        threadB.join();
        System.out.println("all child threadtwo is over");


    }
}
