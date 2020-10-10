package com.example.algorithm.test1.link;

import com.example.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2019/11/22 15:54
 */
public class Test14 {
    /**
     * 题目描述
     * 输入一个链表，输出该链表中倒数第k个结点。
     *
     * 使用2个指针做 最下标记录
     *
     */

    public static void main(String[] args) {
        Test14 test = new Test14();
        ListNode listNode = new ListNode(1);
        listNode.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6));

        System.out.println(test.findKthToTail(listNode, 2).val);
    }

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode current = head, pre = head;
        // 从0 开始
        int count = 0;
        while (current != null) {
            current = current.next;
            if (count >= k) {
                pre = pre.next;
            }
            //一定最后加
            count++;
        }
        return count < k ? null : pre;
    }
}
