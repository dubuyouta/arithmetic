package com.example.arithmetic.arithmeticstu.tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020061501 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.getLeft(), q.getRight()) && check(p.getRight(), q.getLeft());
    }
}
