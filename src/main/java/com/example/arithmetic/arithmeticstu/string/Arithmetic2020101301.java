package com.example.arithmetic.arithmeticstu.string;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author xiaobao.chen
 * Create at 2020/4/22
 */
public class Arithmetic2020101301 {

    public static void main(String[] args) {
        System.out.println("123456".substring(1, 4));
        System.out.println("123456".substring(2));

       // System.out.println(reverseLeftWords("Wearehappy", 10));
    }

    public static String reverseLeftWords(String s, int n) {
        System.out.println(s.length());
        if (s == null || "".equals(s)) {
            return s;
        }
        if (s.length() <= 0 || n >= s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String preStr = s.substring(0, n);
        String subStr = s.substring(n);
        sb.append(subStr).append(preStr);
        return sb.toString();
    }
}
