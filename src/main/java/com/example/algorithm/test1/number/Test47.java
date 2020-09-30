package com.example.algorithm.test1.number;

/**
 * @author: heshineng
 * @createdBy: 2020/5/20 17:20
 */
public class Test47 {
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、
     * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     */

    public static void main(String[] args) {
        Test47 test47 = new Test47();
        System.out.println(test47.sumTotal(15));
    }

    /**
     * 这个等差数列为 1的 求和 公式为： S(n)=（n+1）*n/2
     * 但要求不能使用乘除法
     * 可以使用加法
     * @param n
     * @return
     */
    private int sumTotal(int n) {
        int s = n;
        //使用短路求和判断，先判断前面，前面为真，才执行后面
        boolean flag = s > 0 && ((s += sumTotal(n - 1)) > 0);
        return s;
    }

    private int sumTotal1(int n) {
        int sum = (int) Math.pow(n, 2) + n;
        return sum >> 1;
    }
}
