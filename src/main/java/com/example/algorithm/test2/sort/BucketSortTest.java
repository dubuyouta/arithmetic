package com.example.algorithm.test2.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class BucketSortTest {
    /**
     * 桶排序
     * 假设有n个桶，一般让数组的数据对n求余，让
     * 余数相同的数据分在一个桶内
     * 然后遍历所有的桶，对其进行其他方式排序，快排，选择 插入，也可以桶排序
     * 最后将所有桶有序的数据拼接起来
     * 时间 O（n） 最差O（n^2）
     * 空间 o（n+k）
     * 稳定排序
     */
    public static void main(String[] args) {
        BucketSortTest sortTest = new BucketSortTest();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        array = sortTest.bucketSort(array, 4);
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * @param array
     * @param bucketCapacity 每个桶的容量，每个桶最多装多少个
     * @return
     */
    private int[] bucketSort(int[] array, int bucketCapacity) {
        if (array == null || array.length < 2 || bucketCapacity < 1) {
            return array;
        }
        //还是先找到最大和最小的数
        int min = array[0], max = array[0];
        //找到最小 和 最大元素
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        //计算需要多少个桶
        int bucketSize = (max - min) / bucketCapacity + 1;
        List<List<Integer>> bucketList = new ArrayList<>(bucketSize);
        //list 必须初始化
        for (int i = 0; i < bucketSize; i++) {
            bucketList.add(new ArrayList<>(bucketCapacity));
        }
        for (int i = 0; i < array.length; i++) {
            int index = (array[i] - min) / bucketCapacity;
            bucketList.get(index).add(array[i]);
        }
        //再分别对桶内元素排序，继续使用桶排序，桶大小减小，直到桶位1，所有元素都
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            List<Integer> tempList = bucketList.get(i);
            //有元素
            int[] sortArray = bucketSort(tempList.stream().mapToInt(Integer::valueOf).toArray(), bucketCapacity - 1);
            result.addAll(Arrays.stream(sortArray).boxed().collect(Collectors.toList()));
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }


}
