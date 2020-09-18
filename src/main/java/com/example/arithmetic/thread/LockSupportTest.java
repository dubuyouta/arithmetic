package com.example.arithmetic.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class LockSupportTest {

    public static void main(String[] args) {

        System.out.println("LockSupport park begin");

        LockSupport.parkNanos(2000000);

        System.out.println("LockSupport park end");
    }
}
