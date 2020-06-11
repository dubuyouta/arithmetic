package com.example.arithmetic.arithmeticstu.link;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author xiaobao.chen
 * Create at 2020-06-08
 */
public class Arithmetic2020061101 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i);
            int end = list.get(list.size() - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
