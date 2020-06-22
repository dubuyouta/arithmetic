package com.example.arithmetic.arithmeticstu.base;

/**
 * 选择排序：
 *
 * @author xiaobao.chen
 * Create at 2020-06-21
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 8, 15, 9, 4};
        a = select(a);
        for (int num :
                a) {
            System.out.println(num);
        }
    }

    public static int[] select(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        return a;
    }
}
