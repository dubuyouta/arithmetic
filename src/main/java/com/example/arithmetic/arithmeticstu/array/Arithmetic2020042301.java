package com.example.arithmetic.arithmeticstu.array;

/**
 * @author xiaobao.chen
 * Create at 2020/4/22
 */
public class Arithmetic2020042301 {

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(findNumberIn2DArray(nums, 10));
        System.out.println("end:" + System.currentTimeMillis());
        System.out.println(findNumberIn2DArray1(nums, 10));
        System.out.println("end:" + System.currentTimeMillis());
    }

    /**
     * 空间复杂度 O(1)
     * 时间复杂度 O(n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        System.out.println("start:" + System.currentTimeMillis());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 空间复杂度 O(1)
     * 时间复杂度 O(n)
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        System.out.println("start:" + System.currentTimeMillis());
        int row = 0;
        int line = matrix[0].length - 1;
        while (row < matrix.length && line >= 0) {
            int num = matrix[row][line];
            if (num == target) {
                return true;
            } else if (num > target) {
                line--;
            } else {
                row++;
            }
        }
        return false;
    }
}
