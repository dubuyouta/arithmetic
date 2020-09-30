package com.example.sort.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class CountingSortTest {
    /**
     * 计数排序
     * 计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
     * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
     * <p>
     * 计数排序(Counting sort)是一种稳定的排序算法。计数排序使用一个额外的数组C，
     * 其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。它只能对整数进行排序。
     */

    public static void main(String[] args) {
        CountingSortTest test=new CountingSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(test.countingSort(array)));
    }

    /**
     * 首先第一步找到 最大 最小的数据
     *
     * 第二步 使用max-min+1，最为新的数组的size，
     * 存原数组中每一个元素出现的次数，这个次数的下标索引
     * 为 原数据-min=index
     * （因为找到最大最小后，就可以确定原数组范围 min~max --计数排序的要求，
     *   所以元素组最多有 max-min+1种不同的数，故新数组size=max-min+1）
     *
     *  第三步，将桶数组的值，重新赋值到原数组中，遍历桶数组，
     *  原数组数值=min+index （因为桶index是 利用原数值和min的相对位置算出的）
     *
     *  时间复杂度 最好= O(n+k)   平均=O(n+k) 最差=O(n+k)
     *  空间复杂度 O(k)
     *
     *  稳定排序
     *
     * @param array
     * @return
     */
    public int[] countingSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int min = array[0], max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        //申请的额外空间，max-min+1
        /**
         * 因为输入返回值已确定的整数，所以原数组的值
         * 必定在min~max，
         * 这个额外空间存放每一个元素出现的个数
         */
        int[] bucket = new int[max - min + 1];
        //给bucket 数组元素初始化，都初始化为0，便于后面开始计数自加
        Arrays.fill(bucket, 0);
        /**
         * 原数组元素，出现次数存放新bucket 数组的位置计算
         * 数值-min，就是存放的下标值，这样就是数组有序了
         * 如 值=3，最小值为1， 存放位置 3-1=2
         *
         * 相当于计算 原始值与最小值得相对位置，就是下标值
         */
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            //此元素出现次数加1
            bucket[index]++;
        }
        /**
         * 再将桶数组的值，重新放在 原数组中，
         * 原数组的值= 桶数组下标+min
         *
         * 桶中放一个元素到原数组，就数值减-1，减到0就代表这个数值放完了
         */
//        int index = 0, bucketIndex = 0;
//        while (index < array.length) {
//            if (bucket[bucketIndex] != 0) {
//                array[index] = bucketIndex + min;
//                bucket[bucketIndex]--;
//                index++;
//            } else {
//                bucketIndex++;
//            }
//        }
        /**
         * 改造第3不更好理解
         */
        int index=0;
        for(int bucketIndex=0;bucketIndex<bucket.length&&index<array.length;bucketIndex++){
            while (bucket[bucketIndex]!=0){
                array[index]=bucketIndex+min;
                bucket[bucketIndex]--;
                index++;
            }

        }
        return array;
    }
}
