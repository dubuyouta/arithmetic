package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061002 {

    /**
     * 很巧妙的解法：走的路程必定一样
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;
    }
}
