package com.example.algorithm.test3;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author heshineng
 * created by 2020/9/4
 */
public class Test2 {
    /**
     * 最长公共子串  计算两个字符串的最大公共字串的长度，字符不区分大小写。
     *  输入描述：输入两个字符串，分两行输入。
     *  输出描述：输出一个整数
     *
     *  asdfas
     *  werasdfaswer
     *  输出：6
     *
     *   在计算机科学中，最长公共子串问题是寻找两个或多个已知字符串最长的子串。
     *   此问题与最长公共子序列问题的区别在于子序列不必是连续的，而子串却必须是。
     *
     *  str1="123ABCD4567"      str2 = "ABE12345D6"
     *
     * 最长公共子串是：123
     *
     * 最长公共子序列是：123456
     *
     */

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.commonSubString("people", "eplm");
    }

    /**
     * 动态规划：我们用一个二维数组dp[i][j]表示第一个字符串前i个字符和第二个字符串前j个字符组成的最长公共字符串的长度。
     * 那么我们在计算dp[i][j]的时候，我们首先要判断s1.charAt(i)是否等于s2.charAt(j)，
     * 如果不相等，说明当前字符无法构成公共子串，所以dp[i][j]=0。如果相等，
     * 说明可以构成公共子串，我们还要加上他们前一个字符构成的最长公共子串长度，
     * 也就是dp[i-1][j-1]。所以我们很容易找到递推公式
     *
     * if(s1.charAt(i) == s2.charAr(j))
     *     dp[i][j] = dp[i-1][j-1] + 1;
     * else
     *    dp[i][j] = 0;
     *    我们看到在动态规划中，最大值不一定是在最后一个空格内，所以我们要使用一个临时变量在遍历的时候记录下最大值
     *
     *    分析：
     *            p  e   o   p   l   e
     *         e  0  1   0   0   0   1
     *         p  1  0   0   1   0   0
     *         l  0  0   0   0   2   0
     *         m  0  0   0   0   0   0
     *
     */
    private List<String> commonSubString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return Collections.emptyList();
        }
        /**
         * 第一个是按二维数组取值的坐标，第一个代表代表列（纵坐标）
         * 第二个代表行（横坐标）
         */
        //最大子串可能有几个
        List<Integer[]> list = new ArrayList<>();
        int[][] dp = new int[s1.length()][s2.length()];
        for (int col = 0; col < s1.length(); col++) {
            for (int row = 0; row < s2.length(); row++) {
                if (s1.charAt(col) == s2.charAt(row)) {
                    if (col == 0 || row == 0) {
                        dp[col][row] = 1;
                    } else {
                        dp[col][row] = dp[col - 1][row - 1] + 1;
                    }
                } else {
                    dp[col][row] = 0;
                }
                //判断最大值
                dealMax(list, dp, col, row);
            }
        }
        printDp(dp, s1.length(), s2.length());

        List<String> result = findSubStr(dp, list, s1);
        System.out.println(JSON.toJSONString(result));
        return result;
    }

    private List<String> findSubStr(int[][] dp, List<Integer[]> list, String s1) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        Function<Integer[], String> function = item -> {
            StringBuilder builder = new StringBuilder();
            int col = item[0];
            int row = item[1];
            while (col >= 0 && row >= 0) {
                if (dp[col][row] > 0) {
                    builder.insert(0, s1.charAt(col));
                } else {
                    break;
                }
                col--;
                row--;
            }
            return builder.toString();

        };
        List<String> subStringList = list.stream().map(function).filter(item -> !item.isEmpty()).collect(Collectors.toList());
        return subStringList;
    }

    private void printDp(int[][] dp, int colLength, int rowLength) {
        System.out.println();
        for (int row = 0; row < rowLength; row++) {
            StringBuilder builder = new StringBuilder();
            builder.append(" ");
            for (int col = 0; col < colLength; col++) {
                builder.append(" ");
                builder.append(dp[col][row]);
                builder.append(" ");
            }
            System.out.println(builder.toString());
        }

    }

    private void dealMax(List<Integer[]> list, int[][] dp, int col, int row) {
        if (list.isEmpty() && dp[col][row] > 0) {
            list.add(new Integer[]{col, row});
        }
        Iterator<Integer[]> iterator = list.iterator();
        boolean addFlag = false;
        while (iterator.hasNext()) {
            Integer[] next = iterator.next();
            if (dp[next[0]][next[1]] < dp[col][row]) {
                addFlag = true;
                iterator.remove();
            } else if (dp[next[0]][next[1]] == dp[col][row]) {
                addFlag = true;
            }
        }
        if (addFlag) {
            list.add(new Integer[]{col, row});
        }
    }
}
