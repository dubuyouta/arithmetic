package com.example.algorithm.test2.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 13:17
 */
public class Test6 {
    /**
     * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
     * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
     *
     * 给定一个string iniString为待压缩的串(长度小于等于10000)，
     * 保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串
     *
     * 测试样例
     * "aabcccccaaa"
     * 返回："a2b1c5a3"
     * "welcometonowcoderrrrr"
     * 返回："welcometonowcoderrrrr"
     *
     */
    public static void main(String[] args) {
        Test6 test6 = new Test6();
        System.out.println();
        int number = 19;
        char cNumber = (char) (number + '0');
        System.out.println("Number " + number + " to char is:" + cNumber);

        System.out.println(Arrays.toString(test6.covertIntArray(13)));

        System.out.println();

        System.out.println(test6.compressString1("aabcccccaaa"));
        System.out.println(test6.compressString1("welcometonowcoderrrrr"));
        System.out.println(test6.compressString1("sskreewqqqqqqqqqqqqqeghjk"));


    }

    private String compressString(String val) {
        if (val == null || val.isEmpty()) {
            return val;
        }
        char[] charArray = val.toCharArray();
        char[] tempArray = new char[charArray.length];
        int slow = 0, fast = 1, tempIndex = 0;
        for (; slow < charArray.length && fast <= charArray.length && tempIndex < charArray.length; ) {
            if (fast < charArray.length && charArray[slow] == charArray[fast]) {
                fast++;
            } else {
                tempArray[tempIndex++] = charArray[slow];
                int[] numIndex = covertIntArray(fast - slow);
                for (int i = 0; i < numIndex.length && tempIndex < charArray.length; i++) {
                    tempArray[tempIndex++] = (char) (numIndex[i] + '0');
                }
                //别忘记增加slow 和 fast
                slow = fast;
                fast++;
            }

        }
        if (fast >= charArray.length) {
            return new String(tempArray);
        }
        return val;
    }

    private String compressString1(String val) {
        if (val == null || val.isEmpty()) {
            return val;
        }
        if (val.length() == 1) {
            return val;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char pre = val.charAt(0);
        for (int i = 1; i <= val.length(); i++) {
            if (i < val.length() && val.charAt(i) == pre) {
                count++;
            } else {
                stringBuilder.append(pre);
                stringBuilder.append(count);
                if(i<val.length()) {
                    count = 1;
                    pre = val.charAt(i);
                }
            }
            if(stringBuilder.length()>=val.length()){
                break;
            }
        }
        return stringBuilder.length()>=val.length()?val:stringBuilder.toString();
    }

    //数位分离
    private int[] covertIntArray(int num) {
        List<Integer> list = new ArrayList<>();
        int div = 10;
        while (num > 0) {
            list.add(new Integer(num % div));
            num /= 10;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }


}
