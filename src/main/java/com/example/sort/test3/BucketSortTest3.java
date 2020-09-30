package com.example.sort.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BucketSortTest3 {

    public static void main(String[] args) {
        BucketSortTest3 test = new BucketSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test(array, 3)));
    }

    /**
     * 桶排序
     * 假设有一个新的数组存放 原数组的数据
     * 每一个新数组元素 可以存放多个元素，都是余数相同元素
     * 然后对每个桶内元素排序，可以选择多种排序方式
     * <p>
     * 例如继续选择桶排序，将桶的容量缩小，一直到桶位为1 ，这样所有桶合并有序
     * <p>
     * 最后将所有桶内数据组合起来
     * <p>
     * 跟计数不同的是，这个桶每个的存放原数组的真实数据
     */
    private int[] test(int[] array, int bucketSize) {
        /**
         * bucketSize 代表每一个桶存放元素的大小，最多放几个元素
         * 桶数组长度需要计算
         */
        if (array == null || array.length < 2 || bucketSize <= 0) {
            // bucketSize 最少为1
            return array;
        }
        /**
         * 和计数不一样，此处只要找到最大值
         */
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        /**
         * 桶的大小忘记怎么计算
         * 应该是按差值的 商值确定index，除数是桶大小
         */
        int bucketLength = (max - min) / bucketSize + 1;
        List<List<Integer>> bucketList = new ArrayList<>(bucketLength);
        //初始化桶内每一个小桶
        for (int i = 0; i < bucketLength; i++) {
            bucketList.add(new ArrayList<>(bucketSize));
        }
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / bucketSize;
            bucketList.get(index).add(array[i]);
        }
        /**
         * [[2,3,1],[4,4,6,5],[8,9,7],[10]]
         * [[2,1],[3]]
         * [[1],[2]]
         */
        //System.out.println(JSON.toJSONString(bucketList));
        //将所有数据装入桶内
        /**
         * 判断桶内数据不为1，就递归桶大小减1，直接连接
         * 否则将桶内所有数据连接，再按照减桶1，继续递归
         */
        //最后存放结果的数组
        List<Integer> result = new ArrayList<>(array.length);
        //错误 1  外层询函，无意义
        // while (bucketSize > 0) {
        //此处最后的 ++ 写错 应该是 bucketIndex++
        //for (int bucketIndex = 0; bucketIndex < bucketLength; bucketLength++) {
        for (int bucketIndex = 0; bucketIndex < bucketLength; bucketIndex++) {
            if (bucketSize == 1) {
                result.addAll(bucketList.get(bucketIndex));
                bucketList.get(bucketIndex).clear();
                //清除元素也可以不需要
            } else {
                //继续将这个小桶数据 递归并且桶大小减1
                int[] tempArray = test(bucketList.get(bucketIndex).stream().mapToInt(Integer::intValue)
                        .toArray(), bucketSize - 1);
                result.addAll(Arrays.stream(tempArray).boxed().collect(Collectors.toList()));
                bucketList.get(bucketIndex).clear();
            }
        }
        //}
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
