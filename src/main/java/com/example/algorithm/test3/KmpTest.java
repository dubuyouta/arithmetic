package com.example.algorithm.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author heshineng
 * created by 2020/9/8
 */
public class KmpTest {
    /**
     * 检查一个字符串是否包含另一个字符串
     * 使用kmp的算法：
     *
     * 优化的是 子串的重复度，通过子串的重复度，对之前已比较的结果
     * 进行利用，得到原串继续遍历的位置
     *
     * 总之就是利用已执行的结果
     * 如子串：  a  b  c  e  d  a  b  c  a  b  c  e  d  a  b  c
     *          0  0  0  0  0   1  2  3  1 2  3  4   5  6  7  8
     *
     *          计算子串的重复度的方法，先查看前一个下标的重复度是否可以继承
     *          不可以往前找可以继承的重复加1，否则没有重复度就是0
     */

    public static void main(String[] args) {
        KmpTest test = new KmpTest();
        System.out.println(Arrays.toString(test.getNextArray("abcedabcabcedabc")));
        System.out.println(test.indexOf("asasawaskasasctm", "asasc"));

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(list);
        int[] array=list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int indexOf(String val, String subVal) {
        if (val == null || subVal == null || val.length() < subVal.length()) {
            return -1;
        }
        int valIndex = 0, subValIndex = 0;
        int valLength = val.length(), subValLength = subVal.length();
        char[] valChar = val.toCharArray();
        char[] subValChar = subVal.toCharArray();
        int[] next = getNextArray(subVal);
        while (valIndex < valLength && subValIndex < subValLength) {
            if (valChar[valIndex] == subValChar[subValIndex]) {
                valIndex++;
                subValIndex++;
            } else {
                if (subValIndex == 0) {
                    valIndex++;
                } else {
                    //之间子串已经有几个匹配了，subValIndex等于前一个字符的重复度开始继续比较
                    subValIndex = next[subValIndex - 1];
                }
            }
        }
        // 匹配成功,则返回模式字符串在原字符串中首次出现的位置;否则返回-1
        if (subValIndex == subValLength) {
            return valIndex - subValIndex;
        }
        return -1;
    }

    private int[] getNextArray(String val) {
        if (val == null || val.length() == 0) {
            return null;
        }
        int length = val.length();
        int[] nextArray = new int[length];
        char[] valArray = val.toCharArray();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                nextArray[i] = 0;
                continue;
            }
            //先查看前一个元素是否可以继承下标
            int preRepeat = nextArray[i - 1];
            while (preRepeat != 0 && valArray[i] != valArray[preRepeat]) {
                //不能继承，继续往前站能继承的数据
                /**
                 * 如果前一个重复度是4，而且当前下标的元素与前一个元素不同，
                 * 则需要跳过前面4个元素
                 */
                preRepeat = nextArray[preRepeat - 1];
            }

            if (valArray[i] == valArray[preRepeat]) {
                nextArray[i] = preRepeat + 1;
            } else {
                nextArray[i] = 0;
            }

        }

        return nextArray;

    }
}
