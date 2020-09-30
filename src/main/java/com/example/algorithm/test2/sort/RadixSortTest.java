package com.example.algorithm.test2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class RadixSortTest {
    /**
     * 基数排序，
     * 是按数位排序的，一半先排个位，再排十位，最后百位等等
     * 时间复杂度：o（n*k） 空间复杂度 o（n+k）
     */

    public static void main(String[] args) {
        RadixSortTest sortTest = new RadixSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array = sortTest.radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    public int[] radixSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int max = array[0];
        //找到最大数
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //判断最大值有几位数
        int num = 0;
        while (max > 0) {
            max = max / 10;
            num++;
        }
        List<List<Integer>> bucketList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>(array.length));
        }
        int mod = 10, div = 1;
        for (int i = 0; i < num; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int index = (array[j] % mod) / div;
                bucketList.get(index).add(array[j]);
            }
            //再将桶内的数据拼接到一起，赋值给array，便于下次循环
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                List<Integer> tempList = bucketList.get(j);
                for (int k = 0; k < tempList.size(); k++) {
                    array[index++] = tempList.get(k);
                }
                //处理完要处理清空
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
