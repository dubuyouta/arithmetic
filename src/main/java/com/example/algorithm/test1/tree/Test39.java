package com.example.algorithm.test1.tree;

import com.kecies.interview.algorithm.bo.TreeNode;

/**
 * @author: heshineng
 * @createdBy: 2020/5/15 11:15
 */
public class Test39 {

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     *
     * 空树为平衡二叉树
     *
     * 平衡二叉树
     *   1.它的左右两个子树的深度差的绝对值不超过1
     *   2.它的左右两个子树也分别是平衡二叉树
     *
     *   绝对平衡二叉树 = 完全二叉树
     *   首先是一个平衡二叉树，然后 叶子结点 从左到右是连续的
     *
     *  二叉排序树 或 二叉搜索树 或 二叉查找树
     *    1.若左子树不空，则左子树上所有节点的值均小于它的根节点的值
     *    2.若右子树不空，则右子树上所有节点的值均大于它的根节点的值
     *    3.左、右子树也分别为二叉排序树
     *
     *               4
     *              / \
     *            6     8
     *          /   \  /  \
     *        2     1  3   5
     *                 \
     *                  6
     */


    public static void main(String[] args) {
        Test39 test39 = new Test39();

        TreeNode rootNode = new TreeNode(4);

        TreeNode a = new TreeNode(6);
        rootNode.left = a;
        TreeNode b = new TreeNode(8);
        rootNode.right = b;

        TreeNode c = new TreeNode(2);
        a.left = c;
        TreeNode d = new TreeNode(1);
        a.right = d;
        TreeNode e = new TreeNode(3);
        b.left = e;
        TreeNode f = new TreeNode(5);
        b.right = f;

        TreeNode g = new TreeNode(6);
        f.right = g;

        System.out.println(test39.isBalanced1(rootNode));
    }

    /**
     * 判断是否为平衡二叉树
     * 思路：首先根据定义 二叉树左右子树都为平衡二叉树，可使用递归
     *
     * 自己想的
     *
     * @param rootNode
     * @return
     */
    private boolean isBalanced(TreeNode rootNode) {
        if (rootNode == null) {
            return true;
        }
        /**
         * 计算左右子树的高度
         */
        int left = searchTreeDepth(rootNode.left);
        int right = searchTreeDepth(rootNode.right);
        //Math.abs 取绝对值
        if (Math.abs(left - right) <= 1) {
            return isBalanced(rootNode.left) && isBalanced(rootNode.right);
        }
        return false;
    }

    public int searchTreeDepth(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = searchTreeDepth(rootNode.left);
        int right = searchTreeDepth(rootNode.right);
        return Math.max(left, right) + 1;
    }


    /**
     * 上面的方法不够完善，别人精简
     */
    private boolean isBalanced1(TreeNode rootNode) {
        if (rootNode == null) {
            return true;
        }
        /**
         * 计算左右子树的高度
         */
        int left = searchTreeDepth(rootNode.left);
        int right = searchTreeDepth(rootNode.right);
        //Math.abs 取绝对值
        if (Math.abs(left - right) <= 1) {
            return isBalanced(rootNode.left) && isBalanced(rootNode.right);
        }
        return false;
    }

    /**
     * searchTreeDepth1 原来的作用仅为查找树额高度
     * 判断子树为平衡二叉树，就返回子树的高度，如果
     * 子树不为平衡二叉树，就返回 -1 ，结束遍历，代表
     * 这棵树不为平衡二叉树
     * @param rootNode
     * @return
     */
    public int searchTreeDepth1(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = searchTreeDepth1(rootNode.left);
        if (left == -1) {
            return -1;
        }
        int right = searchTreeDepth1(rootNode.right);
        if (right == -1) {
            return -1;
        }
        return (Math.abs(left - right) <= 1) ? (Math.max(left, right) + 1) : -1;
    }


}
