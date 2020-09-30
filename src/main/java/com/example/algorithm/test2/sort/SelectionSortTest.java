package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class SelectionSortTest {

    public static void main(String[] args) {
        SelectionSortTest sortTest = new SelectionSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        sortTest.selectSort1(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     *
     * 思路：选择一个最小的放在数组最前面或者选择一个最大放在最后面
     *
     * 不稳定排序，平均 o(n^2) 最差O（n^2） 最好O（n^2）
     * 空间O(1)
     *
     * 这个放实际是一个交换过程
     */
    private void selectSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    /**
     * 优化，一趟排序找到最大最小的交换
     */
    private void selectSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int leftIndex = 0, rightIndex = array.length - 1;
        for (; leftIndex <= rightIndex; leftIndex++, rightIndex--) {
            int minIndex = leftIndex;
            int maxIndex = rightIndex;
            for (int j = leftIndex + 1; j <= rightIndex; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (leftIndex != minIndex) {
                //交换
                int temp = array[leftIndex];
                array[leftIndex] = array[minIndex];
                array[minIndex] = temp;
            }

            if (rightIndex != maxIndex) {
                //交换
                int temp = array[rightIndex];
                array[rightIndex] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }
}
