package com.example.arithmetic.arithmeticstu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020070601 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            ans.add(0, temp);
        }

        return ans;
    }
}
