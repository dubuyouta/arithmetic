package com.example.algorithm.test1.string;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2020/7/9 17:24
 */
public class Test71 {
    /**
     * 判断一个字符串中是否包含子串，并返回原字符串中子串的起始位置
     * 1.暴力破解
     * 2.kmp的优化算法
     */

    public static void main(String[] args) {
        Test71 test71 = new Test71();
        System.out.println(Arrays.toString(test71.getNext("agctagcagctagctg")));
        System.out.println(Arrays.toString(test71.getNext1("agctagcagctagctg")));
        System.out.println(Arrays.toString(test71.getNext1("abckabcsabckabckk")));
        System.out.println();
        System.out.println(test71.indexOf("asasawaskasasctm", "asasc"));
        System.out.println(test71.indexOf1("asasawaskasasctm", "asasc"));
    }

    /**
     * 暴力破解方式
     *
     * 上面暴力破解的逻辑很简单：
     *     就是使用子串在原字符串中一一比对，遇到一致的，原串的指针和子串指针一起后移
     *     遇到不匹配的，回溯到最近一次子串头匹配的位置的下一个位置，继续匹配
     *
     *     如果匹配重复双指针移动，不匹配原串继续后移
     *
     *     时间复杂度是 O(n*m) (n=原串长度，m=子串长度)
     */
    private int indexOf(String val, String subVal) {
        if (val == null || subVal == null || val.length() < subVal.length()) {
            return -1;
        }
        int valIndex = 0, subValIndex = 0;
        int valLength = val.length(), subValLength = subVal.length();
        char[] valChar = val.toCharArray();
        char[] subValChar = subVal.toCharArray();
        while (valIndex < valLength && subValIndex < subValLength) {
            if (valChar[valIndex] == subValChar[subValIndex]) {
                // 如果当前字符匹配成功,则将两者各自增1,继续比较后面的字符
                valIndex++;
                subValIndex++;
            } else {
                // 如果当前字符匹配不成功,则i回溯到此次匹配最开始的位置+1处,也就是i = i - j + 1
                // (因为i,j是同步增长的), j = 0;
                valIndex = valIndex - subValIndex + 1;
                subValIndex = 0;
            }
        }
        // 匹配成功,则返回模式字符串在原字符串中首次出现的位置;否则返回-1
        if (subValIndex == subValLength) {
            return valIndex - subValIndex;
        }

        //否则未找到 -1
        return -1;
    }


    /**
     * kmp算法，主要是计算子串的重复度的属性，是字符串本身的属性，跟匹配原串无关
     * 但匹配原串的基础上，利用重复度的本身偏移，可以做到减少一些原串与子串匹配时的一些循环
     * 但仅仅是对子串有重复度的有优化，否则还是原来暴力破解方式。
     *
     * kmp的核心，是得到子串的一个重复度的数组的函数 getNext的实现：
     * -1 是记录到字符数组的前面的做法，第一个字符记作0，-1进行站位，最后一个移位就放弃了
     * 首先记录子串的第一个字符的重复度为：0（重复度是要利用后面除第一个字符的传跟前面对比的）
     * 第一个字符无字符对比，记作-1 而且重复度，必须是一个顺序的子串和前面子串（从左到右的串的重复）
     * 如： a b c  a b c    (a b c 重复了前面的 a b c) 因为我们将要做匹配也是顺序的，所以不是 ab ba 这种
     *
     * 当我们发现后面的字符与前面不匹配记作0  ：
     *                                        a  b  c
     *                                     -1 0  0  0
     *  当前一个字符已经重复前面的子串时，后面的字符还匹配时，可继承前一个的匹配度再加1：
     *                                        a  b  c  a  b  c
     *                                     -1 0  0  0  1  2  3
     *   最后一个字符c的匹配度就是 c=2+1  （它和前一个子串的最后一个字符）
     *
     *   当发现前面的新字符和前面的子串不匹配时，就尝试跳过目前的这个重复段，往前找看是否能找到继承的匹配度
     *   找到就继承 +1 找不到就为 0
     *   找到：    a b c k  a b c s  a b c k a b c k k
     *          -1 0 0 0 0  1 2 3 0  1 2 3 4 5 6 7 4 0
     *
     *           首先到数第2个k ，需要往前找匹配的子串，首选要跳过前一个继承的重复段，即7个字符，因为
     *           这个k 和前面组合不成 继承关系，找k 前一个字符，查看它的上一串重复，中是否能集成：
     *
     *           如 a b c s  找到 c的重复度为3 并且 a b c k 初始 的 k=k 所以为 4
     *
     *           上面最后一个找不到，所以k=0
     *
     *           kmp 主要算法，确认后面的数据与前面的重复度问题。尽量继承前面的算法，不能继承，就为0
     *           记作，首个字母的匹配度为0
     *
     *           在做数位比较迁移的时候，需要保证当子串又回到0位时，又不和 原字符串匹配，需要
     *           原字符串匹配，导致数位进一
     */

    private int indexOf1(String val, String subVal) {
        if (val == null || subVal == null || val.length() < subVal.length()) {
            return -1;
        }
        int valIndex = 0, subValIndex = 0;
        int valLength = val.length(), subValLength = subVal.length();
        char[] valChar = val.toCharArray();
        char[] subValChar = subVal.toCharArray();
        int[] next = getNext(subVal);
        while (valIndex < valLength && subValIndex < subValLength) {
            if(valChar[valIndex] == subValChar[subValIndex]){
                valIndex++;
                subValIndex++;
            }else{
                if(subValIndex == 0){
                    valIndex++;
                }else{
                    subValIndex=next[subValIndex-1];
                }
            }

//            if (valChar[valIndex] != subValChar[subValIndex] && subValIndex == 0) {
//                /**
//                 * 当子串的第一个字符和原字符串不匹配时，原串的下标后移
//                 */
//                valIndex++;
//            } else {
//                if (valChar[valIndex] == subValChar[subValIndex]) {
//                    valIndex++;
//                    subValIndex++;
//                } else {
//                    subValIndex=next[subValIndex-1];
//                }
//            }
        }
        // 匹配成功,则返回模式字符串在原字符串中首次出现的位置;否则返回-1
        if (subValIndex == subValLength) {
            return valIndex - subValIndex;
        }

        //否则未找到 -1
        return -1;
    }

    /**
     *子串：
     * 字符： a  g  c  t  a  g  c   |  a  g  c   t   a   g   c   t   g
     * 下标： 0  1  2  3  4  5  6   |  7  8  9  10  11  12  13  14  15
     * next： 0  0  0  0  1  2  3  |  1  2  3  4   5   6   7   4   0
     *
     * 以上数据，下标 从7-13 重复 下标[0,6] 的数据了
     * 数据可以继承，查看示例，以index=13 为例
     * 如果继承前面的，在next[13-1]=6 的下标下的字符应该和 i=13 相等
     * 就是说如果i=13 之前的6个字符和字符串最开始6个字符重复，
     * 所以要看最开始的第7个字符（也就是下标为6的字符）是否当前 i=13 的字符，
     * 如果相等，i=13 的 next=6+1=7
     *
     * [0, 0, 0, 0, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 4, 0]
     *
     */
    private int[] getNext(String val) {
        if (val == null || val.length() == 0) {
            return null;
        }
        int length = val.length();
        //存放下一次偏移的偏移量
        int[] next = new int[length];
        next[0] = 0;
        char[] valArray = val.toCharArray();
        for (int i = 1; i < length; i++) {
            //先查看前一个下标的偏移量的值，看是否能继承之前的偏移量的值
            int k = next[i - 1];
            while (k != 0 && valArray[i] != valArray[k]) {
                //没找到相同，向前找
                k = next[k - 1];
            }

            //找到距离上一个坐标最近的下标的值，继承前一个偏移量的结果的基础加1
            if (valArray[i] == valArray[k]) {
                next[i] = k + 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }

    private int[] getNext1(String val) {
        if (val == null || val.length() == 0) {
            return null;
        }
        int length = val.length();
        //存放下一次偏移的偏移量
        int[] next = new int[length];
        next[0] = -1;
        int j = 0, k = -1;
        while (j < length - 1) {
            if (k == -1 || val.charAt(j) == val.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else
                k = next[k];
        }
        return next;
    }


}
