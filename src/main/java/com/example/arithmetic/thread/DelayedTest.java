package com.example.arithmetic.thread;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaobao.chen
 * Create at 2020/9/24
 */
public class DelayedTest implements Delayed {

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
