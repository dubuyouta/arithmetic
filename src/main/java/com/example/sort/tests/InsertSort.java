package com.example.sort.tests;

import com.alibaba.fastjson.JSON;

public class InsertSort {

    public static void main(String[] args) {
        InsertSort s=new InsertSort();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(JSON.toJSONString(s.insertSort1(array)));
    }

    private int[] insertSort1(int[] array){
        if(array==null||array.length<2){
            return array;
        }
        for(int i=1;i<array.length;i++){
            int temp=array[i];
            for(int j=i;j>=0;j--){
                if(j>0&&temp<array[j-1]){
                    array[j]=array[j-1];
                }else{
                    array[j]=temp;
                    break;
                }
            }

        }
        return array;
    }

    /**
     * 写的垃圾 重入排序必须从第一个开始
     * @param array
     * @return
     */
    private int[] insertSort(int[] array){
        if(array==null||array.length<2){
            return array;
        }
        for(int i=0;i<array.length-1;i++){
            int j=i+1;
            int temp=array[j];
            for(;j>=0;j--){
                if(temp<array[j]){
                    array[j+1]=array[j];
                }
            }
            array[j]=temp;
        }
        return array;

    }
}
