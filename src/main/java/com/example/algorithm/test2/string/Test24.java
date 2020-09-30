package com.example.algorithm.test2.string;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class Test24 {
    /**
     * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     *
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 示例:
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     */

    public static void main(String[] args) {
        Test24 test24 = new Test24();
        String s = "abcdefghijklmnopq";
        int k = 2;
        System.out.println(test24.reverseStr(s, k));
    }

    private String reverseStr(String val, int k) {
        if (val == null || val.length() == 0) {
            return val;
        }
        char[] valCharArray = val.toCharArray();
        int length = valCharArray.length;
        int start = 0;
        int end = start + 2 * k - 1;
        while (start < length || end < length) {
            if (end >= length) {
                //最后不足2k个
                end = length - 1;
            }
//            if (end - start + 1 == 2 * k) {
//                //正常反转 反转前k个
//            }else if(end-start+1<k){
//                //剩余全部反转
//            }else{
//                //长度大于等于k个，小于2k个，反转前k个
//                //所以1,3 合并
//            }
            if (end - start + 1 < k) {
                //长度不足k个，反转全部
                reverse(valCharArray, start, end);
            } else {
                //长度大于等于k，小于等于2k个，反转前k个
                int reverseIndex = start + k - 1;
                reverse(valCharArray, start, reverseIndex);
            }
            start = end + 1;
            end = start + 2 * k - 1;
        }
        return new String(valCharArray);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
