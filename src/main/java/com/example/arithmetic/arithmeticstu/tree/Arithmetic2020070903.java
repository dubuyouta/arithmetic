package com.example.arithmetic.arithmeticstu.tree;

/**
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020070903 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        sum = sum - root.val;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
