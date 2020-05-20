package com.example.arithmetic.arithmeticstu.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaobao.chen
 * Create at 2020/4/28
 */
public class Arithmetic2020042801 {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1, 3, 5, 7, 2, 9}, 9).length);
        System.out.println(twoSum1(new int[]{1, 3, 5, 7, 2, 9}, 9).length);
    }

    /**
     * 空间复杂度：O(1)
     * <p>
     * 时间复杂度：O(n*n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 利用map .通过空间换时间
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int aa = target - nums[i];
            if (numMap.containsKey(aa) && numMap.get(aa) != i) {
                int j = numMap.get(aa);
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("not exists!");
    }
}
