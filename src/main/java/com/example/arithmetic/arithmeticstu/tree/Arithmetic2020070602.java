package com.example.arithmetic.arithmeticstu.tree;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020070602 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid - 1);
        treeNode.right = helper(nums, mid + 1, right);

        return treeNode;
    }
}
