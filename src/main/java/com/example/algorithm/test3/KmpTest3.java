package com.example.algorithm.test3;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class KmpTest3 {
    /**
     *查看一个字符串中是否完全包含子串，并返回其位置
     */
    public static void main(String[] args) {
        KmpTest3 kmpTest3 = new KmpTest3();
        System.out.println(kmpTest3.indexOf("asasawaskasasctm", "asasc"));
        System.out.println(kmpTest3.indexOf1("asasawaskasasctm", "asasc"));
        System.out.println(kmpTest3.indexOf2("asasawaskasasctm", "asasc"));
    }

    //暴力破解 o（n*m）
    private int indexOf(String val, String subVal) {
        if (val == null || val.isEmpty() || subVal == null || subVal.isEmpty()
                || subVal.length() > val.length()) {
            return -1;
        }
        for (int i = 0; i < val.length(); i++) {
            if (val.length() - i < subVal.length()) {
                break;
            }
            boolean match = true;
            for (int j = 0; j < subVal.length(); j++) {
                if (val.charAt(i + j) != subVal.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;

    }

    //暴力破解的另外的解法
    private int indexOf1(String val, String subVal) {
        if (val == null || val.isEmpty() || subVal == null || subVal.isEmpty()
                || subVal.length() > val.length()) {
            return -1;
        }
        int valIndex = 0, subIndex = 0;
        char[] valArray = val.toCharArray();
        char[] subArray = subVal.toCharArray();
        while (valIndex < valArray.length && subIndex < subArray.length) {
            if (valArray[valIndex] == subArray[subIndex]) {
                valIndex++;
                subIndex++;
            } else {
                //不匹配，valIndex要回到原来的下一个
                valIndex = valIndex - subIndex + 1;
                subIndex = 0;
            }
        }
        if (subIndex == subArray.length) {
            //匹配完 此处subIndex和 valIndex 都多加了1，所以直接减回到原始位置
            return valIndex - subIndex;
        }
        return -1;
    }

    //kmp解法
    private int indexOf2(String val, String subVal) {
        if (val == null || val.isEmpty() || subVal == null || subVal.isEmpty()
                || subVal.length() > val.length()) {
            return -1;
        }
        int[] array = getNextArray(subVal);
        int index = 0;
        int subIndex = 0;
        while (index < val.length() && subIndex < subVal.length()) {
            if (val.charAt(index) == subVal.charAt(subIndex)) {
                index++;
                subIndex++;
            } else {
                if (subIndex == 0) {
                    index++;
                } else {
                    //判断重复度，subIndex适当回退，不全回退,回退的下一个
                    //subIndex = subIndex - array[subIndex] + 1;
                    //此处继承前一个匹配度，开始位置当前位置的前一个元素的匹配度，再继续
                    subIndex = array[subIndex - 1];
                }
            }
        }
        if (subIndex == subVal.length()) {
            //匹配完 此处subIndex和 valIndex 都多加了1，所以直接减回到原始位置
            return index - subIndex;
        }
        return -1;
    }

    private int[] getNextArray(String subVal) {
        if (subVal.length() < 2) {
            return new int[]{0};
        }
        char[] charArray = subVal.toCharArray();
        int[] array = new int[subVal.length()];
        array[0] = 0;
        for (int i = 1; i < subVal.length(); i++) {
            //前一个字符的匹配度
            int k = array[i - 1];
            //找到可以继承的上一个的匹配度加1
            while (k > 0 && charArray[i] != charArray[k]) {
                //匹配度减1，继续往前找
                k = array[k - 1];
            }
            if (charArray[i] == charArray[k]) {
                //继承
                array[i] = k + 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }
}
