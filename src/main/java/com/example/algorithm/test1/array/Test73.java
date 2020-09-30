package com.example.algorithm.test1.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heshineng
 * created by 2020/9/11
 */
public class Test73 {

    /**
     * 在一个乱序的数组中，找到一组数的和为10 的2个数的下标 （双向指针 towsum）
     */

    public static void main(String[] args) {
        Test73 test73 = new Test73();
        int[] array = {3, 9, 6, 14, 7, 4, 8, 5, 1};
        System.out.println(Arrays.toString(test73.towSum1(array,10)));
        System.out.println(Arrays.toString(test73.towSum2(array,10)));
    }

    /**
     * 使用map实现
     * @param array
     * @param target
     * @return
     */
    private int[] towSum1(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                return new int[]{map.get(target - array[i]), i};
            }
            map.put(array[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 先排序，再用双指针法
     * @param array
     * @param target
     * @return
     */
    private int[] towSum2(int[] array, int target) {
        if (array == null || array.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                return new int[]{map.get(array[left]), map.get(array[right])};
            } else if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
