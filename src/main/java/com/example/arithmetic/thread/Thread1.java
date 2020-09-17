package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/16
 */
public class Thread1 {

    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("i'm is a child thread!");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
