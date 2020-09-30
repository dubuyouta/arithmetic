package com.example.sort.test3;

import java.util.Arrays;

public class InsertSortTest3 {

    public static void main(String[] args) {
        InsertSortTest3 test = new InsertSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test2(array)));
    }

    private int[] test(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        /**
         * 插入排序从低2个开始，假设前n个数据有序
         * 从第j个元素开始，先暂存第j个元素，j比j-1小，
         * 前面的元素都有后移
         */
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[j];
            for (; j >= 0; j--) {
                /**
                 * 此处错误 array[j]的前一项 array[j-1] 跟 temp的比较
                 */
                /**
                 * 此处j>0 并不是真正的条件，而是j-1>=0 因为 j>0 最小都是1
                 */
                if (j > 0 && array[j] < array[j - 1]) {
                    array[j] = array[j - 1];
                }
                /**
                 * 错误原因，此处一旦不能达成条件，就说明走到第0个或，者已经到合适的位置
                 */
            }
            if (i != j) {
                System.out.println(j);
                array[j] = temp;
            }
        }
        return array;
    }

    private int[] test2(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    array[j] = temp;
                    //满足条件一定要终止
                    break;
                }
            }
        }
        return array;
    }
}
