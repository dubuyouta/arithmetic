package com.example.arithmetic.arithmeticstu.base;

/**
 * 希尔排序：插入排序的升级版。
 * 把数据进行分组。（按照希尔增量进行分组--len/2 len/2/2  ....）
 * 每组进行插入排序。
 *
 * @author xiaobao.chen
 * Create at 2020-06-22
 */
public class ShellSort {

    public int[] shellSort(int[] a) {
        int lengh = a.length;
        int gap = lengh / 2;

        while (gap > 0) {
            for (int i = gap; i < lengh; i++) {
                int temp = a[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && a[preIndex] > temp) {
                    a[preIndex + gap] = a[preIndex];
                    preIndex = preIndex - gap;
                }
                a[preIndex + gap] = temp;
            }
            gap = gap / 2;
        }

        return a;
    }
}
