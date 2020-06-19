package com.example.arithmetic.arithmeticstu.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020061901 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        int deepLength = deepth(root);

        for (int i = 1; i <= deepLength; i++) {
            leverOrder(root, i, lists);
        }
        Collections.reverse(lists);
        return lists;
    }

    public static void leverOrder(TreeNode root, int level, List<List<Integer>> lists) {
        if (root == null || level < 1) {
            return;
        }
        if (level == 1) {
            lists.get(level).add(root.val);
            return;
        }
        leverOrder(root.left, level - 1, lists);
        leverOrder(root.right, level - 1, lists);
    }

    public static int deepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = deepth(root.left);
        int r = deepth(root.right);

        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
