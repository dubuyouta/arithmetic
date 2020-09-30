package com.example.algorithm.test1.tree;

import com.alibaba.fastjson.JSON;
import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 15:07
 */
public class Test21 {

    /**
     * 题目：
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     *
     * 思路层序遍历
     * 查看 TreeNode print 方法
     *
     *
     */

    public static void main(String[] args) {
        Test21 test=new Test21();
        //层序
        TreeNode root1 = new TreeNode(1);

        TreeNode a = new TreeNode(3);

        TreeNode b = new TreeNode(5);

        root1.left = a;

        root1.right = b;

        TreeNode c = new TreeNode(8);

        TreeNode d = new TreeNode(4);

        TreeNode e = new TreeNode(2);

        TreeNode f = new TreeNode(10);

        a.left = c;

        b.right = d;

        c.right = e;

        e.left = f;

        root1.print();

        System.out.println();

        System.out.println(JSON.toJSONString(test.printFromTopToBottom(root1)));
    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if(root==null){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()){
            TreeNode now=linkedList.pop();
            list.add(now.val);

            if(now.left!=null){
                linkedList.add(now.left);
            }

            if(now.right!=null){
                linkedList.add(now.right);
            }
        }

        return list;

    }

    /**
     * 也可以使用 list实现 队列
     * @param root
     * @return
     */
    public ArrayList<Integer> printFromTopToBottom1(TreeNode root) {
        if(root==null){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        List<TreeNode> linkedList=new ArrayList<>();
        linkedList.add(root);

        while (!linkedList.isEmpty()){
            //变换此处
            TreeNode now=linkedList.remove(0);
            list.add(now.val);

            if(now.left!=null){
                linkedList.add(now.left);
            }

            if(now.right!=null){
                linkedList.add(now.right);
            }
        }

        return list;

    }


}
