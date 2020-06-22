package com.example.arithmetic.arithmeticstu.base;

import java.util.Arrays;

/**
 * 归并排序：采用分而自治的方式进行。
 * 把数据分成子序列，子序列在分成子序列。。。
 * 最低的子序列进行排序之后合并。
 *
 * @author xiaobao.chen
 * Create at 2020-06-22
 */
public class MergeSort {

    public int[] mergeSort(int[] a) {
        if (a.length < 2) {
            return a;
        }
        int mid = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }
}
