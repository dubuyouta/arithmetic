package com.example.algorithm.bo;

/**
 * @author: heshineng
 * @createdBy: 2019/11/22 16:00
 */
public class ListNode {
    /**
     * 给 test 专用的 单向链表，做一个 addNext方法
     */

    public int val;

    public ListNode next;

    //暂存下一个添加的next，这样就不用遍历循环
    private ListNode tempAddNext;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode addNext(ListNode next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.tempAddNext.next = next;
        }
        this.tempAddNext = next;
        return this;
    }

    @Override
    public String toString() {
        //链表顺序输出
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(val);

        ListNode nextTemp = next;

        while (nextTemp != null) {
            builder.append(",");
            builder.append(nextTemp.val);
            nextTemp = nextTemp.next;
        }

        builder.append("}");

        return builder.toString();
    }
}
