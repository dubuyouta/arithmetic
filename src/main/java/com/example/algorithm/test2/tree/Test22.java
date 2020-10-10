package com.example.algorithm.test2.tree;


import com.example.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author heshineng
 * created by 2020/9/14
 */
public class Test22 {

    /**
     *二叉树打印每一行的最大值
     * 如：   1
     *      /   \
     *     3     2
     *   /  \     \
     *  5   3      9
     *
     *  输出 1 3 9
     *
     *  首先可以使用BFS，广度优先搜索，即层序遍历
     *
     */

    public static void main(String[] args) {
        Test22 test22 = new Test22();

        TreeNode rootNode = new TreeNode(1);

        TreeNode a = new TreeNode(3);
        rootNode.left = a;
        TreeNode b = new TreeNode(2);
        rootNode.right = b;

        TreeNode c = new TreeNode(5);
        a.left = c;
        TreeNode d = new TreeNode(3);
        a.right = d;

        TreeNode e = new TreeNode(9);
        b.right = e;


        System.out.println(test22.levelOrderTraversal(rootNode));
        System.out.println(test22.dfs(rootNode));
    }

    /**
     * BFS
     * 层序遍历，一层层遍历，首先需要借助LinkList
     * 其次，需要算清楚每一层元素的个数
     */
    private List<Integer> levelOrderTraversal(TreeNode rootNode) {
        if (rootNode == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            //每次开始添加新的数据之前，就是上一层队列的数据，就是该层的size
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode treeNode = queue.poll();
                max = Math.max(treeNode.val, max);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            list.add(max);
        }
        return list;
    }

    /**
     * DFS 也可以深度遍历 深度优先搜索
     */
    private List<Integer> dfs(TreeNode rootNode) {
        if (rootNode == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        helper(rootNode, list, 1);
        return list;
    }

    /**
     *
     * @param node
     * @param list
     * @param level 代表当前的层级
     */
    private void helper(TreeNode node, List<Integer> list, int level) {
        if (node == null) {
            return;
        }
        if (level == list.size() + 1) {
            //说明走到下一层，先将这个数据加入集合
            list.add(node.val);
        } else {
            //在当前层数据操作，进行最大数据替换
            list.set(level - 1, Math.max(list.get(level - 1), node.val));
        }
        //前序遍历 根左右
        helper(node.left, list, level + 1);
        helper(node.right, list, level + 1);
    }


}
