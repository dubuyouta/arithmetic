package com.example.sort.test;

import com.alibaba.fastjson.JSON;

public class ShellSortTest {

    /**
     * 希尔排序 递减增量排序算法
     * 第一个突破O(n²)的排序算法；是简单插入排序的改进版；它与插入排序的不同之处在于，它会优先比较距离较远的元素。
     * <p>
     * 希尔排序是先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序
     * <p>
     * 将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
     * 每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
     * <p>
     * 一般来说最简单的步长取值是初次取数组长度的一半为增量，之后每次再减半，直到增量为1
     */

    public static void main(String[] args) {
        ShellSortTest test = new ShellSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.shellSort1(array)));
    }

    /**
     *时间复杂度 最好=O(n(logn)^2) 平均=O(n(logn)^2) 最差=O(n(logn)^2)
     * log 以2为底的n
     *
     * 不稳定，可能相等元素交换
     *
     * 空间复杂度 O(1)
     * 多次交换排序
     *
     * @param array
     * @return
     */
    public int[] shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = 0; i < array.length; i += gap) {
                for (int j = 0; j + gap < array.length; j += gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
        return array;
    }

    /**
     * 少量交换排序
     *
     * @param array
     * @return
     */
    public int[] shellSort1(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                int j = i;
                for (; j - gap >= 0 && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;

            }
            gap = gap / 2;
        }
        return array;
    }

    public int[] shellSort2(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i += gap) {
                int temp = array[i];
                int currentIndex = i;
                while (currentIndex - gap >= 0 && array[currentIndex - gap] > temp) {
                    array[currentIndex] = array[currentIndex - gap];
                    currentIndex -= gap;
                }
                array[currentIndex] = temp;
            }
            gap = gap / 2;
        }
        return array;
    }
}
