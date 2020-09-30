package com.example.algorithm.test2.tree;

import com.alibaba.fastjson.JSON;
import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author heshineng
 * created by 2020/9/17
 */
public class TreeAll {
    /**
     * 所有的树遍历方式
     */

    public static void main(String[] args) {
        TreeAll tree = new TreeAll();
        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        root.left = a;
        TreeNode b = new TreeNode(3);
        root.right = b;

        TreeNode c = new TreeNode(4);
        a.left = c;
        TreeNode d = new TreeNode(5);
        b.left = d;
        TreeNode e = new TreeNode(6);
        b.right = e;

        System.out.println("先序非递归：" + JSON.toJSONString(tree.preOrderTraversal(root)));
        System.out.println("先序非递归1：" + JSON.toJSONString(tree.preOrderTraversal1(root)));
        System.out.println("先序递归：" + JSON.toJSONString(tree.preOrderTraversalByRecursion(root)));
        System.out.println();
        System.out.println("中序非递归：" + JSON.toJSONString(tree.inOrderTraversal(root)));
        System.out.println("中序递归：" + JSON.toJSONString(tree.inOrderTraversalByRecursion(root)));
        System.out.println();
        System.out.println("后序非递归：" + JSON.toJSONString(tree.postOrderTraversal(root)));
        System.out.println("后序非递归1：" + JSON.toJSONString(tree.postOrderTraversal2(root)));
        System.out.println("后序递归：" + JSON.toJSONString(tree.postOrderTraversalByRecursion(root)));
        System.out.println();
        System.out.println("层序非递归：" + JSON.toJSONString(tree.levelOrderTraversal(root)));
        System.out.println("层序递归：" + JSON.toJSONString(tree.levelOrderTraversalByRecursion(root)));
    }

    //先序遍历，非递归方式 根左右
    private List<Integer> preOrderTraversal(TreeNode root) {
		if(root==null){
			return null;
		}
		List<Integer> list=new ArrayList<>();
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node=stack.pop();
			list.add(node.val);
			TreeNode right=node.right;
			if(right!=null){
				stack.push(right);
			}
			TreeNode left=node.left;
			if(left!=null){
				stack.push(left);
			}
		}
		return list;

    }

    //先序遍历 ,非递归方式2
    private List<Integer> preOrderTraversal1(TreeNode root) {
        return null;
    }

    //先序遍历，递归方式
    private List<Integer> preOrderTraversalByRecursion(TreeNode root) {
           return null;
    }

    //中序遍历，非递归方式
    private List<Integer> inOrderTraversal(TreeNode root) {
         return null;
    }

    //中序遍历，递归方式
    private List<Integer> inOrderTraversalByRecursion(TreeNode root) {
        return null;
    }

    private void inOrderTraversalByRecursion(TreeNode root, List<Integer> list) {

    }

    //后序遍历，非递归方式  这种方式没写出来
    private List<Integer> postOrderTraversal(TreeNode root) {
        return null;
    }

    //后序遍历，非递归方式1  这种方式没写出来
    private List<Integer> postOrderTraversal2(TreeNode root) {
		return null;

    }

    //后序遍历，递归方式 字面理解 左根右
    private List<Integer> postOrderTraversalByRecursion(TreeNode root) {
		return null;

    }

    private void postOrderTraversalByRecursion(TreeNode root, List<Integer> list) {

    }

    //层序遍历，非递归方式
    private List<Integer> levelOrderTraversal(TreeNode root) {
		return null;

    }

    //层序遍历，递归方式
    private List<Integer> levelOrderTraversalByRecursion(TreeNode root) {
		return null;

    }

    private void levelOrderTraversalByRecursion(List<List<Integer>> tempList, TreeNode root, int level) {
		

    }
}
