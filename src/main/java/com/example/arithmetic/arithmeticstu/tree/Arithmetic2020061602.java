package com.example.arithmetic.arithmeticstu.tree;

/**
 * https://leetcode-cn.com/problems/same-tree/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020061602 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
