package com.example.arithmetic.arithmeticstu.link;

/**
 * @author xiaobao.chen
 * Create at 2020/4/28
 */
public class Arithmetic2020042802 {

    public static void main(String[] args) {

    }

    /**
     * 链表的基本操作：1.创建  2.遍历
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = null;
        ListNode newTemp = newNode;
        ListNode temp1 = l1, temp2 = l2;
        int presum = 0;
        while (temp1 != null || temp2 != null) {
            int num1 = temp1 == null ? 0 : temp1.val;
            int num2 = temp2 == null ? 0 : temp2.val;
            int sum = num1 + num2 + presum;

            presum = sum / 10;

            if (newTemp == null) {
                newNode = new ListNode(sum % 10);
            } else {
                newTemp.next = new ListNode(sum % 10);
                newTemp = newTemp.next;
            }

            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
        }
        if (presum > 0) {
            newTemp.next = new ListNode(presum);
        }
        return newNode;
    }
}
