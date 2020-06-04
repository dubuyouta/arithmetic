package com.example.arithmetic.arithmeticstu.classic;

/**
 * 最长回文串：abba  abccba  abdba
 * 正着读和反着读 都是一样的。
 * <p>
 * 解题的思路：
 * 1.在回文串里，字符的出现个数奇数的字符最多只有一个，其它的肯定都是偶数。
 * 奇数的判断方法：出现的次数 n,  n%2 = 1.
 * 偶数的判断方法：出现的次数 n , n%2 = 0,
 * 偶数的统计个数方法： n/2 *2
 * 奇数只统计一次： +1
 *
 * @author xiaobao.chen
 * Create at 2020-05-29
 */
public class HuiWenChuan {

    public static void main(String[] args) {

        System.out.println(huiwen("abba"));
        System.out.println(huiwen("abcba"));
        System.out.println(huiwen("abcdedfba"));

    }

    public static int huiwen(String str) {
        int[] count = new int[128];
        for (char a : str.toCharArray()) {
            count[a]++;
        }

        int length = 0;
        for (int n : count) {
            length += n / 2 * 2;
            if (n % 2 == 1 && length % 2 == 0) {
                length++;
            }
        }
        return length;
    }
}
