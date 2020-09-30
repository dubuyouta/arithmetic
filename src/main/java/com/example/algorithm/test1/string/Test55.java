package com.example.algorithm.test1.string;

/**
 * @author: heshineng
 * @createdBy: 2020/5/27 13:52
 */
public class Test55 {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
     *  第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */

    public static void main(String[] args) {
        Test55 test55 =new Test55();
        System.out.println(test55.searchFirst("resterstabc"));
    }

    private String searchFirst(String val){
        if(val==null||val.length()==0){
            return null;
        }
        int[] occurence = new int[256];
        char[] valCharArray=val.toCharArray();
        for(int i=0;i<valCharArray.length;i++){
            occurence[(int)valCharArray[i]]++;
        }
        for(int i=0;i<valCharArray.length;i++){
            if(occurence[(int)valCharArray[i]]==1){
                return new String(new char[]{valCharArray[i]});
            }
        }
        return "#";
    }
}
