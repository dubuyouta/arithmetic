package com.example.algorithm.test1.array;

/**
 * @author heshineng
 * created by 2020/9/11
 */
public class Test74 {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
     * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     *
     * 输出：49
     *
     * 实际求，2条线顶点 横坐标差 * min（顶点）面积最大值
     * 思路：使用双指针法，要面积大，首先长和宽都要长
     *       首先横坐标的宽最长是在，表现出数组下标差值越大，长度越长
     *
     *       纵坐标以短的为准，一方面要找最高的，一方面要找2个差值最小的
     *
     *       所以当坐标小的向中间靠近，每次记录面积的差值
     *
     *
     */

    public static void main(String[] args) {
        Test74 test74 = new Test74();
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(test74.maxArea(array));
    }

    private int maxArea(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length - 1;
        int maxAreaNum = 0;
        while (left < right) {
            int area = Math.min(array[left], array[right])*(right-left);
            maxAreaNum = Math.max(area, maxAreaNum);
            if (array[left] >= array[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxAreaNum;
    }
}
