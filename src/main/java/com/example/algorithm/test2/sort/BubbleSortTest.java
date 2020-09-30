package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        BubbleSortTest sortTest = new BubbleSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        sortTest.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     * 每次进行一趟排序，将最大的给冒泡到最后
     * 稳定排序 时间复杂度 O(n^2) 平均为 O(n^2) 最差也是
     * 最好O（n）
     * 空间O(1)
     */
    private void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
