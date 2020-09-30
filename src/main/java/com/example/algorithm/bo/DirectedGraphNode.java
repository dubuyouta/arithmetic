package com.example.algorithm.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: heshineng
 * @createdBy: 2020/7/28 11:41
 */
public class DirectedGraphNode {

    //有向图

    //结点的标签值
    public int label;

    //从该结点出发，指向的结点的集合
    public List<DirectedGraphNode> neighbors;

    /**
     * 有向图
     * 如果在整个图中，只有 a->b 结点的路径
     * 则在a结点来说，neighbors就包含了 b结点
     *
     * 但对于b结点来说，neighbors不包含a结点
     */

    public DirectedGraphNode(int label){
        this.label=label;
        this.neighbors=new ArrayList<>();
    }
}
