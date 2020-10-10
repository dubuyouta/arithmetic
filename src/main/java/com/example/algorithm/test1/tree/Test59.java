package com.example.algorithm.test1.tree;


import com.example.algorithm.bo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: heshineng
 * @createdBy: 2020/6/1 11:44
 */
public class Test59 {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *
     *                      6
     *                    /   \
     *                  4      4
     *                /  \    / \
     *               7    5  5   7
     *             /  \   /  \  / \
     *            2   4  1   1 4  2
     *
     */

    public static void main(String[] args) {
        Test59 test59 = new Test59();
        TreeNode root = new TreeNode(6);

        TreeNode a = new TreeNode(4);
        root.left = a;
        TreeNode b = new TreeNode(4);
        root.right = b;

        TreeNode c = new TreeNode(7);
        a.left = c;
        TreeNode d = new TreeNode(5);
        a.right = d;
        TreeNode e = new TreeNode(5);
        b.left = e;
        TreeNode f = new TreeNode(7);
        b.right = f;

        TreeNode g = new TreeNode(2);
        c.left = g;
        TreeNode h = new TreeNode(4);
        c.right = h;
        TreeNode i = new TreeNode(1);
        d.left = i;
        TreeNode j = new TreeNode(1);
        e.right = j;
        TreeNode k = new TreeNode(4);
        f.left = k;
        TreeNode l = new TreeNode(2);
        f.right = l;

        System.out.println(test59.isSymmetricTree1(root));

    }

    /**
     * 判断是否是对称的二叉树，就判断2叉树对应的结点是否相对
     * @param root
     * @return
     */
    private boolean isSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (compareNode(left, right) && left != null) {
            leftQueue.add(left);
            rightQueue.add(right);
        }
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            TreeNode leftQueueNode = leftQueue.poll();
            TreeNode rightQueueNode = rightQueue.poll();
            if (!compareNode(leftQueueNode.left, rightQueueNode.right)) {
                return false;
            }
            if (leftQueueNode.left != null) {
                leftQueue.add(leftQueueNode.left);
                rightQueue.add(rightQueueNode.right);
            }
            if (!compareNode(leftQueueNode.right, rightQueueNode.left)) {
                return false;
            }
            if (leftQueueNode.right != null) {
                leftQueue.add(leftQueueNode.right);
                rightQueue.add(rightQueueNode.left);
            }
        }
        return true;

    }


    private boolean compareNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return true;
        }
        return false;
    }

    //递归做法
    private boolean isSymmetricTree1(TreeNode root) {
        return root == null || compareNode1(root.left, root.right);
    }

    private boolean compareNode1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        } else {
            return compareNode1(left.left, right.right) && compareNode1(left.right, right.left);
        }
    }

}
