package com.example.algorithm.test2.graph;

/**
 * @author: heshineng
 * @createdBy: 2020/7/28 11:19
 */
public class Test19 {
    /**
     * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
     *
     * 给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b
     * (请不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)
     *
     * 图的遍历分为深度优先遍历和广度优先遍历，深度优先遍历用堆栈实现，广度优先遍历用队列实现
     *  图的广度优先遍历和树的层次遍历类似，但是不是完全相同，因为图是连通的，所以我们必须去标志那个节点被访问过，
     *  那个节点没有被访问过，最后如果全部访问完以后，还没有找到a到b的路径，则返回false。
     *
     */

    public static void main(String[] args) {
        Test19 test19=new Test19();
    }
}
