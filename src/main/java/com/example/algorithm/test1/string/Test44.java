package com.example.algorithm.test1.string;

/**
 * @author: heshineng
 * @createdBy: 2020/5/18 18:26
 */
public class Test44 {

    /**
     * 字符串反转 如 student. a am I  变为 I am a student
     * @param args
     */

    public static void main(String[] args) {
        Test44 test45 = new Test44();
        System.out.println(test45.reversalString1("student a am I"));
    }

    /**
     * 第一种思路：按空格划分，反转字符串
     * @param str
     * @return
     */
    private String reversalString(String str) {
        if(str==null||str.length()==0){
            return str;
        }
        String[] strArray=str.trim().split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=strArray.length-1;i>=0;i--){
            stringBuilder.append(strArray[i]);
            if(i>0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 第2种思路，先反转所有的字符串，然后，依次翻转每个单词。
     * 通过空格来确定空格的起始位置
     */
    private String reversalString1(String str) {
        if(str==null||str.length()==0){
            return str;
        }
        char[] charArray=str.toCharArray();
        //先反转所有字符串
        reverse(charArray,0,charArray.length-1);
        /**
         * 查看空格，确定要反转的起始和结束位置反转字符
         * 数组的开始和结束没有空格
         */
        int start=0;
        for(int i=1;i<charArray.length;i++){
            if(charArray[i]==' '||i==charArray.length-1){
                //反转单词
                reverse(charArray,start==0?0:start+1,i==charArray.length-1?charArray.length-1:i-1);
                //反转完。
                start=i;
            }

        }
        return new String(charArray);
    }

    /**
     * 反转，高位和低位的对称位置进行替换
     * @param chars
     * @param low
     * @param high
     */
    public void reverse(char[] chars,int low,int high){
        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
