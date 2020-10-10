package com.example.algorithm.test2.link;


import com.example.algorithm.bo.ListNode;

import java.util.Stack;

/**
 * @author: heshineng
 * @createdBy: 2020/7/27 9:44
 */
public class Test13 {
    /**
     * 检查链表是否为回文。
     *
     * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
     * {1,2,3,2,1}
     * 返回：true
     * {1,2,3,2,3}
     * 返回：false
     *
     * 回文，就是中心对称
     */

    public static void main(String[] args) {
        Test13 test13 = new Test13();

        ListNode head = new ListNode(1);
        head.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(2))
                .addNext(new ListNode(1));
        System.out.println(test13.isPalindrome(head));
    }

    /**
     * 使用栈实现，使用栈存前半部分，或者数组存储，
     * 使用快慢指针，快指针到尾的时候，慢指针一半。
     * 这样再比较2部分数据就可以了，总体循环链表一遍，使用栈为链表
     * 一半，所以比链表反转总体要好
     *
     * 快慢初始都为 head，fast=fast.next.next slow=slow.next
     * 1->2->3->4->5->6->7->8->9
     * 所以：快指针4次到9 慢指针4次 到5 5为中间结点，跳过中间结点，就是后面需要比较结点
     *
     * 1->2->3->4->5->6->7->8
     * 所以：快指针4次到null 慢指针4次到5 5即为需要比较的第一个节点
     *
     */
    public boolean isPalindrome(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack<Integer>();
        /**
         * 将链表的前半部分元素装入栈中，当快速runner
         *（移动的速度是慢速runner的两倍）
         * 到底链表尾部时，则慢速runner已经处于链表中间位置
         */
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //当链表为奇数个时，跳过中间元素
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            //如果两者不相同，则该链表不是回文串
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    /**
     * 链表反转的方式
     * @param head
     * @return
     */
    private boolean checkSymmetric(ListNode head) {
        if (head == null) {
            return false;
        }
        /**
         * 将原链表完全反转，得到新链表和原链表比较
         * 如果一致，就是回文的
         */
        ListNode newHead = revertListNode(head);
        while (head != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode revertListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = newHead;
            newHead = node;
            head = head.next;
        }
        return newHead;
    }


}
