package com.example.arithmetic.arithmeticstu.base;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序：是计数排序的升级版（每个数组中是相同元素的出现次数）。桶排序的每个桶中是不同的元素。
 * 1.确定桶的个数
 * 2.确定每个桶的取值范围
 * 3.把数据放入到不同的桶中
 * 4.每个桶进行排序
 * 5.把每个桶的数据按照顺序赋值到原始数组中。
 *
 * @author xiaobao.chen
 * Create at 2020/6/23
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 10, 4};
        int[] a1 = bucketSort(a);
        for (int a2 : a1) {
            System.out.println(a2);
        }
    }

    public static int[] bucketSort(int[] a) {
        //得到最大值和最小值(备注：初始化默认取第一个元素。不要默认是数值0,)
        int max = a[0], min = a[0];
        for (int temp : a) {
            if (max < temp) {
                max = temp;
            }
            if (min > temp) {
                min = temp;
            }
        }
        //计算桶的个数（max-min 要用括号）
        int bucketSize = (max - min) / a.length + 1;

        //初始化桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketSize);
        // i的条件表达式，要使用上面计算出来的桶的大小。
        for (int i = 0; i < bucketSize; i++) {
            bucketArr.add(new ArrayList<>());
        }

        //利用映射函数把数据分配到每个桶中
        for (int i = 0; i < a.length; i++) {
            int index = (a[i] - min) / a.length;
            bucketArr.get(index).add(a[i]);
        }

        //每个桶中的数据进行排序
        for (ArrayList<Integer> list : bucketArr) {
            Collections.sort(list);
        }

        //输出数据
        int[] newa = new int[a.length];
        int j = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            ArrayList<Integer> list = bucketArr.get(i);
            for (int temp : list) {
                newa[j] = temp;
                j++;
            }
        }
        return newa;
    }
}
