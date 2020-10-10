package com.example.algorithm.test1.tree;

import com.alibaba.fastjson.JSON;
import com.example.algorithm.bo.TreeNode;

import java.util.ArrayList;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 15:07
 */
public class Test23 {
    /**
     * 题目：
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和  为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * (注意: 在返回值的list中，数组长度大的数组靠前)
     *
     * 就是 将2叉数所有路径全部答应出来，并且 满足条件
     *
     *     例如 输入 15
     *                      1
     *                    /   \
     *                  3      5
     *                /  \    /  \
     *              6    11  3    4
     *            /              / \
     *           5              2   5
     *                          \
     *                           3
     */

    public static void main(String[] args) {
        Test23 test =new Test23();

        TreeNode root=new TreeNode(1);

        TreeNode a=new TreeNode(3);
        root.left=a;
        TreeNode b=new TreeNode(5);
        root.right=b;

        TreeNode c=new TreeNode(6);
        a.left=c;
        TreeNode d=new TreeNode(11);
        a.right=d;
        TreeNode e=new TreeNode(3);
        b.left=e;
        TreeNode f=new TreeNode(4);
        b.right=f;

        TreeNode g=new TreeNode(5);
        c.left=g;
        TreeNode h=new TreeNode(2);
        f.left=h;
        TreeNode i=new TreeNode(5);
        f.right=i;

        TreeNode j=new TreeNode(3);
        h.left=j;

        ArrayList<ArrayList<Integer>> list=test.findPath(root,15);
        for(ArrayList<Integer> item:list){
            System.out.println(JSON.toJSONString(item));
        }

    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        if(root==null)return paths;
        find(paths,new ArrayList<>(),root,target);
        //对list排序
        paths.sort((item1,item2)->item2.size()-item1.size());
        return paths;
    }

    /**
     * 这个问题没有想出来，以后再看看
     */

    public void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(target==root.val){
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> newPath=new ArrayList<>(path);
        if(root.left!=null)find(paths,path,root.left,target-root.val);
        if(root.right!=null)find(paths,newPath,root.right,target-root.val);
    }

}
