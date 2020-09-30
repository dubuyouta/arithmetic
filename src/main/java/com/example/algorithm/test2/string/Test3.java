package com.example.algorithm.test2.string;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 10:35
 */
public class Test3 {
    /**
     *给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串
     * 。这里规定大小写为不同字符，且考虑字符串中的空格。
     *
     * 给定一个string stringA和一个string stringB，请返回一个bool，
     * 代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
     *测试样例：
     *"This is nowcoder","is This nowcoder"
     *返回：true
     *"Here you are","Are you here"
     *返回：false
     */

    public static void main(String[] args) {
        Test3 test3=new Test3();
        System.out.println(test3.equals("Here you are","are you Here"));

    }

    private boolean equals(String a,String b){
        if(a==b){
            return true;
        }
        if(a==null||b==null){
            return false;
        }
        if(a.length()!=b.length()){
            return false;
        }
        int[] array=new int[256];
        for(int i=0;i<a.length();i++){
            array[a.charAt(i)]++;
            array[b.charAt(i)]--;
        }
        for(int i=0;i<array.length;i++){
            if(array[i]!=0){
                return false;
            }
        }
        return true;
    }
}
