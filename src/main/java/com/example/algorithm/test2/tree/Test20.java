package com.example.algorithm.test2.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: heshineng
 * @createdBy: 2020/7/28 11:49
 */
public class Test20 {
    /**
     * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
     *
     * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
     * 考点：二叉搜索树特点
     *          二叉搜索树=二叉查找树
     *          1.	左子树所有结点不大于其父结点 右子树所有结点不小于其父结点 （包括子孙结点）
     *          2.	左右子树也为二叉查找树
     */

    Map<String, AtomicInteger> map=new HashMap<>();

    Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        Test20 test20=new Test20();

    }

    private int get(String key){
        AtomicInteger val=map.get(key);
        if(val==null){
            lock.lock();
            val=map.get(key);
            if(val==null){
                map.put(key,new AtomicInteger(1));
            }
            lock.unlock();
            return map.get(key).get();
        }else{
            return val.incrementAndGet();
        }
    }

    private int treeHeight(int[] vals){
        return 1;

    }
}
