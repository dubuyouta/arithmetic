package com.example.algorithm.test1.array;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2019/11/22 15:54
 */
public class Test13 {
    /**
     * 题目描述
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * 分析 需要使用稳定排序， 有需要相对顺序聚集 ，使用插入排序
     */
    public static void main(String[] args) {
        Test13 test=new Test13();
        int[] array1={1,3,5,7};
        test.reOrderArray1(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2={1,2,5,8,10,11,15,16,17};

        test.reOrderArray2(array2);
        System.out.println(Arrays.toString(array2));



    }

    public void reOrderArray1(int [] array) {
        if(array==null||array.length<2){
            return;
        }
        /**
         * 使用2个指针 针对 说明下次 奇数 或者 偶数 需要插入的位置
         */

        /**
         * 写的有问题，想想错误，没在优化
         */
        int oddIndex=0; //奇数下次插入下标
        //int evenIndex=0;//偶数下次插入下标
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1){
                //奇数
                if(oddIndex==i){
                    //当前为是奇数，插入也是当前位置，不需要移动，继续

                }else {
                    int temp=array[i];
                    // 把第 i为位 到 前面 oddIndex 的数据后移一位，给插入留下位置
                    for(int j=i;j>oddIndex;j--){
                        array[j]=array[j--];
                    }
                    //array[oddIndex++]=temp;
                    array[oddIndex]=temp;
                }
                oddIndex++;
            }
        }

    }

    public void reOrderArray2(int [] array) {
        if(array==null||array.length<2){
            return;
        }
        /**
         * reOrderArray1 的 错误定修正版
         */
        int oddIndex=0; //奇数下次插入下标
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1){
                //奇数
                if(oddIndex!=i) {
                    int temp=array[i];
                    // 把第 i为位 到 前面 oddIndex 的数据后移一位，给插入留下位置
                    for(int j=i;j>oddIndex;j--){
                        /**
                         * 此处应该是 j-1  上面手误 写成 j-- 了
                         */
                        array[j]=array[j-1];
                    }
                    array[oddIndex]=temp;
                }
                oddIndex++;
            }
        }

    }

}
