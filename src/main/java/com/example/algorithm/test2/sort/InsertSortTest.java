package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class InsertSortTest {

    public static void main(String[] args) {
        InsertSortTest sortTest = new InsertSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        sortTest.insertSort1(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     *
     * 思想：在前面已经排好的顺序后面，去插入到合适的位置
     * 时间复杂度 O(n^2),最好O(n)
     *
     * 稳定排序
     */
    private void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            /**
             * 此处出错，应该然j=i
             * 每次取前一个进行判断
             * int j = i - 1; j >= 0; j-- 错误
             */
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j - 1] > temp) {
                    //如果默认到0个就是插入位置
                    //将这个元素向右移动，给空出位置
                    array[j] = array[j - 1];
                } else {
                    //如果大于等于
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    private void insertSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j - 1] > temp) {
                    array[j]=array[j-1];
                }else{
                    array[j]=temp;
                    break;
                }
            }
        }
    }
}
