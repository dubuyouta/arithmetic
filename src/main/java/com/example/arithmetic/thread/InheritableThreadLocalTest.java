package com.example.arithmetic.thread;

/**
 * @author xiaobao.chen
 * Create at 2020/9/18
 */
public class InheritableThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        /**
         * ThreadLocal 是 无法继承的。子类不能访问父类的 threadLocal 的数据
         *
         */

        local.set("main hello !");
        inheritableThreadLocal.set("inheritableThreadLocal main hello !");


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " " + local.get());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " " + inheritableThreadLocal.get());
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("main is over " + local.get());
        System.out.println("main is over " + inheritableThreadLocal.get());
    }
}
