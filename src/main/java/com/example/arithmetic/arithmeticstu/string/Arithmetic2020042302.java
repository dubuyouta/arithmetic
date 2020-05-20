package com.example.arithmetic.arithmeticstu.string;

/**
 * @author xiaobao.chen
 * Create at 2020/4/22
 */
public class Arithmetic2020042302 {

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public static String replaceSpaceFast(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
