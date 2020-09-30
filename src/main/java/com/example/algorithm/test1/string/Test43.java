package com.example.algorithm.test1.string;

/**
 * @author: heshineng
 * @createdBy: 2020/5/18 16:09
 */
public class Test43 {
    /**
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
     *
     * 循环左移，就是将字符串的 前3位移动到字符串末尾
     */

    public static void main(String[] args) {
        Test43 test43 = new Test43();
        String k="abcfd112455oo0011nnmm";
        System.out.println(test43.leftRotateString(k,5));
    }

    public String leftRotateString(String str, int n) {
        if (str == null || n > str.length()) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }

}
