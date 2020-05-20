package com.example.arithmetic.arithmeticstu.link;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xiaobao.chen
 * Create at 2020/4/22
 */
public class Arithmetic2020042303 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = null;
        System.out.println(reversePrint(head).length);
        System.out.println(reversePrint1(head).length);
        System.out.println(reversePrint2(head).length);
    }

    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.addLast(temp.val);
            temp = temp.next;
        }
        int len = stack.size();
        int[] print = new int[len];
        for (int i = 0; i < len; i++) {
            print[i] = stack.removeLast();
        }
        return print;
    }

    public static int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int len = stack.size();
        int[] print = new int[len];
        for (int i = 0; i < len; i++) {
            print[i] = stack.pop();
        }
        return print;
    }

    public static int[] reversePrint2(ListNode head) {
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        int[] print = new int[count];
        temp = head;
        for (int i = count - 1; i >= 0; i--) {
                print[i] = temp.val;
                temp = temp.next;
        }
        return print;
    }
}
