package com.example.arithmetic.arithmeticstu.link;


/**
 * 单向链表的基本操作
 * 1.带头结点。
 * 2.不带头结点。
 *
 * @author xiaobao.chen
 * Create at 2020/4/30
 */
public class ListNodeOperationStu {

    //带头节点。初始化一个头节点
    ListNode head = new ListNode(0);

    /**
     * 新增节点
     *
     * @param node
     */
    public void add(ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 遍历
     */
    public void list() {
        ListNode temp = head;
        while (temp != null) {//要显示最后一个节点的信息，所以不能使用next.
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void delete(ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == node.val) {
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("not exists");
        }
        temp.next = temp.next.next;
    }

    public boolean find(ListNode node) {
        ListNode temp = head;
        while (temp != null) {//同上理
            if (temp.val == node.val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNodeOperationStu operationStu = new ListNodeOperationStu();
        //add
        operationStu.add(new ListNode(1));
        operationStu.add(new ListNode(2));
        operationStu.add(new ListNode(3));
        operationStu.add(new ListNode(4));
        operationStu.add(new ListNode(5));
        //list
        operationStu.list();
        //find
        System.out.println(operationStu.find(new ListNode(0)));
        operationStu.delete(new ListNode(5));
        operationStu.list();
    }
}
