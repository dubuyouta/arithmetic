package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class HeapSortTest {

    public static void main(String[] args) {
        HeapSortTest sortTest = new HeapSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        sortTest.heapSort2(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 堆排序
     * 不稳定排序，时间 平均 O（logn）最好O（logn） 最差O（logn）
     * 空间O（1）
     *
     * 思路：让数组的 第i个元素 小于 2i 并且小于 2i+1
     * 整个数组都满足
     *
     * 大顶堆，小顶堆
     *
     * 理解错误，是每次设置出大顶堆，然后再和堆尾交换
     */
    private void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        /**
         * 从数组的一半，开始往前推进，
         * 将 n元素满足 < 2n 并且 <2n+1 下标的元素
         *
         * 堆排序，需要注意边界
         */
        for (int i = array.length / 2; i >= 0; i--) {
            int left = i * 2 >= array.length ? array.length - 1 : i * 2;
            int right = i * 2 + 1 >= array.length ? array.length - 1 : i * 2 + 1;
            int minIndex = array[left] <= array[right] ? left : right;
            if (array[i] > array[minIndex]) {
                //交换
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }

    /**
     *堆的大小逐步减少
     */
    private void heapSort1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int heapSize = array.length; heapSize > 0; heapSize--) {
            buildHeap(array, heapSize);
            //和堆尾交换
            //交换,每次堆顶与最后一个元素交换
            int temp = array[0];
            array[0] = array[heapSize - 1];
            array[heapSize - 1] = temp;
        }
    }

    private void buildHeap(int[] array, int heapSize) {
        for (int gap = heapSize / 2; gap >= 0; gap--) {
            int left = gap * 2 >= heapSize ? heapSize - 1 : gap * 2;
            int right = gap * 2 + 1 >= heapSize ? heapSize - 1 : gap * 2 + 1;
            //找到最大的放在数组尾部
            int maxIndex = array[left] >= array[right] ? left : right;
            /**
             * 构造大顶堆，将 保持 array[n]>array[2n] array[2n+1]
             */
            if (array[gap] < array[maxIndex]) {
                //交换
                int temp = array[gap];
                array[gap] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    private void heapSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int heapSize = array.length; heapSize > 0; heapSize--) {
            for (int i = heapSize / 2; i >= 0; i--) {
                int leftIndex = 2 * i >= heapSize ? heapSize - 1 : 2 * i;
                int rightIndex = 2 * i + 1 >= heapSize ? leftIndex : 2 * i + 1;
                int maxIndex = array[leftIndex] >= array[rightIndex] ? leftIndex : rightIndex;
                if (array[maxIndex] > array[i]) {
                    int temp = array[i];
                    array[i] = array[maxIndex];
                    array[maxIndex] = temp;
                }
            }
            int temp = array[0];
            array[0] = array[heapSize - 1];
            array[heapSize - 1] = temp;
        }

    }
}
