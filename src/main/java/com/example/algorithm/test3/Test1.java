package com.example.algorithm.test3;

/**
 * @author heshineng
 * created by 2020/9/4
 */
public class Test1 {
    /**
     * 最大连续子序列的和  求最长子序列和。给定一个至少包含一个数字的数组，查找最长子序列和
     * 输入描述：输入两个字符串，分两行输入。
     * 输出描述：输出一个整数。
     *
     * 给定的是数组[−2, 1, −3, 4, −1, 2, 1, −5, 4]，
     *
     * 最大连续子序列是[4, -1, 2, 1]，
     * 最长子序列和是6。
     */

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(test1.maxSubSum1(array));
        System.out.println(Integer.MAX_VALUE);
    }

    private int maxSubSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int maxSum = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            //先获取局部最优解，再更新全局最优解
            currentSum = Math.max(currentSum + array[i], array[i]);
            //每次更新全局最优解
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    private int maxSubSum1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int maxSum = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            //先获取局部最优解，再更新全局最优解
            currentSum = currentSum < 0 ? array[i] : currentSum + array[i];
            //每次更新全局最优解
            maxSum = currentSum > maxSum ? currentSum : maxSum;
        }
        return maxSum;
    }
}
