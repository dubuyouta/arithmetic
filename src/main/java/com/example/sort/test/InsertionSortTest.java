package com.example.sort.test;

import com.alibaba.fastjson.JSON;

public class InsertionSortTest {
    /**
     * 直接插入排序-找空插入算法
     * <p>
     * 在要排序的一组数中，假定前n-1个数已经排好序，
     * 现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序
     * 从数列中取出一个元素，从后向前扫描，找到合适的位置插入
     * <p>
     * 选取一个数，从往前比较，碰到比它的数进行交换，碰到小的数据插入后面
     */

    public static void main(String[] args) {
        InsertionSortTest test = new InsertionSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.insertSort1(array)));

    }

    /**
     * 时间复杂度 最好=O(n) 平均=O(n²)  最差=O(n²)
     * 空间复杂度 O(1)
     * 稳定排序
     * @param array
     * @return
     */

    //交换次数较多的实现
    public int[] insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    //后面的数据小于前面的数，进行交换
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    //后面的数比前面数 大或等于，交换停止，已经插入后面
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 交换次数较少的实现
     * <p>
     * 取出一个元素，比前面的数据小，前面的数据就进行后移，等到合适的位置再插入
     *
     * @param array
     * @return
     */
    public int[] insertSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //带比较数据进行保存
            int temp = array[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j - 1] > temp) {
                    //前面的数大于后面的数，前面数后移
                    array[j] = array[j - 1];
                } else {
                    //后面的数比前面数 大或等于，交换停止，已经插入后面
                    array[j] = temp;
                    break;
                }
            }
        }
        return array;
    }

}
