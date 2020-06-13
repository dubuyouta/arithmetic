package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 链表操作的总结：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/solution/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-3/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061102 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode temp = dumpHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }
        return temp.next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (k > 0) {
            k--;
            p = p.next;
        }

        ListNode q = head;
        while (p != null) {
            q = q.next;
            p = p.next;
        }
        return q;
    }

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return head.val;
        }
        ListNode p = head;
        while (k > 0) {
            k--;
            p = p.next;
        }

        ListNode q = head;
        while (p != null) {
            q = q.next;
            p = p.next;
        }
        return q.val;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode l1 = head;
        ListNode l2 = reverseList(middle(head));
        boolean flag = true;
        while (flag && l2.next != null) {
            if (l1.val != l2.val) {
                flag = false;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return flag;
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
