package com.example.arithmetic.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();

    private ReentrantLock fairLock = new ReentrantLock(true);//公平锁
}
