package com.example.sort.test3;

import java.util.Arrays;

public class HeapSortTest3 {

    public static void main(String[] args) {
        HeapSortTest3 test=new HeapSortTest3();
        int[] array = {4, 2, 3, 8, 9, 4, 6, 7, 5, 10, 1};
        System.out.println(Arrays.toString(test.test2(array)));
    }

    /**
     * 构建大顶堆 和 小顶堆 每次选择堆顶一个元素，放在最后或最前，再调整堆
     * 继续
     * 2叉堆 必须保证 kn<k2n kn<k(2n+1) 父节点 必须小于左节点和右结点
     * 必须每一个元素都是这样构建
     *
     * 先构建大顶堆
     * @param array
     * @return
     */
    private int[] test(int[] array){
        if(array==null||array.length<2){
            return array;
        }
        /**
         * 瑕疵 此处直接使用 length，内层也直接使用length/2
         */
        for(int i=array.length-1;i>0;i--){
            //构建大顶堆方法
            for(int j=(i-1)/2;j>=0;j--){
                int leftIndex=2*j;
                int rightIndex=2*j+1>=i?leftIndex:2*j+1;
                int maxIndex= array[leftIndex]>=array[rightIndex]?leftIndex:rightIndex;
                if(array[maxIndex]>array[j]){
                    int temp=array[j];
                    array[j]=array[maxIndex];
                    array[maxIndex]=temp;
                }
            }
            //大顶堆构建成功，第一个元素
            if(array[0]>array[i]){
                int temp=array[0];
                array[0]=array[i];
                array[i]=temp;
            }
        }
        return array;

    }

    private int[] test2(int[] array){
        if(array==null||array.length<2){
            return array;
        }
        /**
         * 瑕疵 此处直接使用 length，内层也直接使用length/2
         *
         * 因为借助一半长度，说的数，并不是index
         */
        for(int heap=array.length;heap>0;heap--){
            //构建大顶堆方法
            for(int j=heap/2;j>=0;j--){
                int maxIndex=j;
                if(2*j<heap&&array[2*j]>array[maxIndex]){
                    maxIndex=2*j;
                }
                if(2*j+1<heap&&array[2*j+1]>array[maxIndex]){
                    maxIndex=2*j+1;
                }
                if(maxIndex!=j){
                    int temp=array[j];
                    array[j]=array[maxIndex];
                    array[maxIndex]=temp;
                }
            }
            //大顶堆构建成功，第一个元素
            int temp = array[0];
            array[0] = array[heap - 1];
            array[heap - 1] = temp;
        }
        return array;

    }
}
