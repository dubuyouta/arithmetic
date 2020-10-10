package com.example.algorithm.test3;

import com.example.algorithm.bo.ListNode;

/**
 * @author heshineng
 * created by 2020/9/4
 */
public class Test3 {
    /**
     * 查找链表倒数第k个节点
     */

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        ListNode head = new ListNode(1);
        head.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6))
                .addNext(new ListNode(7))
                .addNext(new ListNode(8));
        ListNode node = test3.findKthToTail(head, 4);
        System.out.println(node == null ? "null" : node.val);
    }

    private ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (k <= 0) {
                slow = slow.next;
            }
            k--;
        }
        return k > 0 ? null : slow;
    }
}
