package com.example.arithmetic.thread;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xiaobao.chen
 * Create at 2020/9/16
 */
public class Thread4 {

    private static volatile Queue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        queue.add("producer1");
        queue.add("producer2");
        queue.add("producer3");
        queue.add("producer4");
        queue.add("producer5");

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (queue) {
                    while (queue.size() == 5) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("发送成功" + queue.add("producer"));
                    queue.notifyAll();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consumer" + queue.poll());
                    queue.notifyAll();
                }
            }
        }).start();
    }
}
