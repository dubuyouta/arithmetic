package com.example.algorithm.test2.string;

/**
 * @author: heshineng
 * @createdBy: 2020/7/24 11:01
 */
public class Test9 {
    /**
     * 给定两个字符串s1和s2，
     * 请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
     *
     * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。
     * 字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
     * 测试样例：
     * "Hello world","worldhello "
     * 返回：false
     * "waterbottle","erbottlewat"
     * 返回：true
     */

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        System.out.println(test9.checkRotateString("waterbottle","erbottlewat"));
    }

    private boolean checkRotateString(String s1, String s2) {
        if (s1 == null || s2 == null
                || s1.isEmpty() || s2.isEmpty()
                || s1.length() != s2.length()) {
            return false;
        }
        //将s1拼接一次，肯定包含的子串就是可以翻转过来
        String str=s1+s1;
        if(str.contains(s2))
            return true;
        return false;

    }


}
