package com.example.algorithm.test1.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/5/21 14:16
 */
public class Test49 {
    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     *
     * 输入一个字符串,包括数字字母符号,可以为空
     * 如果是合法的数值表达则返回该数字，否则返回0
     * 如：输入  +2147483647   1a33
     *     输出  2147483647     0
     */

    public static void main(String[] args) {
        Test49 test49 = new Test49();
        System.out.println(test49.covertNumber("+23.4b8"));
    }

    private Number covertNumber(String val) {
        if (val == null || val.length() == 0) {
            return 0;
        }
        char[] charArray = val.toCharArray();
        if (charArray[0] != '+' && charArray[0] != '-' && ((int) charArray[0] < 48 || (int) charArray[0] > 57)) {
            return 0;
        }
        List<Integer> intList = new ArrayList<>();
        List<Integer> pointList = new ArrayList<>();
        boolean addPoint = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '.') {
                addPoint = true;
                continue;
            }
            if ((int) charArray[i] >= 48 && (int) charArray[i] <= 57) {
                int num = charArray[i] - '0';
                if (!addPoint) {
                    intList.add(num);
                } else {
                    pointList.add(num);
                }
            } else {
                return 0;
            }
        }
        int intStartNum = 1;
        int sum = 0;
        //整数部分计算完毕
        for (int i = intList.size() - 1; i >= 0; i--) {
            sum += intList.get(i) * intStartNum;
            intStartNum *= 10;
        }
        if (pointList.size() > 0) {
            //小数部分
            float sumFloat = 0.0f;
            float pointStartNum = 10f;
            for (int i = 0; i < pointList.size(); i++) {
                sumFloat += pointList.get(i) / pointStartNum;
                pointStartNum *= 10;
            }
            sumFloat += sum;
            if (charArray[0] == '-') {
                sumFloat = 0 - sumFloat;
            }
            return sumFloat;
        }

        if (charArray[0] == '-') {
            return 0 - sum;
        }
        return sum;
    }
}
