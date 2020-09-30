package com.example.algorithm.test1.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/6/8 18:16
 */
public class Test68 {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     *
     * 理解错了题意，必须是连续向上 下，左 右 移动，每次移动一格，还是递归回溯法。
     */

    public static void main(String[] args) {
        Test68 test68 = new Test68();
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("3333");
        list.add("4444");
//        for(int i=0;i<list.size();i++){
//            list.remove(list.get(i));
//        }
//        for(String str:list){
//            list.remove(str);
//        }
//        System.out.println(test68.numSum(365));
//        System.out.println(test68.numSum1(365));

        int[][] array = new int[20][25];//4列3行，坐标就以二维数组为下标
        System.out.println(test68.visitSquareNum(array, 8));
        System.out.println(test68.movingCount(array, 8));
    }

    public int movingCount(int[][] visited, int threshold) {
        return helper(0, 0, visited.length, visited[0].length, visited, threshold);
    }

    private int helper(int c, int r, int cols, int rows, int[][] visited, int threshold) {
        if (c < 0 || c >= cols || r < 0 || r >= rows || numSum(c) + numSum(r) > threshold || visited[c][r] == 1)
            return 0;
        visited[c][r] = 1;
        return helper(c - 1, r, cols, rows, visited, threshold)
                + helper(c + 1, r, cols, rows, visited, threshold)
                + helper(c, r - 1, cols, rows, visited, threshold)
                + helper(c, r + 1, cols, rows, visited, threshold)
                + 1;
    }

    /**
     * 思路一：二维数组全部全部遍历一遍，其他方式在这个基础上优化
     * 暴力破解
     */
    private int visitSquareNum(int[][] array, int k) {
        if (array == null || array.length == 0 || k < 0) {
            return 0;
        }
        int count = 0;
        for (int cols = 0; cols < array.length; cols++) {
            for (int rows = 0; rows < array[0].length; rows++) {
                if (numSum(cols) + numSum(rows) <= k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 0-9 横纵坐标，以10个数位分界线，界线内是单调递增的
     * @param array
     * @param k
     * @return
     */
    private int visitSquareNum1(int[][] array, int k) {
        if (array == null || array.length == 0 || k < 0) {
            return 0;
        }
        //数组最大的列
        int maxCols = array.length;
        //数组最大的行
        int maxRows = array[0].length;
        //最初开始的列 行
        int startCol = 0, startRow = 0;
        int count = 0;
        //以10开始自增
        while (startCol < maxCols && startRow < maxRows) {
            int endCol = startCol + 10;
            endCol = endCol > maxCols ? maxCols : endCol;
            int endRow = startRow + 10;
            endRow = endRow > maxRows ? maxRows : endRow;

            /**
             * 总共有3种情况，
             * 1.范围内的方格全部满足
             * 2.全部不满足
             * 3.范围内部分满足
             *
             * 如果找到相等的数，可以得到2个数组下标
             * [c,0] [0,r]
             */

            //先从列开始找 横向 移动
            int c = startCol;
            for (; c < endCol; c++) {
                if (numSum(c) == k) {
                    //找到列对应相等的数
                    break;
                }
            }
            //再从行开始找，纵向找
            int r = startRow;
            for (; r < endRow; r++) {
                if (numSum(r) == k) {
                    //找到列对应相等的数
                    break;
                }
            }

            /**
             * 找到后需要统计方格数量
             * 可以按行统计，也可以按列统计
             * 我们行统计每一行的个数
             */
            for (int col = c, row = 0; col >= 0 && row <= r; col--, row++) {
                //按行统计计数
                count += (col - startCol + 1);
            }

            //下次循环 再次偏移，开始位置
            startCol = endCol;
            startRow = endRow;
        }
        System.out.println(startCol);
        System.out.println(startRow);
        return count;
    }

    /**
     * 首先求一个数的数位和的方式
     */
    private int numSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    private int numSum1(int n) {
        int sum = 0;
        int mod = 10;
        int divisor = 1;
        while (n > divisor) {
            int x = n % mod;
            sum += x / divisor;
            mod *= 10;
            divisor *= 10;
        }
        return sum;
    }
}
