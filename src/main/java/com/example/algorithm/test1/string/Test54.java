package com.example.algorithm.test1.string;

/**
 * @author: heshineng
 * @createdBy: 2020/5/27 10:38
 */
public class Test54 {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     *          但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */

    public static void main(String[] args) {
        Test54 test54 = new Test54();
        //System.out.println(test54.isNumber(""));
    }

//    private boolean isNumber(String val) {
//        if (val == null || val.length() == 0) {
//            return false;
//        }
//        char[] charArray = val.toCharArray();
//        if (charArray[0] != '+' && charArray[0] != '-' && ((int) charArray[0] < 48 || (int) charArray[0] > 57)) {
//            return false;
//        }
//        if (charArray.length == 1 && (charArray[0] == '+' && charArray[0] == '-')) {
//            return false;
//        }
//        int pointIndex = -1, eIndex = -1;
//        for (int i = 1; i < charArray.length; i++) {
//            if (((int) charArray[i] >= 48 && (int) charArray[i] <= 57) || charArray[i] == '.'
//                    || charArray[i] == 'E' || charArray[i] == 'e') {
//                if(i==1&&)
//
//            }
//        }
//    }
}
