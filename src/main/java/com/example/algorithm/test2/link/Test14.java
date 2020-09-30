package com.example.algorithm.test2.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/7/27 11:24
 */
public class Test14 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */

    public static void main(String[] args) {
        Test14 test14=new Test14();
        ListNode head = new ListNode(1);
        head.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6))
                .addNext(new ListNode(7))
                .addNext(new ListNode(8));
        ListNode node=test14.getNode(head,10);
        System.out.println(node==null?"null":node.val);
    }

    public ListNode getNode(ListNode head,int k){
        if(head==null||k<=0){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null){
            fast=fast.next;
            if(k>0){
                k--;
                continue;
            }
            slow=slow.next;
        }
        return k==0?slow:null;
    }
}
