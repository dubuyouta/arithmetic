package com.example.arithmetic.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class Thread13 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.incrementAndGet());
    }
}
