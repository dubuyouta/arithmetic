package com.example.algorithm.test1.tree;


import com.example.algorithm.bo.TreeNode;

import java.util.LinkedList;

/**
 * @author: heshineng
 * @createdBy: 2020/5/7 19:14
 */
public class Test38 {

    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     *
     *               4
     *              / \
     *            6     8
     *          /   \  /  \
     *        2     1  3   5
     *                 \
     *                  6
     */

    public static void main(String[] args) {
        Test38 test38 = new Test38();
        TreeNode rootNode = new TreeNode(4);

        TreeNode a = new TreeNode(6);
        rootNode.left = a;
        TreeNode b = new TreeNode(8);
        rootNode.right = b;

        TreeNode c = new TreeNode(2);
        a.left = c;
        TreeNode d = new TreeNode(1);
        a.right = d;
        TreeNode e = new TreeNode(3);
        b.left = e;
        TreeNode f = new TreeNode(5);
        b.right = f;

        TreeNode g = new TreeNode(6);
        f.right = g;

        System.out.println(test38.searchTreeDepth(rootNode));
        System.out.println(test38.searchTreeDepth1(rootNode));


    }

    /**
     * 查找一棵树额深度 使用层序遍历
     *
     * 方法：
     *  使用一个变量记录二叉树的当前层次结点出队的数量
     *  一个变量记录当前层次有多少个节点，记录当前层的总结点数
     * 从根结点开始入队，依次出队，当每一层的所有结点都出队后，深度加1
     * @param rootNode
     * @return
     */
    public int searchTreeDepth(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(rootNode);

        /**
         * depth 二叉树的深度
         * currentLevel 记录当前二叉树所在的层
         * currentLevelNodeNums 记录当前二叉树层的所有结点数
         */
        int depth = 0, currentLevelPopNum = 0, currentLevelNodeNums = 1;
        while (!linkedList.isEmpty()) {
            TreeNode currentNode = linkedList.pop();
            //当前层结点出队，记录+1
            currentLevelPopNum++;
            if (currentNode.left != null) {
                //如果左节点存在，入队
                linkedList.add(currentNode.left);
            }

            if (currentNode.right != null) {
                //如果右节点存在，入队
                linkedList.add(currentNode.right);
            }

            /**
             * 判断当前层的结点是否都 出队数 是否等于 当前层结点总数
             */
            if(currentLevelPopNum==currentLevelNodeNums){
                /**
                 * 当前层的结点都已经出队，深度+1
                 */
                depth++;
                //队列中剩下的结点为下一层所有结点
                currentLevelNodeNums=linkedList.size();
                //将当前层出队数置为0
                currentLevelPopNum=0;
            }
        }
        return depth;
    }

    /**
     * 使用递归算法，来获取二叉树深度
     * 根节点的深度 = 左子树 或 右子树 最大的一个深度 +1
     * @param rootNode
     * @return
     */
    public int searchTreeDepth1(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = searchTreeDepth1(rootNode.left);
        int right = searchTreeDepth1(rootNode.right);
        return Math.max(left, right) + 1;
    }
}
