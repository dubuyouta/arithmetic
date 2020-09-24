package com.example.arithmetic.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 基于ReentrantLock 实现
 *
 * @author xiaobao.chen
 * Create at 2020/9/24
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        //非公平
        ArrayBlockingQueue<String> noFairQueue = new ArrayBlockingQueue(10);
        //最后还是调用的offer 方法。
        noFairQueue.add("test0");
        //数据满了，加入失败。独占锁， 如果没满，加入到数据组中。
        noFairQueue.offer("test1");
        noFairQueue.offer("test2");
        noFairQueue.offer("test3");
        //数据满了，进入到条件队列阻塞， 如果没满，加入到数据组中。
        try {
            noFairQueue.put("test4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //取出第一个数据。不删除
        System.out.println(noFairQueue.peek());
        System.out.println(noFairQueue.peek());
        //取出第一个数据。删除
        System.out.println(noFairQueue.poll());
        //取出第一个数据。删除。 如果没有数据，进入条件队列
        try {
            System.out.println(noFairQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //公平
        ArrayBlockingQueue<String> fairQueue = new ArrayBlockingQueue(10, true);
    }
}
