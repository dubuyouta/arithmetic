package com.example.algorithm.test2.sort;

import java.util.Arrays;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class CountingSortTest {
    /**
     * 计数，判断每一个元素出现的次数，需要使用一个额外的数组存放元素
     * 而且也要求，数组有取值范围
     * 时间复杂度 O(n) 空间复杂度：O(m-l) 近似O（n）
     * 稳定排序
     */
    public static void main(String[] args) {
        CountingSortTest sortTest = new CountingSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array = sortTest.countSort(array);
        System.out.println(Arrays.toString(array));
    }

    private int[] countSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        //找到最大或最小的数，好确定借用空间范围
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] countArray = new int[max - min + 1];
        //Arrays.fill(countArray,0); 不需要填充也可
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        int[] result = new int[array.length];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] > 0) {
                for (int j = 0; j < countArray[i]; j++) {
                    result[index++] = i + min;
                }
            }
        }
        return result;
    }
}
