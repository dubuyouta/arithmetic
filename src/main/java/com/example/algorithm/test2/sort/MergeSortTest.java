package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class MergeSortTest {
    /**
     * 归并排序
     * 使用分治思想，将一个大数组均分为2组
     * 然后左右2组，2组递归，直到最后分为一个，再陆续合并，变为有序数组
     */
    public static void main(String[] args) {
        MergeSortTest test = new MergeSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.mergeSort(array)));
    }

    /**
     * 时间复杂度 最好=O(nlog₂n) 平均=O(nlog₂n) 最差=O(nlog₂n)
     * 空间复杂度=O(n)
     *
     * 稳定排序 排序的时间复杂度，跟堆排序是一致的
     * 但空间复杂度增加
     *
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        //先分为2半
        int half = array.length / 2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, half));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, half, array.length));
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int[] array = new int[leftArray.length + rightArray.length];
        int left = 0, right = 0;
        int index = 0;
        while (index < array.length) {
            if (left >= leftArray.length) {
                array[index++] = rightArray[right++];
                continue;
            }
            if (right >= rightArray.length) {
                array[index++] = leftArray[left++];
                continue;
            }

            if (leftArray[left] <= rightArray[right]) {
                array[index++] = leftArray[left++];
            } else {
                array[index++] = rightArray[right++];
            }
        }
        return array;
    }
}
