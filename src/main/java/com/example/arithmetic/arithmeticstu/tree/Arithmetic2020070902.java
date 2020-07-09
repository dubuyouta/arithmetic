package com.example.arithmetic.arithmeticstu.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 * 中序遍历：左节点--》根节点---》右节点
 * 后序遍历：左节点--》右节点--》根节点
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020070902 {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;

        /**存储数据在中序遍历中的位置*/
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return reBuild(postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param post_root_idx 后序遍历的位置
     * @param in_left_idx 中序遍历的左边节点位置
     * @param in_right_idx 中序遍历的右边节点的位置
     * @return
     */
    public TreeNode reBuild(int post_root_idx, int in_left_idx, int in_right_idx) {

        if (in_left_idx > in_right_idx) {
            return null;
        }

        System.out.println(post_root_idx);
        /**根节点*/
        TreeNode root = new TreeNode(postorder[post_root_idx]);

        /**根节点在中序遍历中的位置*/
        int idx = inorderMap.get(postorder[post_root_idx]);

        root.left = reBuild(post_root_idx - in_right_idx + idx - 1, in_left_idx, idx - 1);

        root.right = reBuild(post_root_idx - 1, idx + 1, in_right_idx);

        return root;
    }
}
