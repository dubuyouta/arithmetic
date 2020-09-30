package com.example.algorithm.test2.thread;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class Test25 {
    /**
     * 3 个线程交替打印出abc
     */
    public static void main(String[] args) {
        Test25 test25 = new Test25();
        test25.start();
    }

    private volatile int index = 1;

    private Object lock = new Object();

    private void start() {
        Thread threadA = new Thread(new PrintRunnable());
        Thread threadB = new Thread(new PrintRunnable());
        Thread threadC = new Thread(new PrintRunnable());
        threadA.start();
        threadB.start();
        threadC.start();
    }

//    implements volatile synchronized
//    implements volatile synchronized
//    implements
//    volatile synchronized
//
//    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 10,
//            10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    /**unique
     *  CREATE TABLE `user_info`{
     *      `id` int(11) NOT NULL AUTO_INCREMENT,
     *      `name` varchar(30) default null,
     *      `address` varchar(255) default null,
     *      `mobile` varchar(13) default null,
     *      `age` int(11) default null,
     *      primary key  (`id`) using btree,
     *      unique index `mobile` (`mobile`) using btree,
     *      index `name_age_id`(`name`,`age`) using bree
     *  }engine=InnoDB
     *
     *  implements Runnable
     *  synchronized volatile
     *  Arrays.copyOfRange()
     *
     */

    class PrintRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                if (index == 1) {
                    System.out.print("A ");
                } else if (index == 2) {
                    System.out.print("B ");
                } else if (index == 3) {
                    System.out.print("C ");
                }
                index = index + 1;
            }
        }
    }
}
