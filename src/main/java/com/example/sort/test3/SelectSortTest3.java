package com.example.sort.test3;

import java.util.Arrays;

public class SelectSortTest3 {

    public static void main(String[] args) {
        SelectSortTest3 test=new SelectSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test(array)));
    }

    private int[] test(int[] array){
        /**
         * 选择最最小的放第一个 每次找最小元素
         */
        if(array==null||array.length<2){
            return array;
        }
        for(int i=0;i<array.length-1;i++){
            /**
             * 此处的优化，在未交换之前，minIndex均能正确代表数组的元素
             */
            //int min=array[i];
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
//                if(array[j]<min){
//                    min=array[j];
//                    minIndex=j;
//                }
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                //交换
                int temp=array[i];
                array[i]=array[minIndex];
                array[minIndex]=temp;
            }
        }
        return array;
    }
}
