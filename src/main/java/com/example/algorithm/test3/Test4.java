package com.example.algorithm.test3;

/**
 * @author heshineng
 * created by 2020/9/17
 */
public class Test4 {
    /**
     * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
     *
     * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
     * 请你计算最多能喝到多少瓶酒。
     * 输入：numBottles = 9, numExchange = 3
     * 输出：13
     * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
     * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
     */
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(test4.numWaterBottles(15, 4));
        System.out.println(test4.numWaterBottles1(15, 4));

    }

    private int numWaterBottles(int numBottles, int numExchange) {
        return (numBottles * numExchange - 1) / (numExchange - 1);
    }

    private int numWaterBottles1(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles >= numExchange) {
            int change=numBottles/numExchange;
            total+=change;
            numBottles=numBottles%numExchange+change;
        }
        return total;
    }
}
