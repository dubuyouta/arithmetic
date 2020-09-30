package com.example.sort.test;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BubbleSortTest {

    private static volatile BubbleSortTest test;
    /**
     * 冒泡排序---交换比较排序
     * 比较交换，大的数据下沉，小的数据上浮
     */
    public synchronized static void main(String[] args) {
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        BubbleSortTest sort = new BubbleSortTest();
        System.out.println(JSON.toJSONString(sort.bubbleSort(array)));
        List list;
        //list.stream().filter()
        ThreadPoolExecutor pool =new ThreadPoolExecutor(5,5,2, TimeUnit.MINUTES,new LinkedBlockingQueue(20));
        Future<BubbleSortTest> future=pool.submit(()->new BubbleSortTest());

    }

    //基本的冒泡排序，

    /**
     * 时间复杂度： 平均=O(n²)  最好=O(n) 最坏=O(n²)
     * 空间复杂度： O(1)
     * 相等元素不改变顺序，稳定排序
     */
    public int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    //前一个比后一个大，交换，让小的在前，大的在后
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
