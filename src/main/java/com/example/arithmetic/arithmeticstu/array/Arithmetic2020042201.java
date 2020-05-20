package com.example.arithmetic.arithmeticstu.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaobao.chen
 * Create at 2020/4/22
 */
public class Arithmetic2020042201 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 1, 5, 1, 5, 5, 5, 2, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        int numResult = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.get(num);
            if (count == null || count == 0) {
                countMap.put(num, 1);
                continue;
            }
            numResult = num;
            break;
        }
        return numResult;
    }
}
