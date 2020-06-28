package com.example.arithmetic.arithmeticstu.offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * @author xiaobao.chen
 * Create at 2020/6/28
 */
public class offer2020062802 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean exists = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    exists = true;
                    break;
                }
            }
        }
        return exists;
    }

    /**
     * 行：递增的
     * 列：递增的。
     * <p>
     * 通过数组下标的移动，完成线性查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
