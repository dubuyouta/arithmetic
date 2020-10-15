package com.example.arithmetic.arithmeticstu.string;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * @author xiaobao.chen
 * Create at 2020/4/22
 */
public class Arithmetic2020101303 {

    public static void main(String[] args) {
        System.out.println(reverseStr("hellomytoday", 3));
    }

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() <= 0 || "".equals(s)) {
            return s;
        }
        if (k <= 0) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int start = 0; start < array.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, array.length - 1);
            while (i < j) {
                char temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        }
        return new String(array);
    }
}
