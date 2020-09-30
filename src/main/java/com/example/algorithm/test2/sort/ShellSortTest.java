package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class ShellSortTest {

    public static void main(String[] args) {
        ShellSortTest sortTest = new ShellSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        sortTest.shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择一个固定的步长，进行插入排序，
     * 然后步长减一，
     * 再进行插入排序
     * 直到步长为1，进行插入
     *
     * 不稳定排序，时间：平均 O(n^1.3) 最好 O（logn） 最差 O(n^2)
     */
    public void shellSort(int[] array, int step) {
        if (array == null || array.length < 2 || step <= 0) {
            return;
        }
        for (; step >= 1; step--) {
            for (int i = step; i < array.length; i += step) {
                int temp = array[i];
                for (int j = i; j >= 0; j -= step) {
                    if (j >= step && array[j - step] > temp) {
                        array[j] = array[j - step];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序理解错误，步长默认是 length/2,然后每次折半
     * @param array
     */
    public void shellSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int gap = array.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                for (int j = i; j >= 0; j -= gap) {
                    if (j >= gap && array[j - gap] > temp) {
                        array[j] = array[j - gap];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
        }

    }
}
