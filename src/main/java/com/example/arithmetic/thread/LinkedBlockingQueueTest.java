package com.example.arithmetic.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 基于 reentrantLock 实现的。
 *
 * @author xiaobao.chen
 * Create at 2020/9/24
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("test0");

        //在队列尾部加入一个数据，如果队列满了，就加入失败
        queue.offer("test1");
        //在队列尾部加入一个数据，如果队列满了，就进入条件队列
        try {
            queue.put("test2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //取出队列中的第一个数据
        System.out.println(queue.peek());
        //取出队列中的第一个数据，且删除
        System.out.println(queue.poll());

        //取出队列中的第一个数据，且删除，如果队列中无数据，那么会进入条件队列被阻塞
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
