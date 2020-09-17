package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/16
 */
public class Thread2 {

    public static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("I'm is a child thread!");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
    }
}
