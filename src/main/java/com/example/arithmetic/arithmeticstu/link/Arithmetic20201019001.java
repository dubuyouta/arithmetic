package com.example.arithmetic.arithmeticstu.link;

/**
 * @author xiaobao.chen
 * Create at 2020/10/19
 */
public class Arithmetic20201019001 {

    public static void main(String[] args) {

    }

    /**
     * 链表节点的删除
     *
     * @param node
     * @param val
     * @return
     */
    public static ListNode delete(ListNode node, int val) {
        ListNode tempHead = new ListNode(-1);
        tempHead.next = node;
        ListNode temp = tempHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            } else {
                temp = temp.next;
            }
        }
        return tempHead.next;
    }

    /**
     * 链表的反转
     *
     * @param node
     * @return
     */
    public static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode temp = node;
        while (temp.next != null) {
            ListNode listNode = temp.next;
            temp.next = pre;
            pre = temp;
            temp = listNode;
        }
        return temp;
    }

    /**
     * 利用快慢指针找到中间的位置
     *
     * @param node
     * @return
     */
    public ListNode getMiddle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (slow.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 利用双指针找到倒数第k个元素
     *
     * @param node
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode node, int k) {
        ListNode fast = node;
        ListNode slow = node;
        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 双指针链表合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpHead = new ListNode(-1);
        ListNode temp = dumpHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
        }
        temp.next = l1 == null ? l2 : l1;
        return dumpHead.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode temp = dumpHead;
        while (temp.next != null && temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                temp.next = temp.next.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dumpHead.next;
    }
}
