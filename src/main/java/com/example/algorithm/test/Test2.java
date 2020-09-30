package com.example.algorithm.test;


import com.example.arithmetic.arithmeticstu.tree.TreeNode;

import java.util.Arrays;

/**
 * @author: heshineng
 * @createdBy: 2020/7/9 17:18
 */
public class Test2 {
    /**
     * 重建2叉数：
     * 题目 根据前序 和 中序 重建 二叉树
     *  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     *  假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *  例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     *
     *  前序：根左右 中序：左根右
     */

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = test2.reConstructBinaryTree(pre, in);
    }

    /**
     *
     * @param pre 前序  根左右 靠前序确认根，来切分中序，然后递归再各自的分支
     * @param in  中序  左根右
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        int i = 0;
        for (; i < in.length; i++) {
            if (pre[0] == in[i]) {
                break;
            }
        }
        treeNode.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
        treeNode.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
        return treeNode;
    }
}
