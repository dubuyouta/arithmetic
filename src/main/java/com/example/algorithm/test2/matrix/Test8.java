package com.example.algorithm.test2.matrix;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2020/7/23 16:06
 */
public class Test8 {
    /**
     *
     * 请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
     * 给定一个N阶方阵int[][] mat和矩阵的阶数n，
     * 请返回完成操作后的int[][]方阵，保证n小于等于300，
     * 矩阵中的元素为int范围内。
     *
     * 样例：[[1,2,3],[0,1,2],[0,0,1]]
     * 输出  [[0,0,3],[0,0,0],[0,0,0]]
     *
     *  1  0  0
     *  2  1  0
     *  3  2  1
     *
     *  0  0  0
     *  0  0  0
     *  3  0  0
     */

    public static void main(String[] args) {
        Test8 test8 = new Test8();
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 0, 2, 0};
        array[1] = new int[]{3, 4, 0, 5};
        array[2] = new int[]{6, 7, 8, 0};
        array[3] = new int[]{9, 3, 1, 2};
        /**
         *  1  3  6  9
         *  0  4  7  3
         *  2  0  8  1
         *  0  5  0  2
         *
         *  0  0  0  9
         *  0  0  0  0
         *  0  0  0  0
         *  0  0  0  0
         */
        int[][] result = test8.changeZeroFromMatrix1(array, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    /**
     * 首先想到的办法，使用另一个数组存原数组，然后，再改原数据行列变为0.
     * 再想想其他的优化方案
     * 这个的时间复杂度，只有O(m*n)*2
     * 只能在空间复杂度上优化，优化为 O(m*n)
     * @param array
     * @param n
     * @return
     */
    private int[][] changeZeroFromMatrix(int[][] array, int n) {
        if (array == null || array.length == 0
                || array[0].length == 0
                || array.length != array[0].length) {
            return array;
        }
        int[][] temp=new int[n][n];
        for(int c=0;c<n;c++){
            for(int r=0;r<n;r++){
                temp[c][r]=array[c][r];
            }
        }
        for(int c=0;c<n;c++){
            for(int r=0;r<n;r++){
                if(temp[c][r]==0){
                    changeZero(c,r,n,array);
                }
            }
        }
        return array;
    }

    private void changeZero(int c,int r,int n,int[][] array){
        for(int i=0;i<n;i++){
            //列上变为0
            array[c][i]=0;
            //行上变为0
            array[i][r]=0;
        }
    }

    /**
     * 优化使用2个数组，来分别记录行列的问题，只要
     * array[c][r]==0 则 r行必须为0，c列也必须为0
     * 到时候分别检测，行列谁需要为0，变为0就可以了
     * @param array
     * @param n
     * @return
     */
    private int[][] changeZeroFromMatrix1(int[][] array, int n) {
        if (array == null || array.length == 0
                || array[0].length == 0
                || array.length != array[0].length) {
            return array;
        }
        //记录行的为0的 行
        boolean[] rowArray=new boolean[n];
        //记录列的为0的 列
        boolean[] colArray=new boolean[n];
        for(int c=0;c<n;c++){
            for(int r=0;r<n;r++){
                if(array[c][r]==0){
                    //行为0 纵向
                    rowArray[r]=true;
                    //列为0 纵向
                    colArray[c]=true;
                }
            }
        }
        for(int c=0;c<n;c++){
            for(int r=0;r<n;r++){
                if(colArray[c]||rowArray[r]){
                    array[c][r]=0;
                }
            }
        }
        return array;
    }

}
