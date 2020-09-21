package com.example.arithmetic.thread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://tech.meituan.com/2019/12/05/aqs-theory-and-apply.html
 *
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class ReentrantLockTest {

    /** 非公平锁 */
    private static ReentrantLock lock = new ReentrantLock();

    /** 公平锁 */
    private static ReentrantLock fairLock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        Condition condition = lock.newCondition();

        /**
         * 非公平锁
         *
         */
        //        lock.lock();
        /**尝试获取锁，获取失败不会阻塞线程。*/
        //        lock.tryLock();
        /**尝试获取锁，在给定的时间范围内没有获取到锁，返回失败*/
        lock.tryLock(2, TimeUnit.SECONDS);
        try {
            System.out.println("ReentrantLock nofairSync ");
        } finally {
            lock.unlock();
        }

        /**
         * 公平锁
         *
         */
        fairLock.lock();
        try {
            System.out.println("ReentrantLock fairSync ");
        } finally {
            fairLock.unlock();
        }
    }

    /**
     * 实现一个简单的线程安全list
     */
    static class ReentrantLockList {

        private ArrayList<String> arrayList = new ArrayList<>();

        private volatile ReentrantLock lock = new ReentrantLock();

        public void add(String e) {
            lock.lock();
            try {
                arrayList.add(e);
            } finally {
                lock.unlock();
            }
        }

        public void remove(String e) {
            lock.lock();
            try {
                arrayList.remove(e);
            } finally {
                lock.unlock();
            }
        }

        public String get(int index) {
            lock.lock();
            try {
                return arrayList.get(index);
            } finally {
                lock.unlock();
            }
        }
    }
}
