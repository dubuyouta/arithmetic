package com.example.algorithm.test1.tree;

import com.alibaba.fastjson.JSON;
import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/6/1 14:58
 */
public class Test60 {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *             1   --->
     *           /   \
     *         3      2    <---
     *      /   \   /   \
     *    4     5  6     7  --->
     *  /  \  /  \  \   / \
     * 14 13 12  11 10 9   8  <---
     *       /\            /\
     *      15 16         17 18  --->
     *
     *    按结果输出 1,2,3,4,5,6,7
     */

    public static void main(String[] args) {
        Test60 test60 = new Test60();
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(3);
        root.left = a;
        TreeNode b = new TreeNode(2);
        root.right = b;

        TreeNode c = new TreeNode(4);
        a.left = c;
        TreeNode d = new TreeNode(5);
        a.right = d;
        TreeNode e = new TreeNode(6);
        b.left = e;
        TreeNode f = new TreeNode(7);
        b.right = f;

        TreeNode g = new TreeNode(14);
        c.left = g;
        TreeNode h = new TreeNode(13);
        c.right = h;
        TreeNode i = new TreeNode(12);
        d.left = i;
        TreeNode j = new TreeNode(11);
        d.right = j;
        TreeNode k = new TreeNode(10);
        e.right = k;
        TreeNode l = new TreeNode(9);
        f.left = l;
        TreeNode m = new TreeNode(8);
        f.right = m;

        TreeNode n = new TreeNode(15);
        i.left = n;
        TreeNode o = new TreeNode(16);
        i.right = o;
        TreeNode p = new TreeNode(17);
        m.left = p;
        TreeNode q = new TreeNode(18);
        m.right = q;


        List<List<Integer>> list = test60.printTree(root);
        System.out.println(JSON.toJSONString(list));

    }

    private List<List<Integer>> printTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        list.add(root.val);
        result.add(list);

        list = new ArrayList<>();

        //下一层的添加顺序
        boolean addLeftToRight = false;
        int levelPoolNum = 0, levelSize = 1;
        while (!queue.isEmpty()) {
            //addLeftToRight=true 当前层 从左到右，上一层 从右到左
            TreeNode node = addLeftToRight ? queue.pollFirst() : queue.pollLast();
            levelPoolNum++;

            if (addLeftToRight) {
                //从左到右添加
                if (node.left != null) {
                    queue.addLast(node.left);
                    list.add(node.left.val);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    list.add(node.right.val);
                }
            } else {
                //从右到左
                if (node.right != null) {
                    queue.addFirst(node.right);
                    list.add(node.right.val);
                }
                if (node.left != null) {
                    queue.addFirst(node.left);
                    list.add(node.left.val);
                }
            }

            if (levelPoolNum == levelSize) {
                //一层的元素结束
                addLeftToRight = !addLeftToRight;
                levelPoolNum = 0;
                levelSize = queue.size();
                if(!list.isEmpty()) {
                    result.add(list);
                }
                list = new ArrayList<>();

            }
        }
        return result;
    }



}
