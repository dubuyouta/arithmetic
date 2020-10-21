package com.example.arithmetic.interview;

/**
 * @author xiaobao.chen
 * Create at 2020-10-20
 */
public class QuickSort {

    public void quickSort(int[] num, int low, int high) {
        if (num == null || num.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int temp = num[left];
        while (left < right) {
            while (left < right && num[right] >= temp) {
                right--;
            }
            num[left] = num[right];
            while (left < right && num[left] <= temp) {
                left++;
            }
            num[right] = num[left];
        }
        num[left] = temp;

        quickSort(num, low, left - 1);
        quickSort(num, left + 1, high);
    }
}
