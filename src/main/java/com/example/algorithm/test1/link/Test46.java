package com.example.algorithm.test1.link;

import com.example.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2020/5/19 18:11
 */
public class Test46 {
    /**
     * 一个从 0~n-1  的n个元素的环形链表，对于指定的数据m，从编号0的元素开始计数，计数到m-1;
     *      *            次元素移除链表，并且链表的下一个元素继续从0计数，直到剩下最后一个元素
     */
    public static void main(String[] args) {
        Test46 test46 = new Test46();
        System.out.println(test46.LastRemaining_Solution1(15,3));
        System.out.println(test46.LastRemaining_Solution2(15,3));
    }

    /**
     * 使用环形链表
     * @param n
     * @param m
     * @return
     */
    private int findLastNumber(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;
        int k = 0;
        /**
         * 从0开始计数的
         */
        node=head;
        while (node.next != node) {
               //从0开始计数
            if (k == m-1) {
                node.next = node.next.next;
                k = 0;
            } else {
                node = node.next;
            }
            k++;
        }

        return node.val;
    }

    /**
     * 当
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {
        // 不满足的条件
        if (n <= 0 || m <= 0) return -1;
        return n == 1 ? 0 : (LastRemaining_Solution1(n - 1, m) + m) % n;
    }

    public int LastRemaining_Solution2(int n, int m) {

        if(m <= 0 || n <= 0){
            return -1;
        }
        //先构造循环链表
        ListNode head = new ListNode(0); //头结点, 值为0
        ListNode pre = head;
        ListNode temp = null;
        for(int i = 1; i < n; i++){
            temp = new ListNode(i);
            pre.next = temp;
            pre = temp;
        }
        temp.next = head;//将第n-1个结点(也就是尾结点)指向头结点

        ListNode temp2 = null;
        while(n != 1){
            temp2 = head;
            //先找到第m个结点的前驱
            for(int i = 1; i < m - 1; i++){
                temp2 = temp2.next;
            }
            //删除第m个结点：将第m个结点的前驱指向第m个结点后面那个结点,temp2表示第m个结点的前驱
            temp2.next = temp2.next.next;
            head = temp2.next; //更新头结点
            n--;
        }

        return head.val;

    }
}
