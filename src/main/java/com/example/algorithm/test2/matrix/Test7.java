package com.example.algorithm.test2.matrix;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2020/7/20 16:28
 */
public class Test7 {
    /**
     * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，
     * 在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
     *
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     * 测试样例：
     * [[1,2,3],[4,5,6],[7,8,9]],3
     * 返回：[[7,4,1],[8,5,2],[9,6,3]]
     */
    public static void main(String[] args) {
        Test7 test7 = new Test7();
        /**
         * 1    2    3    4
         * 4    6    7    8
         * 9   10   11   12
         * 13  14   15   16
         *
         * 旋转90度
         * 13   9   4   1
         * 14  10   6   2
         * 15  11   7   3
         * 16  12   8   4
         */
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 4, 9, 13};
        array[1] = new int[]{2, 6, 10, 14};
        array[2] = new int[]{3, 7, 11, 15};
        array[3] = new int[]{4, 8, 12, 16};

        int[][] array1=test7.rotate(array);
        for(int i=0;i<array1.length;i++){
            System.out.println(Arrays.toString(array1[i]));
        }

        System.out.println();

        int[][] array3 = new int[6][6];
        array3[0] = new int[]{1, 7, 13, 19, 25, 31};
        array3[1] = new int[]{2, 8, 14, 20, 26, 32};
        array3[2] = new int[]{3, 9, 15, 21, 27, 33};
        array3[3] = new int[]{4, 10, 16, 22, 28, 34};
        array3[4] = new int[]{5, 11, 17, 23, 29, 35};
        array3[5] = new int[]{6, 12, 18, 24, 30, 36};

        int[][] array33 = test7.rotate(array3);
        for (int i = 0; i < array33.length; i++) {
            System.out.println(Arrays.toString(array33[i]));
        }
    }

    /**
     * n*n 阶
     * @param array
     * @return
     */
    private int[][] rotate(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return array;
        }
        //一共多少列
        int cols = array.length;
        // 一共多少行
        int rows = array[0].length;
        if (cols != rows) {
            return array;
        }
        int c = 0, r = 0;
        int right = cols - 1, bottom = cols - 1;
        while (c < right) {
            for (int cIndex = c; cIndex < right; cIndex++) {
                int temp = array[cIndex][r];
                array[cIndex][r] = array[r][cols - 1 - cIndex];
                array[r][cols - 1 - cIndex] = array[cols - 1 - cIndex][cols - 1 - r];
                //array[cols-1-r][cols-1-(cols-1-c)]
                array[cols - 1 - cIndex][cols - 1 - r] = array[cols - 1 - r][cIndex];
                //array[c][r] array[c][cols-1-(cols-1-r)]
                array[cols - 1 - r][cIndex] = temp;
            }
            /**
             * 一次交换完成，再行列各减各自加一继续
             * c r 应该是一半
             */
            right--;
            c++;
            r++;
        }
        return array;
    }
}
