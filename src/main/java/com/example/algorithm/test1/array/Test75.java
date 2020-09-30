package com.example.algorithm.test1.array;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author heshineng
 * created by 2020/9/18
 */
public class Test75 {
    /**
     * 2020-09-18 头条面试的算法
     *
     * 给定一个整数序列：a1, a2, ..., an，一个「132模式」的子序列 ai, aj, ak
     * 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，
     * 当给定有 n 个数字的序列时，验证这个序列中是否含有「132模式」的子序列。
     *
     * 输入：整型数组，代表一个整数序列
     * 输出：布尔值，代表输入的序列中是否包含「132」模式的子序列
     *
     * 注： i < j < k 的下标不需要连续，满足条件即可
     *
     * 示例1:
     * 输入: [1, 2, 3, 4]
     * 输出: False
     * 解释: 序列中不存在132模式的子序列。
     *
     * 示例 2:
     * 输入: [3, 1, 4, 2]
     * 输出: True
     * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
     *
     * 示例 3:
     * 输入: [-1, 3, 2, 0]
     * 输出: True
     * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0]
     *
     */

    public static void main(String[] args) {
        Test75 test75 = new Test75();
        //int[] array = {1, 5, 2, 7, 9, 2, 4, 3, 1};
                      // 0  1  2  3  4  5  6  7  8
        int[] array={-1, 3, 2, 0};
        System.out.println(test75.hasSubModel2(array));
        System.out.println(JSON.toJSONString(test75.hasSubModel3(array)));
    }

    //暴力破解
    private boolean hasSubModel(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (array[k] > array[i] && array[k] < array[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 1,5,2,7,9,2,4,3,1
     *
     * 想转换成下标问题，也不行
     * @param array
     * @return
     */
    private boolean hasSubModel1(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.get(array[i]).add(i);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(array[i], set);
            }
        }
        int[] tempArray = map.keySet().stream().sorted().mapToInt(Integer::valueOf).toArray();
        if (tempArray.length < 3) {
            return false;
        }
        for (int i = 0; i < tempArray.length - 2; i++) {

        }
        return false;
    }

    /**
     * size=5
     * 0-4 34  5-2
     * 0 1 2 3 4
     * @param array
     * @return
     */
    private boolean hasSubModel2(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        int start = 0;
        for (; start < array.length - 2; start++) {
            int end = array.length - 1;
            int mid = end - 1;
            while (mid < end && mid > start) {
                if (array[end] > array[start]) {
                    if (array[mid] > array[end]) {
                        return true;
                    } else {
                        mid--;
                    }
                } else {
                    end--;
                    mid--;
                }
            }
        }
        return false;
    }

    /**
     * 找出所有满足要求的结果，需要调整
     * @param array
     * @return
     */
    private List<List<Integer>> hasSubModel3(int[] array) {
        if (array == null || array.length < 3) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        int start = 0;
        for (; start < array.length - 2; start++) {
            int end = array.length - 1;
            int mid = end - 1;
            //此处只判断end>start+1
            while (end > start + 1) {
                if (array[end] > array[start]) {
                    if (mid > start) {
                        if (array[mid] > array[end]) {
                            List<Integer> subList = new ArrayList<>();
                            subList.add(start);
                            subList.add(mid);
                            subList.add(end);
                            list.add(subList);
                        }
                        mid--;
                    }else{
                        //重置
                        end=end-1;
                        mid=end-1;
                    }
                } else {
                    end--;
                    mid=end-1;
                }

            }
        }
        return list;
    }


}
