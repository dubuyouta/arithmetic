package com.example.arithmetic.arithmeticstu.tree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020070603 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int l = deepth(root.left);
        int r = deepth(root.right);
        return Math.abs(l - r) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int deepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = deepth(node.left);
        int r = deepth(node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
