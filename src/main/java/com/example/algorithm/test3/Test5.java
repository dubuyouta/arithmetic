package com.example.algorithm.test3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author heshineng
 * created by 2020/9/17
 */
public class Test5 {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，
     * 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设只有一个重复的整数，找出这个重复的数。
     * 输入:[1,3,4,2,2]
     * 输出: 2
     */
    public static void main(String[] args) {
        Test5 test5 = new Test5();
        int[] array = {1, 3, 4, 5, 6, 4};
        System.out.println(test5.findDuplicate(array));
        System.out.println(test5.findDuplicate1(array));
        System.out.println(test5.findDuplicate2(array));

    }

    private int findDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!set.add(array[i])) {
                return array[i];
            }
        }
        return -1;
    }

    private int findDuplicate1(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.put(array[i], array[i]) != null) {
                return array[i];
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        int n = nums.length - 1;
        int low = 1;
        int high = n;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }


}
