package com.example.algorithm.test1.tree;

import com.alibaba.fastjson.JSON;
import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/6/1 17:03
 */
public class Test61 {

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *               1
     *             /   \
     *            2     3
     *          /  \   /  \
     *        4    5  6   7
     *
     *        层序遍历，打印数据
     */

    public static void main(String[] args) {
        Test61 test61=new Test61();
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        root.left = a;

        TreeNode b = new TreeNode(3);
        root.right = b;

        TreeNode c = new TreeNode(4);
        a.left = c;
        TreeNode d = new TreeNode(5);
        a.right = d;
        TreeNode e = new TreeNode(6);
        b.left = e;
        TreeNode f = new TreeNode(7);
        b.right = f;

        List<List<Integer>> list = test61.print(root);
        System.out.println(JSON.toJSONString(list));
    }


    private List<List<Integer>> printTree(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return null;
        }
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        result.add(list);
        linkedList.add(root);

        list=new ArrayList<>();
        int levelPollNums=0,levelSize=1;
        while (!linkedList.isEmpty()){
            TreeNode node=linkedList.poll();
            levelPollNums++;
            if(node.left!=null){
                list.add(node.left.val);
                linkedList.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right.val);
                linkedList.add(node.right);
            }
            if(levelPollNums==levelSize){
                levelPollNums=0;
                levelSize=linkedList.size();
                if(!list.isEmpty()) {
                    result.add(list);
                }
                list=new ArrayList<>();
            }
        }
        return result;

    }

    //还有一种递归的写法
    private List<List<Integer> > print(TreeNode pRoot) {
        List<List<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, List<List<Integer>> list) {
        if(root == null) return;
        if(depth > list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
