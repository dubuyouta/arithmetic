package com.example.arithmetic.thread;

import java.util.concurrent.DelayQueue;

/**
 * @author xiaobao.chen
 * Create at 2020/9/24
 */
public class DelayQueueTest {

    public static void main(String[] args) {
        DelayQueue<DelayedTest> queue = new DelayQueue<DelayedTest>();
        queue.peek();
    }
}
