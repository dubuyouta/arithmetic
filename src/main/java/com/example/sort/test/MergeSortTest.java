package com.example.sort.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class MergeSortTest {
    /**
     * 归并排序  分治法
     * <p>
     * 归并排序算法是将两个（或两个以上）有序表合并成一个新的有序表，
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * <p>
     * 若将两个有序表合并成一个有序表，称为2-路归并。
     * <p>
     * 如果将有序序列分为多个有序表，就是多路归并
     * <p>
     * 归并排序其实要做两件事：
     * <p>
     * 分解：将序列每次折半拆分
     * 合并：将划分后的序列段两两排序合并
     */

    public static void main(String[] args) {
        MergeSortTest test = new MergeSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.mergeSort(array)));
//        int j=0,x=3;
//        System.out.println(array[j++]);
//        System.out.println(j);
//
//        System.out.println();
//
//        System.out.println(array[++x]);
//        System.out.println(x);


    }

    /**
     * 时间复杂度 最好=O(nlog₂n) 平均=O(nlog₂n) 最差=O(nlog₂n)
     * 空间复杂度=O(n)
     *
     * 稳定排序
     *
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            //长度小于2，不用拆分
            return array;
        }
        int half = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, half);
        int[] right = Arrays.copyOfRange(array, half, array.length);
        return mergeTowArray(mergeSort(left), mergeSort(right));
    }

    /**
     * 注 这里的 left[l++] 是先取值，再加l，等效 取值 left[l],再 l+1;
     * 如 int[] array={1,2,4,5};
     *  int i=0;
     *  array[i++]  此处 取值为 1，i=1
     *  int x=0;
     *  array[++i]  此处 取值为 2  i=1
     *
     *  合并2个数组到一个新的数据，思想是比较2个数组，那个小就放在新数组中，
     *  然后再自加
     *
     * @param left
     * @param right
     * @return
     */
    public int[] mergeTowArray(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, l = 0, r = 0; index < result.length; index++) {
            if (l >= left.length) {
                result[index] = right[r++];
                /**
                 * 此处代码等效
                 *  result[index] = right[r];
                 *  r++;
                 */
            } else if (r >= right.length) {
                result[index] = left[l++];
            }else if (left[l] < right[r]) {
                result[index] = left[l++];
            }else {
                result[index] = right[r++];
            }

        }

        return result;
    }
}
