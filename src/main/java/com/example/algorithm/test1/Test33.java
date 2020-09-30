package com.example.algorithm.test1;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2019/11/28 15:06
 */
public class Test33 {
    /**
     * 题目：
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置,如果没有则返回 -1（需要区分大小写）.
     *
     * 题目解读：
     *   找到 字符串中 第一个 不重复的字符的位置  如 abcfdba 第一个不重复的是 c 位置为 2
     */

    public static void main(String[] args) {
        Test33 test = new Test33();
        System.out.println(test.firstNotRepeatingChar("abcdebhfabdceAA"));
        System.out.println(test.firstNotRepeatingChar1("abcdebhfabdceAA"));
        int[] array=new int[10];
        System.out.println(Arrays.toString(array));
        System.out.println(test.firstNotRepeatingChar2("abcdebhfabdceAA"));

        char a='h',b='f';
        System.out.println((int)a+" "+(int)b);
    }

    /**
     * 最简单方式，暴力方式 第一个元素 与其他元素进行一一对比的2次循环
     * 还可以按从小大排序 又连续不一样的数就是不重复的
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        int result = -1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 0) {
                continue;
            }
            int temp = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == 0) {
                    continue;
                }
                if (temp == chars[j]) {
                    if (chars[i] != 0) {
                        chars[i] = 0;
                    }
                    chars[j] = 0;
                }
            }
            if (chars[i] != 0) {
                result = i;
                break;
            }
        }
        //最后一位可能为不重复
        if(result==-1&&chars[chars.length-1]!=0){
            result=chars.length-1;
        }
        return result;
    }

    /**
     * 先排序，按从小到大的排序
     * @param str
     * @return
     */
    public int firstNotRepeatingChar1(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        //使用排序方式
        quickSort(chars,0,chars.length-1);
        System.out.println(Arrays.toString(chars));
        //找到不重复的数
        /**
         * 这种排序有问题，进过排序以后，可能找到不重复数，但这个数并非是第一个可能并非第一个
         */
        char noRepeat=0;
        char pre=chars[0];
        int preNum=0;
        for(int j=1;j<chars.length;j++){
            if(pre==chars[j]){
                preNum++;
            }else{
                if(preNum>0){
                    pre=chars[j];
                    preNum=0;
                }else{
                    noRepeat=pre;
                    break;
                }
            }
        }
        //可能不重复的是最后一个
        if(pre!=0&&preNum==0){
            noRepeat=pre;
        }
        if(noRepeat==0){
            return -1;
        }
        for(int i=0;i<str.length();i++){
            if(noRepeat==str.charAt(i)){
                return i;
            }
        }
        return -1;
    }

    private void quickSort(char[] chars,int low,int high){
        if(low>=high||chars.length==0){
            return ;
        }
        int left=low,right=high;
        char temp=chars[left];
        while (left<right){
            while (left<right&&chars[right]>=temp){
                right--;
            }
            chars[left]=chars[right];
            while (left<right&&chars[left]<=temp){
                left++;
            }
            chars[right]=chars[left];
        }
        chars[left]=temp;
        quickSort(chars,low,left-1);
        quickSort(chars,left+1,high);
    }


    /**
     * 使用hash表存储，存hash 是按照顺序 ，但最后找是按字符串顺序
     * 所以，还是可以找到 第一个不重复的数
     * @param str
     * @return
     */
    public int firstNotRepeatingChar2(String str) {
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++) {
            count[str.charAt(i)]++;
        }
        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for(int i=0; i < str.length();i++)
            if(count[str.charAt(i)]==1)
                return i;
        return -1;
    }

    /**
     * 利用每个字母的ASCII码作hash来作为数组的index。首先用一个58长度的数组来存储每个字母出现的次数，
     * 为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
     * 而每个字母的index=int(word)-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，
     * 最终遍历一遍字符串
     *
     * 计数排序的思想  貌似已经最优化了
     * @param str
     * @return
     */
    public int firstNotRepeatingChar3(String str) {
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[58];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++) {
            count[str.charAt(i)-65]++;
        }
        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for(int i=0; i < str.length();i++) {
            if (count[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }


}
