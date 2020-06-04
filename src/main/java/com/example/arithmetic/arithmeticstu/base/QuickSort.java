package com.example.arithmetic.arithmeticstu.base;

/**
 * 快速排序：找一个基准值，比基准值小的都在左边序列，比基准值大的都在右边序列
 * 一次排序的过程：start.索引 end.索引
 * 先从后往前比较。如果当前值 比 基准值大，索引值减1（在拿前一个值进行比较）。如果比基准值小，这个时候就把当前的值
 * 替换为start 索引对应的位置。把start值替换到end 索引对应的位置。
 * 然后 此时从前往后比较，如果当前值比基准值小没，那么就找下一个值进行比较，如果比基础值大，那就替换值，替换到end索引
 * 对应的位置。把end值替换到start 索引对应的位置。
 * 然后再从后往前查找，比较，替换
 * 一直到start == end.
 * 此时左边的值都小于 基准值，右边的值都大于 基准值。
 * <p>
 * 分区之后，各个分区在重复调用上面的流程。
 * <p>
 * <p>
 * 关于基准值的优化方案：
 * https://blog.csdn.net/lxk2017/article/details/102779042
 *
 * @author xiaobao.chen
 * Create at 2020-05-24
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {20, 15, 3, 75, 39, 23, 6, 45};
        sort(a, 0, a.length - 1);
        for (int b :
                a) {
            System.out.println(b);
        }
    }

    public static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int base = a[low];//默认第一个值作为基准值。（有优化方案。）

        while (end > start) {
            //从后往前查找
            while (end > start && a[end] >= base) {
                end--;
            }
            if (a[end] < base) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //从前往后查找
            while (end > start && a[start] <= base) {
                start++;
            }
            if (a[start] > base) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
        }

        if (start > low) {
            sort(a, low, start - 1);
        }
        if (end < high) {
            sort(a, end + 1, high);
        }
    }
}
