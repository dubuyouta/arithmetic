package com.example.algorithm.test1.fibonacci;

/**
 * @author: heshineng
 * @createdBy: 2019/11/19 23:18
 */
public class Test10 {
    /**
     * 题目描述
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * <p>
     * 分析:
     * 2*1 的图
     * 1---1
     * 1---1
     * 1---1
     * <p>
     * <p>
     * 2*6           1---1---1---1---1---1---1
     *               1---1---1---1---1---1---1
     *               1---1---1---1---1---1---1
     * <p>
     * 就是上面的图可以横着 或 竖着 放，铺满下面 2*6 的格子
     * <p>
     * 假设最后一块 是竖着铺的，则在上面 2*6 最右的格子上 竖着铺，
     * 除了最后一块数的铺，前面的空余为 2*5 而最后一块 只有一种可能性 所以 f(5)*1
     * <p>
     * 假设最后一块横着铺最少要留2个横向的格子 所以前面空余为 2*4 也只有一种可能性，2块横着的板子
     * 所以 f(4)*1
     * <p>
     * 最后一块只能横着铺 或竖着铺 2种可能性，所以
     * 要到达f(6)=f（5）+f（4）
     * 则f(n)=f(n-1)+f(n-2)
     * <p>
     * 又见斐波那契数列
     */

    public static void main(String[] args) {
        Test10 test = new Test10();
        System.out.println(test.rectCover(7));
    }

    //f(n)=f(n-1)+f(n-2) f(0)=0 f(1)=1 f(2)=1
    public int rectCover(int target) {
        if (target < 3) {
            return target;
        }
        int pre = 1;// 长度为1 只有一种竖排
        int current = 2; //长度为2 有2种 全竖着 全横着
        for (int i = 3; i <= target; i++) {
            current = current + pre;
            pre = current - pre;
        }
        return current;
    }
}
