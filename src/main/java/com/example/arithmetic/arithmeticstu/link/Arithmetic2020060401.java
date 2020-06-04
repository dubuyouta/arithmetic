package com.example.arithmetic.arithmeticstu.link;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 解题思路：
 * 1.两个链表 l1, l2，每次比较时，把小的那一个放入到线队列中。然后指向下一个(比如l1 = l1.next)
 * 2. l2 和 l1的值在进行比较，重复上面的动作。
 * 3.依次 两个队列不断进行 上下的比较，
 * 4.最后把不为null 的指向就可以了。
 *
 * @author xiaobao.chen
 * Create at 2020/6/4
 */
public class Arithmetic2020060401 {

    public static void main(String[] args) {
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
