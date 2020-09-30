package com.example.algorithm.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: heshineng
 * @createdBy: 2020/7/28 11:46
 */
public class UndirectedGraphNode {

    //无向图

    //结点的标签值
    public int label;

    //从该结点出发，指向的结点的集合
    public List<UndirectedGraphNode> neighbors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndirectedGraphNode that = (UndirectedGraphNode) o;
        return label == that.label &&
                neighbors.equals(that.neighbors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, neighbors);
    }

    /**
     * 有向图
     * 如果在整个图中，只有 a->b 结点的路径
     * 则在a结点来说，neighbors就包含了 b结点
     *
     * 但对于b结点来说，neighbors也包含a结点
     */

    public UndirectedGraphNode(int label){
        this.label=label;
        this.neighbors=new ArrayList<>();
    }
}
