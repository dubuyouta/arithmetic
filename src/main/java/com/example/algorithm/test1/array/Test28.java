package com.example.algorithm.test1.array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @author: heshineng
 * @createdBy: 2019/11/26 0:44
 */
public class Test28 {
    /**
     * 题目：
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */

    public static void main(String[] args) {
        Test28 test = new Test28();
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(JSON.toJSONString(test.getLeastNumbers2(array, 4)));
    }

    /**
     * 使用快速排序 和 小顶堆排序
     *
     * 也可用选择
     *
     * 快速排序
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers1(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || input.length == 0 || k < 0 || k > input.length) {
            return arrayList;
        }
        int length = input.length;
        int left = 0, right = length - 1;
        quickSort(input, left, right);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    private void quickSort(int[] array, int start, int end) {
        if (array == null || array.length < 2 || start >= end) {
            return;
        }
        int left = start, right = end;
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                //右边数，比左边大 继续向左找，直到左面有没有这个比较大的数
                right--;
            }
            //退出循环，此时right 从 右-> 左 第一个比 temp小的数
            //所以此次 left起点就是这个数，找到 最接近 temp 并且比它大的第一个数退出
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        quickSort(array, start, left - 1);
        quickSort(array, left + 1, end);
    }

    /**
     * 构造小顶堆
     * 堆排序 写的还是不熟
     */
    public ArrayList<Integer> getLeastNumbers2(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || input.length == 0 || k < 0 || k > input.length) {
            return arrayList;
        }
        for (int i = input.length - 1; i > input.length - 1 - k; i--) {
            //构建小顶堆，与最后一个进行交换
            for (int j = (i - 1) / 2; j >= 0; j--) {
                int leftIndex = 2 * j;
                int rightIndex = 2 * j + 1 < i ? 2 * j + 1 : 2 * j;
                int minIndex = input[leftIndex] <= input[rightIndex] ? leftIndex : rightIndex;
                if (input[j] > input[minIndex]) {
                    //交换
                    int temp = input[j];
                    input[j] = input[minIndex];
                    input[minIndex] = temp;
                }
            }
            if (input[0] < input[i]) {
                int temp = input[0];
                input[0] = input[i];
                input[i] = temp;
            }
            arrayList.add(input[i]);
        }
        return arrayList;
    }
}
