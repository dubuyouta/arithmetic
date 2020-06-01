package com.example.arithmetic.arithmeticstu.classic;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author xiaobao.chen
 * Create at 2020-06-01
 */
public class LongestPalindRome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("fdgcabahcdg"));
        System.out.println(longestPalindRomeCenter("fdgcabahcdg"));
    }

    /**
     * 1.暴力解法
     * 依次找到每个位置的回文串。保留最长的那个回文串的起始位置和长度，然后再进行截取
     * <p>
     * <p>
     * 时间复杂度 o(n3)
     * 空间复杂度 o(1
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        System.out.println(System.currentTimeMillis());
        if (s.length() < 2) {
            return s;
        }

        int begin = 0;//默认的开始位置
        int maxLen = 1;//回文串最长的长度。

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLen && validPalindRome(s, i, j)) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        System.out.println(System.currentTimeMillis());

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 判断是否是回文串:回文串的子串肯定也是回文串
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public static boolean validPalindRome(String s, int left, int right) {
        char[] charArray = s.toCharArray();
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /***
     * 中心算法:以每个字符为中心，看其最长的回文串是多少。记录每次最长的那个。返回即可。
     *
     * 1.按照中心判断回文串的方法
     * 2.记录当前最长的长度和回文串
     *
     * 时间复杂度 o(n2)
     * 空间复杂度 o(1
     *
     *
     *
     */

    public static String longestPalindRomeCenter(String s) {
        System.out.println(System.currentTimeMillis());
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String initStr = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String oldStr = centerSpread(s, i, i);
            String eventStr = centerSpread(s, i, i + 1);
            String maxLenStr = oldStr.length() > eventStr.length() ? oldStr : eventStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                initStr = maxLenStr;
            }
        }
        System.out.println(System.currentTimeMillis());

        return initStr;
    }

    public static String centerSpread(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j <= s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
