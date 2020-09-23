package com.example.arithmetic.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiaobao.chen
 * Create at 2020/9/22
 */
public class ReentrantReadWriteLockTest {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /** 读锁 */
    private static Lock readLock = reentrantReadWriteLock.readLock();

    /** 写锁 */
    private static Lock writeLock = reentrantReadWriteLock.writeLock();

    static class ReentrantLockList {

        private ArrayList<String> list = new ArrayList<>();

        private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        private static Lock readLock = reentrantReadWriteLock.readLock();

        private static Lock writeLock = reentrantReadWriteLock.writeLock();

        public void add(String e) {
            writeLock.lock();
            try {
                list.add(e);
            } finally {
                writeLock.unlock();
            }
        }

        public void remove(String e) {
            writeLock.lock();
            try {
                list.remove(e);
            } finally {
                writeLock.unlock();
            }
        }

        public String get(int index) {
            readLock.lock();
            try {
                return list.get(index);
            } finally {
                readLock.unlock();
            }
        }
    }
}
