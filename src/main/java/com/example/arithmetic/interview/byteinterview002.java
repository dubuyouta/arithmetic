package com.example.arithmetic.interview;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个整数，找到一个比他大的最近的那个数
 * 比如 1234 --  1243
 * <p>
 * 1275432
 *
 * @author xiaobao.chen
 * Create at 2020-10-20
 */
public class byteinterview002 {

    public static void main(String[] args) {
        int[] num = {1, 2, 7, 5, 4, 3, 2};
        System.out.println(JSON.toJSONString(findNext(num)));
    }

    public static int[] findNext(int[] num) {
        if (num == null || num.length == 0) {
            return num;
        }
        int end = num.length - 1;
        int pre = end - 1;
        while (num[end] <= num[pre]) {
            end--;
            pre = end - 1;
        }

        int end2 = num.length - 1;
        while (num[end2] <= num[pre]) {
            end2--;
        }

        int temp = num[end2];
        num[end2] = num[pre];
        num[pre] = temp;

        System.out.println(JSON.toJSONString(num));

        int end3 = num.length - 1;
        int prenext = pre + 1;
        for (; prenext < end3; prenext++, end3--) {
            int temp1 = num[end3];
            num[end3] = num[prenext];
            num[prenext] = temp1;
        }
        return num;
    }
}
