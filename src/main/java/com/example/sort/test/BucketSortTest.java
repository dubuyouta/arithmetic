package com.example.sort.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSortTest {
    /**
     * 桶排序
     * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定
     * <p>
     * 假设输入数据服从均匀分布，
     * 将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）
     */
    public static void main(String[] args) {
        BucketSortTest test=new BucketSortTest();
        Integer[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        List<Integer> list= Arrays.asList(array);
        System.out.println(JSON.toJSONString(test.bucketSort(list,3)));
    }

    /**
     * 桶排序的过程
     * 1.首先找到数组的最大 max 和 最小 min
     * 2.定义一个桶数组，这个桶数组和计数桶数组不同在于，计数桶存放
     * 原数据出现次数。这个桶记录原始数据，并且可以定义多个BucketSize
     * 让每一个桶元素存放多个数，所以桶的数组长度为 （max-min）/BucketSize+1,
     * <p>
     * 桶数组每个桶存放元素的规则是：原始数-min/BucketSize 差值与桶size的商，一样的放一个
     * 桶内
     * <p>
     * 3.将所有的元素放桶内后，需要先桶内数据先排序
     * 桶内元素进行排序，可以递归使用桶排序或者其他排序。
     * 如果使用递归桶排序，需要注意桶size需要不断变小，一直变到1位置 （此处类似归并排序）
     * <p>
     * 4.把所有桶内的元素拼接完成，赋值给原始数据，让整个数组有序
     *
     * 时间复杂度：最好=O(n+k) 平均=O(n2) 最差=O(n+k)
     * 空间复杂度 O(n+k)
     * 稳定排序
     *
     * @param list           待排序的值
     * @param bucketCapacity 桶容量，每个桶装几个数据
     * @return
     */
    public List<Integer> bucketSort(List<Integer> list, int bucketCapacity) {
        if (list == null || list.size() < 2 || bucketCapacity < 1) {
            return list;
        }
        int min = list.get(0), max = list.get(0);
        //找到最小 和 最大元素
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        //桶数组长度
        int bucketLength = (max - min) / bucketCapacity + 1;
        //定义一个 包含bucketLength 长度的 每一个元素包含一个 int[] 长度bucketCapacity 的一维数组
        //int[][] bucketArray=new int[bucketLength][bucketCapacity];
        List<ArrayList<Integer>> bucketList = new ArrayList<>(bucketLength);
        //初始化桶每一个元素大小
        /**
         * 切记：此处 i只能小于 bucketLength 而不能小于 bucketList.size()
         */
        for(int i=0;i<bucketLength;i++){
            bucketList.add(new ArrayList<>(bucketCapacity));
        }
        for (int i = 0; i < list.size(); i++) {
            // 元素在桶list的位置
            int bucketIndex = (list.get(i) - min) / bucketCapacity;
            bucketList.get(bucketIndex).add(list.get(i));
        }
        //System.out.println(JSON.toJSONString(bucketList));
        List<Integer> resultList=new ArrayList<>();
        for (int i = 0; i < bucketLength; i++) {
            if(bucketCapacity>1){
                //需要将桶容量再缩小 减1
                List<Integer> temp=bucketSort(bucketList.get(i),bucketCapacity-1);
                resultList.addAll(temp);
            }else{
                //桶容量已经为1，直接将桶数据相加即可 桶内元素已经有序
                resultList.addAll(bucketList.get(i));
            }
        }
        return resultList;
    }
}
