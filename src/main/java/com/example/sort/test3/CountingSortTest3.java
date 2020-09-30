package com.example.sort.test3;

import java.util.Arrays;

public class CountingSortTest3 {

    public static void main(String[] args) {
        CountingSortTest3 test = new CountingSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test(array)));
    }

    private int[] test(int[] array) {
        /**
         * 计数 就是计数每个数据出现的次数，并且利用新数组的下标 和差值计算数组原值
         * 要求 必须 是 n~m 的正整数 首先要找到最大最小的数
         * 再统计差值
         */
        if (array == null || array.length < 2) {
            return array;
        }
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        //差值，决定新数组的长度
        int[] countArray = new int[max - min + 1];
        //给数组每一个值赋值0值
        Arrays.fill(countArray, 0);
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            countArray[index]++;
        }
        /**
         * 这一部分 又出现了错误
         */
        //countArray每一个数统计好，并且已经排好序，只需要依次赋值到原数组就可以
        for (int i = 0, countIndex = 0; i < array.length && countIndex < countArray.length; ) {
            if (countArray[countIndex] > 0) {
                //[1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10]
                //此处写错了，没有想清楚 是利用index 和差值找打原数
                //array[i] = countArray[countIndex] + min;
                array[i] = countIndex + min;
                countArray[countIndex]--;
                i++;
            } else {
                countIndex++;
            }
        }
        return array;
    }
}
