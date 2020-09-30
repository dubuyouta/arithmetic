package com.example.algorithm.test1.link;

import com.kecies.interview.algorithm.bo.RandomListNode;

/**
 * @author: heshineng
 * @createdBy: 2019/11/23 20:53
 */
public class Test24 {
    /**
     * 题目 ：复杂链表的复制
     *    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     *     另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     *     （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     *     链表复制问题
     *     主要增加一个随机的结点
     *
     *     题目有个隐含条件，就是随机结点 是指 head->next->最后 其中已经存在某一个结点，并非是一个完全割裂的结点
     */

    public static void main(String[] args) {
        Test24 test =new Test24();

    }

    /**
     * 没想出来，再看看
     *
     *解题思路：
     * 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     * 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     * 3、拆分链表，将链表拆分为原链表和复制后的链表
     *
     *  第一步就是将所有的新结点new 出来，插入原链表的好处，知道对应关系
     *   链表的随机结点关系只有原链表知道，我们得到原链表关系 在next就是我们创建的新结点
     *
     *   等关系全部确定，再拆解就可以了
     */
    private RandomListNode clone(RandomListNode pHead) {
        if(pHead==null){
            return pHead;
        }
        RandomListNode currentNode=pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (currentNode!=null){
            RandomListNode copyNode=new RandomListNode(currentNode.val);
            RandomListNode originalNext=currentNode.next;
            //将新创建结点 插入原节点后面 ，便于下面的随机查找关系
            currentNode.next=copyNode;
            copyNode.next=originalNext;
            currentNode=originalNext;
        }

        currentNode=pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode!=null){
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //断开原链表，找出新链表
        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode=pHead;
        //作为返回的入口
        RandomListNode copyHeadNode = pHead.next;
        while (copyHeadNode!=null){
            //复制结点
            RandomListNode copyNode = currentNode.next;
            //给原链表链接上真正的 原链表的下一个结点
            currentNode.next = copyNode.next;
            //给赋值链表链接 复制结点的下一个结点
            copyNode.next = copyNode.next==null?null:copyNode.next.next;
            currentNode = currentNode.next;
        }

        return copyHeadNode;
    }

}
