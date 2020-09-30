package com.example.algorithm.test1.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: heshineng
 * @createdBy: 2020/5/26 16:40
 */
public class Test53 {
    /**
     * 返回一个字符串最长连续子串
     */

    public static void main(String[] args) {
        Test53 test53 = new Test53();
        System.out.println(test53.lengthOfLongestNoRepeat("abca123452sopeadoq"));
        System.out.println(test53.lengthOfLongestSubstring("abca123452sopeadoq"));
        System.out.println(test53.lengthOfLongestNoRepeat("abcdef"));
        System.out.println(test53.lengthOfLongestSubstring("abcdef"));
    }

    private  String lengthOfLongestNoRepeat(String str) {
        //初始化最大不连续
        int maxLength = 0;
        //定义窗口起始下标
        int startIndex = 0;
        String result="";
        //定义一个集合: 保存字符当前下标<字符,字符的下标>
        Map<Character, Integer> map = new HashMap<>();
        for (int endIndex = 0; endIndex < str.length(); endIndex++) {
            char c = str.charAt(endIndex);
            if (map.containsKey(c)) {
                //获取上次该字符出现的下标,作为窗口的起始位置(因为要求不重复)
                //startIndex = map.get(c);
                startIndex=Math.max(startIndex,map.get(c));
            }
            //获取窗口的宽度
            int length = endIndex - startIndex + 1;
            if (length >= maxLength) {
                maxLength = length;
                result = new String(str.toCharArray(), startIndex, length);
            }
            //记录字符本次的下标
            map.put(c, endIndex + 1);
        }
        return result;
    }

    private String getMaxLengthSubString1(String val) {
        if (val == null || val.length() == 0) {
            return val;
        }
        char[] valCharArray = val.toCharArray();
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        int prePoint = 0;
        map.put(valCharArray[prePoint], prePoint);
        //优化的位置，记录之前不重复字符的下标，这样下次循环可以从这个小标开始算
        for (int lastPoint = 1; lastPoint < valCharArray.length; lastPoint++) {
            if (val.length() - prePoint < result.length()) {
                break;
            }
            if (map.containsKey(valCharArray[lastPoint])) {
                int newLength = (lastPoint - 1) - prePoint + 1;
                if (newLength > result.length()) {
                    result = new String(valCharArray, prePoint, newLength);
                }
                prePoint = Math.max(prePoint,map.get(valCharArray[lastPoint])+1);
            }
            map.put(valCharArray[lastPoint], lastPoint);
        }
        if(map.keySet().size()==valCharArray.length){
            result=val;
        }
        return result;
    }


    private String getMaxLengthSubString(String val) {
        if (val == null || val.length() == 0) {
            return val;
        }
        char[] valCharArray = val.toCharArray();
        String result = "";
        //需要记录上一个重复的下标
        List<Character> charList = new ArrayList<>();
        for (int prePoint = 0; prePoint < valCharArray.length - 1; prePoint++) {
            charList.add(valCharArray[prePoint]);
            int lastPoint = prePoint + 1;
            while (lastPoint < valCharArray.length) {
                /**
                 * 此处有个问题，全都未重复子串，没有考虑
                 * 应该考虑上前一个指针
                 */
                if (charList.contains(valCharArray[lastPoint])) {
                    int newLength = (lastPoint - 1) - prePoint + 1;
                    if (newLength > result.length()) {
                        result = new String(valCharArray, prePoint, newLength);
                    }
                    charList.clear();
                    break;
                }
                charList.add(valCharArray[lastPoint]);
                lastPoint++;
            }
            /**
             * 下面为一段全部不重复的代码
             */
            if (charList.size() == valCharArray.length) {
                result = val;
                break;
            }
        }
        return result;
    }

    public String lengthOfLongestSubstring(String s) {
        int n = s.length();
        String result = "";
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        int i = 0;
        int j = 0;
        for (; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            if (s.length() - i < result.length()) {
                break;
            }
            int newLength = j - i + 1;
            if (newLength > result.length()) {
                result = new String(s.toCharArray(), i, newLength);
            }
            //ans = Math.max(result.length(), j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        //System.out.println("i:"+i+" j:"+j);
        return result;
    }
}
