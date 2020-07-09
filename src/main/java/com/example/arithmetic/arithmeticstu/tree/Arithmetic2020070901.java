package com.example.arithmetic.arithmeticstu.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 前序遍历：根节点--->左节点--->右节点
 * 中序遍历：左节点--》根节点---》右节点
 *
 * @author xiaobao.chen
 * Create at 2020/4/24
 */
public class Arithmetic2020070901 {

    Map<Integer, Integer> inorderMap = new HashMap<>();

    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        /**存储数据在中序遍历中的位置*/
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return reBuild(0, 0, inorder.length - 1);
    }

    /**
     * @param pre_root_idx 前序遍历的位置
     * @param in_left_idx 中序遍历的左边节点位置
     * @param in_right_idx 中序遍历的右边节点的位置
     * @return
     */
    public TreeNode reBuild(int pre_root_idx, int in_left_idx, int in_right_idx) {

        if (in_left_idx > in_right_idx) {
            return null;
        }
        System.out.println(pre_root_idx);
        /**根节点*/
        TreeNode root = new TreeNode(preorder[pre_root_idx]);

        /**根节点在中序遍历中的位置*/
        int idx = inorderMap.get(preorder[pre_root_idx]);
        /**
         * 左节点：
         *
         * pre_root_idx + 1：左节点在前序遍历中，在根节点的后面的位置
         * in_left_idx：中序遍历的起始位置
         * idx - 1：左节点在中序遍历中，在根节点的的前面的位置
         * */
        root.left = reBuild(pre_root_idx + 1, in_left_idx, idx - 1);
        /**
         * 右节点：
         *
         * pre_root_idx+ (idx - 1 - in_left_idx +1) +1: 右节点在前序遍历中的位置 --当前节点+左节点的长度
         * idx - 1 - in_left_idx +1：根节点对应的左边的节点的长度。
         * idx + 1：右节点在中序遍历中根节点的右边位置
         * in_right_idx:右节点最后的位置
         * */
        root.right = reBuild(pre_root_idx + idx - in_left_idx + 1, idx + 1, in_right_idx);
        return root;
    }
}
