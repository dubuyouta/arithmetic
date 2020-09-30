package com.example.algorithm.test1.number;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/5/18 15:28
 */
public class Test42 {

    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 对应每个测试案例，输出两个数，小的先输出。
     *
     * 2个数差值越大，乘积越小，所以使用2个指针头尾找，找到就取到值
     * @param args
     */

    public static void main(String[] args) {
        Test42 test42 = new Test42();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        System.out.println(JSON.toJSONString(test42.searchNums(array, 10)));
    }

    private List<Integer> searchNums(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        if (array[0] * 2 > sum) {
            return null;
        }
        if (array[array.length - 1] * 2 < sum) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            }else if(array[left]+array[right]>sum){
                right--;
            }else{
                left++;
            }
        }
        return list;

    }

    private List<Integer> searchNums1(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        if (array[0] * 2 > sum) {
            return null;
        }
        if (array[array.length - 1] * 2 < sum) {
            return null;
        }
        /**
         * 使用循环方法
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] + array[j] == sum) {
                    if (list.isEmpty()) {
                        list.add(array[i]);
                        list.add(array[j]);
                    } else {
                        if (array[i] * array[j] < list.get(0) * list.get(1)) {
                            list.clear();
                            list.add(array[i]);
                            list.add(array[j]);
                        }
                    }
                    break;
                } else if (array[i] + array[j] > sum) {
                    break;
                }
            }
        }
        return list;
    }
}
