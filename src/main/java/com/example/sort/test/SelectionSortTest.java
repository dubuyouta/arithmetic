package com.example.sort.test;

import com.alibaba.fastjson.JSON;

public class SelectionSortTest {
    /**
     * 选择排序 选择排序的基本思想：比较 + 交换
     * <p>
     * 在未排序序列中找到最小（大）元素，
     * 存放到未排序序列的起始位置。在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
     */

    public static void main(String[] args) {
        SelectionSortTest test=new SelectionSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.selectionSort(array)));
    }

    /**
     * 时间复杂度：最好=O(n²) 最差=O(n²) 平均=O(n²)
     * 空间复杂度 =O(1)
     *
     * 不稳定排序，
     * 选择最小的数，可能交换
     */
    public int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    //后面的数比前面的数小，则保存小值得索引
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
}
