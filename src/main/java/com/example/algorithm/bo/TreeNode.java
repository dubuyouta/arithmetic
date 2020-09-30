package com.example.algorithm.bo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2019/11/22 16:05
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    private int childTreeType;//在根节点的左子树 还是 右子树上 1=左子树 2=右子树

    private String parent;//父节点的一些情况 父->右(3)

    private String childName; //左节点还是右节点 还是根节点 描述 左(2) 右(3)

    private int level;//层级

    public TreeNode(int val){
        this.val=val;
    }

    //层序遍历输出 每一层的结点
    public void print(){
        List<TreeNode> list=new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        this.childName="根("+this.val+")";
        this.level=1;
        linkedList.add(this);

        while (!linkedList.isEmpty()){
            TreeNode nowNode = linkedList.poll();

            list.add(nowNode);

            if (nowNode.left != null) {
                nowNode.left.childName="左("+nowNode.left.val+")";
                nowNode.left.level=nowNode.level+1;
                nowNode.left.parent="[父->"+nowNode.childName+"]";
                if(nowNode.level==1){
                    nowNode.left.childTreeType=1;
                }else{
                    nowNode.left.childTreeType=nowNode.childTreeType;
                }
                linkedList.add(nowNode.left);
            }
            if (nowNode.right != null) {
                nowNode.right.childName="右("+nowNode.right.val+")";;
                nowNode.right.level=nowNode.level+1;
                nowNode.right.parent="[父->"+nowNode.childName+"]";
                if(nowNode.level==1){
                    nowNode.right.childTreeType=2;
                }else{
                    nowNode.right.childTreeType=nowNode.childTreeType;
                }
                linkedList.add(nowNode.right);
            }
        }

        int printLevel=0;
        StringBuilder builder=null;
        for(TreeNode treeNode:list){
            if(treeNode.level!=printLevel){
                if(builder==null){
                    builder=new StringBuilder();
                }else{
                    //先输出上次的结果
                    builder.append("}");
                    System.out.println(builder.toString());
                    builder=new StringBuilder();
                }
                printLevel=treeNode.level;
                builder.append("层级:");
                builder.append(treeNode.level);
                builder.append("  {  ");
            }
            if(treeNode.childTreeType==1){
                builder.append("左根:");
            }else if(treeNode.childTreeType==2){
                builder.append("右根:");
            }
            builder.append(treeNode.childName);
            if(treeNode.parent!=null){
                builder.append(treeNode.parent);
            }

            builder.append("  ");
        }
        //输出 最后一层
        builder.append("}");
        System.out.println(builder.toString());
    }
}
