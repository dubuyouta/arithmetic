package com.example.algorithm.test1.tree;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 15:07
 */
public class Test22 {
    /**
     * 题目 二叉搜索数的后序遍历
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * 考点：二叉搜索树特点
     *       二叉搜索树=二叉查找树
     *      1.	左子树所有结点不大于其父结点 右子树所有结点不小于其父结点 （包括子孙结点）
     *      2.	左右子树也为二叉查找树
     *
     *     后序遍历？
     *     左->右->根
     *
     *     思路 ：1.假设是后序遍历，将还原成二叉搜索数，判断特性
     *            可能有几种树，全部判断 可能行不通
     *
     *            找二叉树的特点判断
     *
     *            因为条件：假设输入的数组的任意两个数字都互不相同。
     *           思路一： 根节点所有 左子树的序列都比 根节点小 所有右子树结点都比它大
     *
     *           后序特性 左右根  所以 中间分隔点 比根节点小 都在前半部分 左子树
     *                   根节点比大的 都在右半部分 需要比它大
     *           所以 从数组 最后一个找到 根节点 然后 判断数组前半部分是否都小于根节点
     *
     *           数组 右半部分是否都大于根节点
     *
     *           如果符合 切分 左右 2个子树继续递归 直到完后为止
     *
     *
     *
     */

    public static void main(String[] args) {
        Test22 test = new Test22();
        int[] array = {4, 3, 6, 7, 5, 11, 13, 12, 16, 17, 15, 10};
        System.out.println(test.verifySequenceOfBST(array));
    }

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        //取出根节点
        int root = sequence[sequence.length - 1];
        //找到第一个比root大的下标
        int spiltIndex = -1;
        /**
         * 判断有问题
         */
        for (int i = 0; i < sequence.length - 1; i++) {
            /**
             * 验证是否前半部分比它小 后半部分部分全比它大
             */
            if (spiltIndex == -1 && sequence[i] > root) {
                //第一个分隔点找到
                spiltIndex = i;
            }
            if (spiltIndex != -1 && i >= spiltIndex) {
                //已经找到分隔点，说明整个点前面的数都比root下，后面的数就需要比root，否则就要返回false
                if (sequence[i] < root) {
                    return false;
                }
            }
        }
        if (spiltIndex == -1) {
            //说明只有左子树，都比root下
            return verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, sequence.length - 1));
        }
        if (spiltIndex == 0) {
            //说明数组前面数 都是右子树，都比root大
            return verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, sequence.length - 1));
        }
        //然后是中间值，需要分割递归 分割成左右子树分别递归
        return verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, spiltIndex))
                && verifySequenceOfBST(Arrays.copyOfRange(sequence, spiltIndex, sequence.length - 1));

    }
}
