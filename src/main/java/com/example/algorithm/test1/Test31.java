package com.example.algorithm.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2019/11/26 1:52
 */
public class Test31 {
    /**
     * 题目：
     *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     */

    public static void main(String[] args) {
        Test31 test=new Test31();
        int[] array={3,32,321};
        System.out.println(test.printMinNumber1(array));
    }


    /**
     * 基本思想使用字符串排序 即数字的每一位排序，排好之后，再依次拼接
     * @param numbers
     * @return
     */
    public String printMinNumber1(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            result.add(String.valueOf(numbers[i]));
        }
        result.sort(((o1, o2) -> (o1+o2).compareTo(o2+o1)));

        StringBuilder stringBuilder = new StringBuilder();
        for(String s : result){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();

    }

    /**
     * 自己的思路，先选出一个最大数，判断是几位数，
     * 其他几个数 不够高位的补0
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            result.add(covert(numbers[i]));
        }
        //已经将数字转换成基本数位数组
        StringBuilder stringBuilder=new StringBuilder();
        int resultNumber=0;
        //遍历数组的指针
        int resultListIndex=1;
        //记录结果数 的 数据第几位开始  设置最高位为第0位
        int resultIndex=0;
        //记录上次最佳结果
        List<Integer> preResult=result.get(0);
        while (!result.isEmpty()){
            for(;resultListIndex<result.size();resultListIndex++) {
                List<Integer> next = result.get(resultListIndex);
                if (next.size() > resultIndex) {
                    //数组必须要在 比较位数指针范围类
                    //有特殊 0 最高位不能为0 再看情况讨不讨论
                    if (compareArray(preResult, next, resultIndex) > 0) {
                        preResult = next;
                    }
                }
            }

        }
        return stringBuilder.toString();

    }

    //比较2个数组第几位的大小 compareIndex 必须在2个数组范围内
    private int compareArray(List<Integer> one,List<Integer> tow,int compareIndex){
        return one.get(compareIndex)-tow.get(compareIndex);
    }

    private List<Integer> covert(int number){
        String a=String.valueOf(number);
        char[] chars=a.toCharArray();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            list.add((int)chars[i]);
        }
        return list;
    }


}
