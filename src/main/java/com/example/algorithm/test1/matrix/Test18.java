package com.example.algorithm.test1.matrix;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 1:27
 */
public class Test18 {
    /**
     * 题目：
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     *  例如，如果输入如下4 X 4矩阵：
     *                             1    2    3    4
     *                             5    6    7    8
     *                             9    10   11   12
     *                             13   14   15   16
     *
     *       则依次打印出数字      1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     *
     *       思路 定义四个指针 作为 数组的 上下左右临界值
     *
     *       对上下左右的指针做移动
     *       top bottom left right
     *
     *       顺序  left->right 完成 top+1
     *             top->bottom 完成 right-1
     *             right->left 完成 bottom-1
     *             bottom->top 完成 left+1
     *
     *             这个作为一个循环序列，每次移动完一个序列 就是 一个指针移动
     *             这个指针是下一个 移动起始点
     */

    public static void main(String[] args) {
        Test18 test = new Test18();

        int[][] matrix = new int[4][4];
        /**
         *  1    2    3    4
         *  5    6    7    8
         *  9    10   11   12
         *  13   14   15   16
         */
        //第一列
        matrix[0] = new int[]{1, 5, 9, 13};
        matrix[1] = new int[]{2, 6, 10, 14};
        matrix[2] = new int[]{3, 7, 11, 15};
        matrix[3] = new int[]{4, 8, 12, 16};

        System.out.println(JSON.toJSONString(test.printMatrix(matrix)));

    }

    /**
     * 定义四个指针
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int cols = matrix.length;
        if (cols == 0) {
            return null;
        }
        /**
         * 错误一 有定义出问题
         */
        //int rows = matrix.length;
        int rows = matrix[0].length;
        if (rows == 0) {
            return null;
        }
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;
        ArrayList<Integer> arrayList=new ArrayList<>();
        //不用特殊判断，下面的已经包含
//        if(left==right){
//            //只有一列
//            int[] result=matrix[0];
//            for(int i=0;i<result.length;i++){
//                arrayList.add(result[i]);
//            }
//            return arrayList;
//        }
//
//        if(top==bottom){
//            //只有一行
//            for(int i=0;i<cols;i++){
//                arrayList.add(matrix[i][0]);
//            }
//            return arrayList;
//        }
        //横向指针
        int h=0;
        //纵向指针
        int v=0;
        /**
         * 错误2，在这个里面需要做判断
         */
        //while (left<right||top<bottom){
        while (left<=right&&top<=bottom){
            /**
             * 定义2个移动指针 一个 横向 一个纵向
             * int h=left,v=top
             */


           // 从 左->右  top+1
            /**
             * 错误三 这里每次 要初始化 2个变量 h v
             *
             * 下同，给个循环都需要定义 2个变量
             *
             * 防止自加过量，导致下次循环越界
             *
             * 也可以在程序里面判断
             *
             * 如果 h 和v 定义在里面就不用重复判断
             */
            //for(h=left;h<=right;h++){
            for(h=left,v=top;h<=right;h++){
                arrayList.add(matrix[h][v]);
            }
            top++;

            //从 上到下  right-1
            for(h=right,v=top;v<=bottom;v++){
                arrayList.add(matrix[h][v]);
            }
            right--;

            //从 右到左 bottom-1
            for(h=right,v=bottom;h>=left;h--){
                arrayList.add(matrix[h][v]);
            }
            bottom--;

            //从 下到上 left++
            for(h=left,v=bottom;v>=top;v--){
                arrayList.add(matrix[h][v]);
            }
            left++;
        }
        return arrayList;
    }

}
