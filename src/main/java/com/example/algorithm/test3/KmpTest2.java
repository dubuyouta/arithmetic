package com.example.algorithm.test3;

/**
 * @author heshineng
 * created by 2020/9/9
 */
public class KmpTest2 {

    public static void main(String[] args) {
        KmpTest2 test = new KmpTest2();
        System.out.println(test.indexOf("asasawaskasasctm", "asasc"));
        System.out.println(0x7fffffff);
    }

    private int indexOf(String val, String subVal) {
        if (val == null || val.length() == 0
                || subVal == null
                || subVal.length() == 0
                || val.length() < subVal.length()) {
            return -1;
        }
        int valIndex = 0, subIndex = 0;
        int valLength = val.length(), subLength = subVal.length();
        int[] next = getNext(subVal);
        char[] valChar = val.toCharArray(), subValChar = subVal.toCharArray();
        while (valIndex < valLength && subIndex < subLength) {
            if (valChar[valIndex] == subValChar[subIndex]) {
                valIndex++;
                subIndex++;
            } else {
                if (subIndex == 0) {
                    valIndex++;
                } else {
                    //继承之前
                    subIndex = next[subIndex - 1];
                }
            }
        }
        if (subIndex == subLength) {
            //说明找到了
            return valIndex - subIndex;
        }
        return -1;
    }

    private int[] getNext(String val) {
        if (val == null || val.length() == 0) {
            return null;
        }
        int[] next = new int[val.length()];
        char[] charArray = val.toCharArray();
        for (int i = 0; i < val.length(); i++) {
            //先初始值复制
            if (i == 0) {
                next[i] = 0;
                continue;
            }
            //获取前一个的下标，是否可以继承
            int k = next[i - 1];
            while (k != 0 && charArray[i] != charArray[k]) {
                //往前找
                k = next[k - 1];
            }
            if (charArray[i] == charArray[k]) {
                //找到继承
                next[i] = k + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}
