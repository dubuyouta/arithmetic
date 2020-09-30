package com.example.algorithm.test2.string;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 10:07
 */
public class Test2 {
    /**
     * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
     *
     * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
     *
     * 测试样例：
     * "This is nowcoder"
     * 返回："redocwon si sihT"
     *
     */

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.revertString1("This is nowcoder"));
    }

    private String revertString(String val){
        if(val==null||val.isEmpty()){
            return val;
        }
        int length=val.length();
        int low=0,high=length-1;
        char[] charArray=val.toCharArray();
        for(;low<high;low++,high--){
            char temp=charArray[low];
            charArray[low]=charArray[high];
            charArray[high]=temp;
        }
        return new String(charArray);
    }

    private String revertString1(String val){
        if(val==null||val.isEmpty()){
            return val;
        }
        int length=val.length();
        char[] charArray=val.toCharArray();
        for(int i=0;i<length/2;i++){
            char temp=charArray[i];
            charArray[i]=charArray[length-1-i];
            charArray[length-1-i]=temp;
        }
        return new String(charArray);
    }
}
