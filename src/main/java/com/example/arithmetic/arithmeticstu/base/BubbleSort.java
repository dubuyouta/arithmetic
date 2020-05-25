package com.example.arithmetic.arithmeticstu.base;


/**
 * 冒泡排序：比较前后两个相邻的数据，如果前面的数据大于后面的数据，就将两个数据作交换；
 * 遍历一遍之后，就将最大的数据沉到了最后面
 *
 * @author xiaobao.chen
 * Create at 2020-05-24
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 8, 15, 9, 4};
        a = bubbleSort(a);
        for (int num :
                a) {
            System.out.println(num);
        }
    }

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
}
