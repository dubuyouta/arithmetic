package com.example.arithmetic.arithmeticstu.link;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061004 {

    /**
     * 利用数组存储数据
     * count 计算 长度
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode[] list = new ListNode[100];
        int count = 0;
        while (head != null) {
            list[count] = head;
            head = head.next;
            count++;
        }
        System.out.println(count);
        int length = list.length;
        return list[length / 2];
    }

    /**
     * 单指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            ++n;
            temp = temp.next;
        }

        int k = 0;
        temp = head;
        while (k < n / 2) {
            ++k;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
