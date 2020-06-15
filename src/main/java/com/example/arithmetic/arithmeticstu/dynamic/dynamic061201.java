package com.example.arithmetic.arithmeticstu.dynamic;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author xiaobao.chen
 * Create at 2020-06-13
 */
public class dynamic061201 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        System.out.println(climbStairs1(4));
    }

    /**
     * 递归深度耗时太长。
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 通过外部存储-数组来玩玩。
     *
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
