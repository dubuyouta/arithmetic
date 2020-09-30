package com.example.algorithm.test3;

/**
 * @author heshineng
 * created by 2020/9/9
 */
public class MaxSumTest {
    /**
     * 找到一个数组中最大子序列的和
     * 用局部最大值，去遍历全局最大值的想法
     */
    public static void main(String[] args) {
        MaxSumTest maxSumTest = new MaxSumTest();
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumTest.maxSubSum(array));
    }

    private int maxSubSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length < 2) {
            return array[0];
        }
        int maxSum = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            //前一次结果小于0，说明有负值了
            currentSum = currentSum < 0 ? array[i] : array[i] + currentSum;
            maxSum = currentSum > maxSum ? currentSum : maxSum;
        }
        return maxSum;
    }

}
