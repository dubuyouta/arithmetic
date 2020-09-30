package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        QuickSortTest sortTest = new QuickSortTest();
        sortTest.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 8种排序复习
     */

    /**
     * 快速排序，不稳定排序，时间复杂度 O(logn),最差(n^2)
     * 空间复杂度 O(1)
     * 排序思想，先找到一个数最为基准，一般是第一个元素，或者中间元素
     * 然后将大于这个元素的数放在基准的右边
     * 将小于这个元素的数放在基准的左边
     * 然后左右递归分别排序，按上面处理
     *
     * 注意边界条件
     */
    public void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0 || low < 0
                || high >=array.length || low > high) {
            return;
        }

        int left = low;
        int right = high;
        //选择第一元素为基准
        int target = array[left];
        while (left < right) {
            //注意此处为大于等于，势必向向左找到第一个小的数，将这个数放在左边
            while (left < right && array[right] >= target) {
                //如果右边的数比target大，还要继续向左找第一个比它小的数的位置
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= target) {
                //继续向右找，找到第一个比基准大的值，需要进行交换
                //势必找到第一个比基准大的数，放在右边
                left++;
            }
            array[right] = array[left];
        }
        //将基准值放在中间，此时的left和right已经相等了
        array[left] = target;
        //在左边递归
        quickSort(array, low, left - 1);
        //向右边递归
        quickSort(array, left + 1, high);
    }

    public void quickSort1(int[] array, int low, int high) {
        if (array == null || array.length == 0 || low < 0 || high >= array.length
                || low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int target = array[left];
        while (left < right) {
            while (left < right && array[right] >= target) {
                //向左
                right--;
            }
            //将右边第一个比基准小的数，放在左边
            array[left] = array[right];
            while (left < right && array[left] <= target) {
                //向右
                left++;
            }
            //将左边第一个比基准大的数，放在右边
            array[right] = array[left];
        }
        //循环完，找到中值
        array[left] = target;
        quickSort(array, low, left - 1);
        quickSort(array, left + 1, high);
    }
}
