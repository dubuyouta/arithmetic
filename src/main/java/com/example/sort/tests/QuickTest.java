package com.example.sort.tests;

public class QuickTest {

    public static void main(String[] args) {


    }

    private void quickSort(int[] array,int low,int high){
        if(array==null||array.length<1){
            return;
        }
        if(low>=high){
            return ;
        }
        int left=low;
        int right=high;
        int temp=array[left];
        while (left<right){
            while (left<right&&array[right]>=temp){
                right--;
            }
            array[left]=array[right];
            while (left<right&&array[left]<=temp){
                left++;
            }
            array[right]=array[left];
        }
        array[left]=temp;
        quickSort(array,low,left-1);
        quickSort(array,left+1,high);
    }
}
