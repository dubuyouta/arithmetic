package com.example.algorithm.bo;

/**
 * @author: heshineng
 * @createdBy: 2020/7/28 11:37
 */
public class Graph {
    /**
     *图的表示通常使用邻接矩阵和邻接表，
     * 前者易实现但是对于稀疏矩阵会浪费较多空间，后者使用链表的方式存储信息但是对于图搜索时间复杂度较高。
     *
     * 邻接矩阵
     * 设顶点个数为 V, 那么邻接矩阵可以使用 V × V 的二维数组来表示。
     *
     *   Java Definition
     *
     *   int[][] g = new int[V][V]
     *   g[i][j]
     *  表示顶点i和顶点j的关系，对于无向图可以使用0/1表示是否有连接，
     *  对于带权图则需要使用INF来区分。有重边时保存边数或者权值最大/小的边即可。
     *
     *  邻接表
     * 邻接表通过表示从顶点i出发到其他所有可能能到的边。
     *
     * 有向图
     * class DirectedGraphNode {
     *     int label;
     *     ArrayList<DirectedGraphNode> neighbors;
     *     DirectedGraphNode(int x) {
     *         label = x;
     *         neighbors = new ArrayList<DirectedGraphNode>();
     *     }
     * }
     *
     * 无向图同上，只不过在建图时双向同时加
     * class UndirectedGraphNode {
     *     int label;
     *     ArrayList<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) {
     *         this.label = x;
     *         this.neighbors = new ArrayList<UndirectedGraphNode>();
     *     }
     * }
     *
     */
}
