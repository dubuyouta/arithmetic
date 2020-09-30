package com.example.algorithm.test1.tree;

import com.kecies.interview.algorithm.bo.TreeNode;

import java.util.*;

/**
 * @author: heshineng
 * @createdBy: 2020/6/1 17:38
 */
public class Test62 {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     *
     * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
     * 从而使得内存中建立起来的二叉树可以持久保存。
     * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
     * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
     *
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     *
     * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
     *
     *
     *                1
     *              /   \
     *            2      3
     *            \     / \
     *            4    5   6
     *
     */

    public static void main(String[] args) {
        Test62 test62 = new Test62();

        TreeNode root = new TreeNode(1);

        TreeNode a = new TreeNode(2);
        root.left = a;

        TreeNode b = new TreeNode(3);
        root.right = b;

        TreeNode c = new TreeNode(4);
        a.right = c;
        TreeNode e = new TreeNode(5);
        b.left = e;
        TreeNode f = new TreeNode(6);
        b.right = f;

        String levelSequenceSerializeStr=test62.levelSequenceSerialize(root);
        String levelSequenceSerialize1Str=test62.levelSequenceSerialize1(root);
        System.out.println(levelSequenceSerializeStr);
        System.out.println(levelSequenceSerialize1Str);

        TreeNode treeNode=test62.levelSequenceDeserialization(levelSequenceSerializeStr);
        treeNode.print();

        System.out.println();
        String preOrderTraversalSerializeStr=test62.preOrderTraversalSerialize(root);
        System.out.println(preOrderTraversalSerializeStr);

        TreeNode treeNode1=test62.preOrderTraversalDeserialization1(preOrderTraversalSerializeStr);
        treeNode1.print();
    }

    /**
     * 层序遍历的序列化和反序列化最简单
     * 层序
     *
     * 空节点使用 # 代替，中间以逗号分隔
     *
     * 层序遍历有直接遍历和递归2种
     * 此为非递归做法
     */
    private String levelSequenceSerialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append("#");
            return stringBuilder.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        stringBuilder.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null) {
                stringBuilder.append(",#");
            } else {
                stringBuilder.append(",");
                stringBuilder.append(node.left.val);
                queue.add(node.left);
            }

            if (node.right == null) {
                stringBuilder.append(",#");
            } else {
                stringBuilder.append(",");
                stringBuilder.append(node.right.val);
                queue.add(node.right);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 层序遍历 递归的方式
     */
    private String levelSequenceSerialize1(TreeNode root) {
        List<StringBuilder> list=new ArrayList<>();
        levelSequenceSerialize1Dfs(root,1,list);
        StringBuilder result=list.get(0);
        if(list.size()>1){
            for(int i=1;i<list.size();i++){
                StringBuilder temp=list.get(i);
                result.append(temp);
            }
        }
        result.deleteCharAt(result.lastIndexOf(","));
        return result.toString();
    }

    private void levelSequenceSerialize1Dfs(TreeNode root, int depth, List<StringBuilder> list){
        if(depth > list.size()) {
            list.add(new StringBuilder());
        }
        if(root==null){
            list.get(depth -1).append("#,");
            return ;
        }
        list.get(depth -1).append(root.val);
        list.get(depth -1).append(",");
        levelSequenceSerialize1Dfs(root.left, depth + 1, list);
        levelSequenceSerialize1Dfs(root.right, depth + 1, list);

    }

    /**
     * 层序遍历的反序列化
     * @param val
     * @return
     */
    private TreeNode levelSequenceDeserialization(String val) {
        if(val==null||val==""){
            return null;
        }
        String[] array=val.split(",");
        if(array==null||array.length==0){
            return null;
        }
        //根节点
        String rootVal=array[0];
        if("#".equals(rootVal)){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(rootVal));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()&&i<array.length){
            TreeNode node=queue.poll();
            String leftVal=array[i++];
            if(!"#".equals(leftVal)){
                TreeNode left=new TreeNode(Integer.parseInt(leftVal));
                node.left=left;
                queue.add(left);
            }
            String rightVal=array[i++];
            if(!"#".equals(rightVal)){
                TreeNode right=new TreeNode(Integer.parseInt(rightVal));
                node.right=right;
                queue.add(right);
            }
        }
        return root;
    }

    /**
     * 使用先序遍历 根左右，递归方式,不使用递归方式实现不了
     */
    private String preOrderTraversalSerialize(TreeNode root){
        StringBuilder builder=new StringBuilder();
        if(root==null){
            builder.append("#");
            return builder.toString();
        }
        builder.append(root.val);
        builder.append(",");
        builder.append(preOrderTraversalSerialize(root.left));
        builder.append(",");
        builder.append(preOrderTraversalSerialize(root.right));
        return builder.toString();
    }

    private TreeNode preOrderTraversalDeserialization(String val){
        if(val==null||val==""){
            return null;
        }
        String[] array=val.split(",");
        if(array==null||array.length==0){
            return null;
        }
        //根节点
        String rootVal=array[0];
        if("#".equals(rootVal)){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode[] treeNodes = new TreeNode[array.length];
        for(int i=0; i<array.length; i++){
            if(!array[i].equals("#"))
                treeNodes[i] = new TreeNode(Integer.valueOf(array[i]));
        }
        stack.push(treeNodes[0]);
        int i = 1;
        while(treeNodes[i] != null){
            stack.peek().left = treeNodes[i];
            stack.push(treeNodes[i++]);
        }
        while(!stack.isEmpty()){
            stack.pop().right = treeNodes[++i];
            if(treeNodes[i] != null){
                stack.push(treeNodes[i++]);
                while(treeNodes[i] != null){
                    stack.peek().left = treeNodes[i];
                    stack.push(treeNodes[i++]);
                }
            }
        }
        return treeNodes[0];
    }

    int index =-1;
    private TreeNode preOrderTraversalDeserialization1(String str) {
        index++;
        int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = preOrderTraversalDeserialization1(str);
            node.right = preOrderTraversalDeserialization1(str);
        }
        return node;
    }


}
