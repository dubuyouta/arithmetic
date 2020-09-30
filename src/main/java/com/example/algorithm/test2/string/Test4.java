package com.example.algorithm.test2.string;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 11:01
 */
public class Test4 {
    /**
     * 请编写一个方法，将字符串中的空格全部替换为“%20”。
     * 假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，
     * 同时保证字符串由大小写的英文字母组成。给定一个string iniString 为原始的串，
     * 以及串的长度 int len, 返回替换后的string
     *
     * 测试样例：
     * "Mr John Smith”,13
     * 返回："Mr%20John%20Smith"
     * ”Hello  World”,12
     * 返回：”Hello%20%20World”
     */

    public static void main(String[] args) {
    }


    public String replaceSpace(String iniString, int length) {
        // 如果允许分配额外空间
        if (iniString == null || iniString.length() <= 0)
            return iniString;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }

    public String replaceSpace(String str) {
        char[] charArr = str.toCharArray();
        // 计算源字符串的长度和空格的数量
        int originalLength = charArr.length;
        int numberOfBlank = 0;
        for (char item : charArr)
            if (item == ' ')
                numberOfBlank++;
        // 计算新的字符串长度
        int newLength = originalLength + numberOfBlank * 2;
        char[] newcharArr = new char[newLength];
        //
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0) {
            if (charArr[indexOfOriginal] == ' ') {
                newcharArr[indexOfNew--] = '0';
                newcharArr[indexOfNew--] = '2';
                newcharArr[indexOfNew--] = '%';
                indexOfOriginal--;
            } else {
                newcharArr[indexOfNew--] = charArr[indexOfOriginal--];
            }
        }
        return String.valueOf(newcharArr);
    }
}
