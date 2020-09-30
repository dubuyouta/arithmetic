package com.example.algorithm.test2.dp;

/**
 * @author heshineng
 * created by 2020/9/17
 */
public class Test28 {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * 输入：
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出：3
     * 解释：
     * 长度最长的公共子数组是 [3, 2, 1] 。
     * 变种就是字符串
     */

    public static void main(String[] args) {
        Test28 test28 = new Test28();
        int[] arrayA = {1, 2, 3, 2, 1};
        int[] arrayB = {3, 2, 1, 4, 7};
        System.out.println(test28.findCommonMaxLength(arrayA, arrayB));
        System.out.println(test28.findCommonMaxLength2(arrayA, arrayB));
    }

    public int findCommonMaxLength(int[] arrayA, int[] arrayB) {
        if (arrayA == null || arrayA.length == 0 || arrayB == null || arrayB.length == 0) {
            return 0;
        }
        int[][] array = new int[arrayA.length][arrayB.length];
        int max = 0;
        for (int col = 0; col < arrayA.length; col++) {
            for (int row = 0; row < arrayB.length; row++) {
                if (arrayA[col] == arrayB[row]) {
                    if (col == 0 || row == 0) {
                        array[col][row] = 1;
                    } else {
                        array[col][row] = array[col - 1][row - 1] + 1;
                    }
                    max = Math.max(max, array[col][row]);
                }
            }
        }
        return max;
    }
	
	//转换为一维数组
	public int findCommonMaxLength2(int[] arrayA, int[] arrayB) {
		if (arrayA == null || arrayA.length == 0 || arrayB == null || arrayB.length == 0) {
            return 0;
        }
		int[] array=new int[arrayB.length];
		int max=0;
		for (int col = 0; col < arrayA.length; col++) {
            for (int row = 0; row < arrayB.length; row++) {
                if (arrayA[col] == arrayB[row]) {
                    if (col == 0 || row == 0) {
                        array[row] = 1;
                    } else {
                        array[row] = array[row - 1] + 1;
                    }
                    max = Math.max(max, array[row]);
                }
            }
        }
		return max;
	}
    
}
