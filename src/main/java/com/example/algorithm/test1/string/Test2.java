package com.example.algorithm.test1.string;

public class Test2 {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     * java 中正则匹配的空格  \\s+
     */
    public static void main(String[] args) {
        Test2 test = new Test2();
        String value = "We Are Happy";
        System.out.println(test.replaceSpace1(value));
        System.out.println(test.replaceSpace2(value));
        System.out.println(test.replaceSpace3(value));
    }

    /**
     * 最差的办法，使用String的 replalece 方法
     */
    private String replaceSpace1(String value) {
        if (value == null || value.length() == 0) {
            return value;
        }
        return value.replaceAll("\\s+", "%20");
    }

    //循环，每一位匹配
    private String replaceSpace2(String value) {
        if (value == null || value.length() == 0) {
            return value;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char s = value.charAt(i);
            if (s == ' ') {
                builder.append("%20");
            } else {
                builder.append(s);
            }
        }
        return builder.toString();
    }

    /**
     * 先将字符串循环一遍，找到里面的空格，确定新字符串的char大小
     *
     * @param value
     * @return
     */
    private String replaceSpace3(String value) {
        if (value == null || value.length() == 0) {
            return value;
        }
        int spaceNums = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ' ') {
                spaceNums++;
            }
        }
        String replaceStr = "%20";
        int newStringLength = value.length() + replaceStr.length() * spaceNums;
        char[] newStringCharArray = new char[newStringLength];
        int newCharIndex = 0;
        for (int i = 0; i < value.length(); i++) {
            char s = value.charAt(i);
            if (s == ' ') {
                for (int j = 0; j < replaceStr.length(); j++) {
                    newStringCharArray[newCharIndex++] = replaceStr.charAt(j);
                }
            } else {
                newStringCharArray[newCharIndex++] = s;
            }
        }
        return new String(newStringCharArray);
    }
}
