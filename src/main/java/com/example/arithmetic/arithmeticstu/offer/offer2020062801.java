package com.example.arithmetic.arithmeticstu.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @author xiaobao.chen
 * Create at 2020/6/28
 */
public class offer2020062801 {

    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = countMap.get(nums[i]);
            if (integer == null) {
                countMap.put(nums[i], 1);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
