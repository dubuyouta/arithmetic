package com.example.arithmetic.arithmeticstu.base;

/**
 * 插入排序：类似于打牌时，整理排的过程
 * 默认把第一个数作为有序的，然后把后续的每一个值跟有序的值进行比较，比它大，就交互位置，不大，就不交互，一直比较到第一个值，
 * 此时形成新的有序的，下一个重复前面的动作。
 *
 * @author xiaobao.chen
 * Create at 2020-05-25
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] a = {5, 10, 4, 20, 9, 13};
        insertSort(a);
        for (int n :
                a) {
            System.out.println(n);
        }
    }

    public static void insertSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int j = 0;
            int temp = a[i];
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void insert(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = a[j];
                } else {
                    break;
                }
            }
        }
    }
}
