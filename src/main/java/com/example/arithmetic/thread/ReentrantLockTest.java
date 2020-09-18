package com.example.arithmetic.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html
 *
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();

    private ReentrantLock fairLock = new ReentrantLock(true);//公平锁
}
