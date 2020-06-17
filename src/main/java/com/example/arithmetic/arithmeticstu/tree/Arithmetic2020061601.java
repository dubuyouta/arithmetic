package com.example.arithmetic.arithmeticstu.tree;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020061601 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
