package com.example.arithmetic.arithmeticstu.classic;

/**
 * LIS:Longest  Increasing Subsequence。最长上升子序列
 * <p>
 * https://blog.csdn.net/lxt_Lucia/article/details/81206439
 *
 * @author xiaobao.chen
 * Create at 2020-05-25
 */
public class lis {

    public static void main(String[] args) {
        int[] a = {4, 7, 1, 5, 6, 3, 10};
        System.out.println(lis(a));
    }

    public static int lis(int[] a) {
        int[] f = new int[a.length];
        //默认单独的节点的最长子序列是自己本身，默认是1
        for (int i = 0; i < a.length; i++) {
            f[i] = 1;
        }

        for (int i = 1; i < a.length; i++) {

            for (int j = 1; j < i; j++) {
                if (a[j] < a[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        int init = 1;
        for (int ff : f) {
            init = Math.max(init, ff);
        }
        return init;
    }
}
