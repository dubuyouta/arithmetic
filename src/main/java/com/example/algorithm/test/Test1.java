package com.example.algorithm.test;

import java.util.Arrays;

public class Test1 {
    /**
     * 题目：去除一个有序的数组中重复的数，得到数据使得每个数只出现一遍。
     * 并且不借助其他的存储空间 空间复杂度 O（1）
     *
     * 方法：使用双向指针
     */
    private int noRepeat(int[] array){
        int realLength=array.length;
        for(int i=0;i<realLength-1;i++){
            int fistValue=array[i];
            for(int j=i+1;j<realLength;j++){
                if(fistValue==array[j]){
                    //把j所有的元素向前移动
                    for(int p=j;p<realLength-1;p++){
                        array[p]=array[p+1];
                    }
                    realLength--;
                }
            }
        }
        return realLength;
    }


    private int removeRepeat(int[] array){
        int slow=0;
        for(int fast=0;fast<array.length;fast++){
            if(array[slow]!=array[fast]){
                slow++;
                array[slow]=array[fast];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {
        Test1 test1=new Test1();
        int[] array={1,4,4,5,6,7,7,5,10,12,1,13};
        System.out.println(test1.noRepeat(array));
        System.out.println(Arrays.toString(array));
    }
}
