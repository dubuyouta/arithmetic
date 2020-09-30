package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class SortAllTemplateTest {

    /**
     * 所有排序的模板，基于这个模板，写新的排序
     * 所有的排序算法，自己写会，并且，知道时间复杂度
     * 和空间复杂度，以及稳定性
     */
    public static void main(String[] args) {
        SortAllTemplateTest allTest = new SortAllTemplateTest();

        int[] array1 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.bubbleSort(array1);
        System.out.println("冒泡："+Arrays.toString(array1));

        int[] array2 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.quickSort(array2, 0, array2.length - 1);
        System.out.println("快排："+Arrays.toString(array2));

        int[] array3 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.insertSort(array3);
        System.out.println("插入："+Arrays.toString(array3));

        int[] array4 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.shellSort(array4);
        System.out.println("希尔："+Arrays.toString(array4));

        int[] array5 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.selectSort(array5);
        System.out.println("选择："+Arrays.toString(array5));

        int[] array6 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        allTest.heapSort(array6);
        System.out.println("堆："+Arrays.toString(array6));

        int[] array7 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array7 = allTest.mergeSort(array7);
        System.out.println("归并："+Arrays.toString(array7));

        int[] array8 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array8 = allTest.countSort(array8);
        System.out.println("计数："+Arrays.toString(array8));

        int[] array9 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array9 = allTest.bucketSort(array9, 4);
        System.out.println("桶："+Arrays.toString(array9));

        int[] array10 = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array10 = allTest.radixSort(array10);
        System.out.println("基数："+Arrays.toString(array10));

        int[] array11 = {1, 2, 3, 7, 7, 7, 8, 9, 10, 15};
        int index11 = allTest.binarySearch(array11, 8);
        System.out.println("二分："+index11);

        int[] array12 = {1, 2, 3, 7, 7, 7, 8, 9, 10, 15};
        int index12 = allTest.binarySearchFirst(array12, 7);
        System.out.println("二分第一个："+index12);

        int[] array13 = {1, 2, 3, 7, 7, 7, 8, 9, 10, 15};
        int index13 = allTest.binarySearchLast(array13, 7);
        System.out.println("二分最后一个："+index13);

    }

    /**
     * 交换排序
     *
     * 冒泡排序
     * 稳定排序
     * 时间 平均 O(n^2) 最差O(n^2) 最好O(n)
     * 空间 O(1)
     */
    public void bubbleSort(int[] array) {

    }

    /**
     *  交换排序
     *
     *  快速排序
     * 不稳定排序
     * 时间 平均 O(logn) 最差O(n^2) 最好O(logn)
     * 空间 O(1)
     */
    public void quickSort(int[] array, int low, int high) {

    }

    /**
     *  插入排序
     *
     *  直接快速排序
     *  稳定排序
     * 时间 平均 O(n^2) 最差O(n^2) 最好O(n)
     * 空间 O(1)
     */
    public void insertSort(int[] array) {

    }

    /**
     *  插入排序
     *
     *  希尔排序
     *  不稳定排序
     * 时间 平均 O(n^1.3) 最差O(n^2) 最好O(logn)
     * 空间 O(1)
     */
    public void shellSort(int[] array) {

    }

    /**
     *  选择排序
     *
     *  希尔排序
     *  不稳定排序
     * 时间 平均 O(n^2) 最差O(n^2) 最好O(n^2)
     * 空间 O(1)
     */
    public void selectSort(int[] array) {

    }

    /**
     *  选择排序
     *
     *  堆排序
     *  不稳定排序
     * 时间 平均 O(logn) 最差O(logn) 最好O(logn)
     * 空间 O(1)
     */
    public void heapSort(int[] array) {

    }

    /**
     *  归并排序
     *
     *  二路排序
     *  稳定排序
     * 时间 平均 O(logn) 最差O(logn) 最好O(logn)
     * 空间 O(n)
     */
    public int[] mergeSort(int[] array) {
        return null;
    }

    /**
     *  非线性
     *
     *  计数
     *  稳定排序
     * 时间 平均 O(n) 最差O(n) 最好O(n)
     * 空间 O(k)
     */
    public int[] countSort(int[] array){
        return null;
    }

    /**
     *  非线性
     *
     *  桶排序
     *  稳定排序
     * 时间 平均 O(n) 最差O(n) 最好O(n^2)
     * 空间 O(n+k)
     */
    public int[] bucketSort(int[] array,int capacity){
        return null;
    }

    /**
     *  非线性
     *
     *  基数
     *  稳定排序
     * 时间 平均 O(n) 最差O(n) 最好O(n)
     * 空间 O(n+k)
     */
    public int[] radixSort(int[] array){
        return null;

    }

    /**
     * 时间 O(logn)
     * @param array
     * @param target
     * @return
     */
    public int binarySearch(int[] array, int target) {
        return -1;
    }

    public int binarySearchFirst(int[] array, int target) {
        return -1;
    }

    public int binarySearchLast(int[] array, int target) {
        return -1;
    }


}
