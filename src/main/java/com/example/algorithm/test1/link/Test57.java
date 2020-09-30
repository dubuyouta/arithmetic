package com.example.algorithm.test1.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/5/28 15:47
 */
public class Test57 {
    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
     * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */

    public static void main(String[] args) {
        Test57 test57 = new Test57();

        ListNode preHead = new ListNode(1);
        preHead.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(5))
                .addNext(new ListNode(5))
                .addNext(new ListNode(9))
                .addNext(new ListNode(8))
                .addNext(new ListNode(8));

        ListNode preHead1 = new ListNode(1);
        preHead1.addNext(new ListNode(1));

        ListNode result = test57.deleteDuplicateNode(preHead);
        System.out.println(result == null ? "null" : result.toString());
    }

    private ListNode deleteDuplicateNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode lastNode = head.next;
        while (lastNode != null) {
            if (lastNode.val == curNode.val) {
                lastNode = lastNode.next;
            } else {
                /**
                 * 如何判断是否重复了
                 */
                if (curNode.val == curNode.next.val) {
                    //说明重复了，last往后走了
                    if (preNode != null) {
                        preNode.next = lastNode;
                    }
                    curNode = lastNode;
                    lastNode = lastNode.next;
                } else {
                    preNode = curNode;
                    curNode = curNode.next;
                    lastNode = lastNode.next;
                }
            }
        }
        //判断一下最后的尾巴是否有重复的
        if(curNode.next!=null&&curNode.val==curNode.next.val){
            if(preNode!=null){
                preNode.next=null;
            }else{
                return null;
            }
        }
        return head;
    }
}
