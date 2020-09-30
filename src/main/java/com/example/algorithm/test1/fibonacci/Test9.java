package com.example.algorithm.test1.fibonacci;

/**
 * @author: heshineng
 * @createdBy: 2019/11/19 18:14
 */
public class Test9 {
    /**
     * 题目描述
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * test8 中跳台阶的升级版
     *
     * 按test8 中分析结果 最后 到达n  有n种可能 分别 跳 1...n
     * 则 f(n)=f(n-1)+f(n-2)+...+f(1)+f(0)
     *    f(n-1)=     f(n-2)+...+f(1)+f(0)
     *
     *   公式2带入公式1  f(n)=f(n-1)+f(n-1)=2*f(n-1) n>=3
     * 其中f(0) 代表从最初还未跳的平台开始 直接跳n步 只有一种可能
     * 所以 f(0)=1 并且 f(0) 必须从 n>3 开始算
     *
     * f(1)=1  f(2)=2
     */

    public static void main(String[] args) {
        Test9 test=new Test9();
        System.out.println(test.jumpFloorII(10));
        System.out.println(test.jumpFloorII2(10));
    }

    //即每一次 n计算，依赖前n此结果，所以需要一个容器存储前n-1此结果
    public int jumpFloorII(int target) {
        if(target==0){
            return 0;
        }
        if(target<3){
            return target;
        }
        /**
         * 通项公式 f(n)=2*f(n-1) n>=3
         */
        int pre=2;
        for(int i=3;i<=target;i++){
            pre=pre*2;
        }
        /**
         * 改进算法
         * 右移代替2倍扩大
         * 一共扩大倍数 target-3 +1 =nums
         * 则 结果 2 << nums
         */
        return pre;
    }

    public int jumpFloorII2(int target) {
        if(target==0){
            return 0;
        }
        if(target<3){
            return target;
        }
        /**
         * 通项公式 f(n)=2*f(n-1) n>=3
         */
        int nums=target-3 +1;
        return 2 << nums;
    }
}
