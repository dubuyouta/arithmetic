package com.example.arithmetic.problem;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 利用ConcurrentHashMap 实现 在多线程环境下 ，key的value值做自增操作
 * 分析：1.value 需要使用可以解决自增原子性的问题 AtomicInteger
 * 2.查询，新增，赋值 需要使用原子性操作。
 *
 * @author xiaobao.chen
 * Create at 2020-08-03
 */
public class problem1 {

    private static ConcurrentHashMap<String, AtomicInteger> a = new ConcurrentHashMap();

    public static void main(String[] args) throws InterruptedException {
        a.put("test", new AtomicInteger(0));

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment("test");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment("test");
            }
        }).start();

        Thread.sleep(10);

        System.out.println(a.get("test"));
    }

    public static void increment(String key) {
        AtomicInteger atomicInteger = a.putIfAbsent(key, new AtomicInteger(1));
        atomicInteger.getAndIncrement();
    }
}
