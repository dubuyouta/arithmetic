package com.example.algorithm.test1.fibonacci;

public class Test7 {
    /**
     * 题目：
     * 大家都知道斐波那契数列，现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39 从0开始的斐波那契数列
     * <p>
     * 斐波那契数列 的特性 是每一项 等于前2项之和，如：
     * 1  2  3  5  8  13
     * <p>
     * 3=2+1  5=3+2 8=3+5
     * <p>
     * 通项公式为 an= a(n-1)+a(n-2)  n>3
     *
     * 以下为标准
     * 斐波那契数列的标准公式为：F(0)=0, F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
     * 当f(0) 不存在是 从n>=3 开始
     * 当f(0)  存在  从n>=2 开始
     *
     * 但在具体的问题中，f(0)不存在  并且 f(1)!=1 f(2)!=1  就是最初的初始值可能并非都一样
     *   要看具体问题中的初始值是多少，需要分析
     */

    public static void main(String[] args) {
        Test7 test = new Test7();
        System.out.println(test.fibonacci3(10));
        System.out.println(test.fibonacci4(55));

    }

    public int fibonacci(int n) {
//        if(n==0){
//            return 0;
//        }
//        if(n==1){
//            return 1;
//        }
        /**
         * 优化处
         */
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacci2(int n) {
        /**
         * 优化处性能，递归可能出现问题，n是每次需要利用前2个值， n-1 和 n-2
         * 所以每次暂存这2个值就可以了
         */
        if (n < 2) {
            return n;
        }
        int one = 0;
        int tow = 1;
        for (int i = 2; i <= n; i++) {
            int sum = one + tow;
            one = tow;
            tow = sum;
        }
        return tow;
    }

    public int fibonacci3(int n) {
        /**
         * 继续优化，只需要一个值
         */
        if (n < 2) {
            return n;
        }
        int pre = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            current = pre + current;
            pre = current - pre;
        }
        return current;
    }

    /**
     * 进化一下，判断一个一个数为斐波那契数列 中的某一项，an，给出n是第几项
     * n从0 开始 f(0)=0 f(1)=1 f(n)=f(n-1)+f(n-2) N>=3
     */
    public int fibonacci4(int an) {
        if (an < 2) {
            return an;
        }
        int pre = 0;
        int current = 1;
        int n = 2;
        for (; ; ) {
            if ((current = pre + current) == an) {
                break;
            }
            pre = current - pre;
            n++;
        }
        return n;
    }

    int FibonacciTailRecursive(int n, int ret1, int ret2) {
        if (n == 0)
            return ret1;
        return FibonacciTailRecursive(n - 1, ret2, ret1 + ret2);
    }
}
