package com.example.algorithm.test1.link;

import com.kecies.interview.algorithm.bo.ListNode;

/**
 * @author: heshineng
 * @createdBy: 2019/11/22 15:54
 */
public class Test15 {
    /**
     *题目
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当
     * 然我们需要合成后的链表满足单调不减规则
     *
     * 合成的链表也需要 有序增
     */

    public static void main(String[] args) {
        Test15 test15 = new Test15();

        ListNode listNode1 = new ListNode(1);
        listNode1.addNext(new ListNode(2))
                .addNext(new ListNode(3))
                .addNext(new ListNode(4));

        ListNode listNode2 = new ListNode(3);
        listNode1.addNext(new ListNode(4))
                .addNext(new ListNode(5))
                .addNext(new ListNode(6));

        System.out.println(test15.merge3(listNode1, listNode2).toString());
    }

    public ListNode merge1(ListNode pre, ListNode last) {
        /**
         * 第一版 有错误，需要检查错误
         */
        if (pre == null && last == null) {
            return null;
        }
        if (pre == null) {
            return last;
        }
        if (last == null) {
            return pre;
        }
        //使用新的 ListNode 存储结果
        ListNode result = null;
        ListNode preTemp = pre, lastTemp = last;
        while (pre != null || last != null) {
            if (preTemp == null) {
                //前序列表已经空了，将剩余的 lastTemp 全部接入
                result = result.next = new ListNode(lastTemp.val);
                lastTemp = lastTemp.next;
            } else if (lastTemp == null) {
                //后序列表已经空了，将剩下 preTemp 全部接入
                result = result.next = new ListNode(preTemp.val);
                preTemp = preTemp.next;
            } else {
                //均不为空情况
                if (preTemp.val < lastTemp.val) {
                    if (result == null) {
                        result = new ListNode(preTemp.val);
                    } else {
                        result = result.next = new ListNode(preTemp.val);
                    }
                    preTemp = preTemp.next;
                } else if (preTemp.val > lastTemp.val) {
                    if (result == null) {
                        result = new ListNode(lastTemp.val);
                    } else {
                        result = result.next = new ListNode(lastTemp.val);
                    }
                    lastTemp = lastTemp.next;
                } else {
                    if (result == null) {
                        result = new ListNode(preTemp.val);
                    } else {
                        result = result.next = new ListNode(preTemp.val);
                    }
                    preTemp = preTemp.next;
                }
            }
        }
        return result;

    }

    public ListNode merge2(ListNode pre, ListNode last) {
        if (pre == null && last == null) {
            return null;
        }
        if (pre == null) {
            return last;
        }
        if (last == null) {
            return pre;
        }
        //使用新的 ListNode 存储结果
        ListNode resultHead = null;
        ListNode result = null;
        /**
         * 错误一 一定要留下结果的头结点，要不然，只能得到合并之后的最后一个点
         */
        ListNode preTemp = pre, lastTemp = last;
        // 错误二 又是写错，要注意 写完检查一下 preTemp != null || lastTemp != null
        // while (pre != null || last != null) {
        while (preTemp != null || lastTemp != null) {
            if (preTemp == null) {
                //前序列表已经空了，将剩余的 lastTemp 全部接入
                result = result.next = new ListNode(lastTemp.val);
                /**
                 * 此处的优化方案，已经为空，直接
                 * result.next=lastTemp 跳出循环
                 */
                lastTemp = lastTemp.next;
            } else if (lastTemp == null) {
                //后序列表已经空了，将剩下 preTemp 全部接入
                result = result.next = new ListNode(preTemp.val);
                preTemp = preTemp.next;
            } else {
                //均不为空情况
                if (preTemp.val < lastTemp.val) {
                    if (result == null) {
                        result = new ListNode(preTemp.val);
                        resultHead = result;
                    } else {
                        result = result.next = new ListNode(preTemp.val);
                    }
                    preTemp = preTemp.next;
                } else if (preTemp.val > lastTemp.val) {
                    if (result == null) {
                        result = new ListNode(lastTemp.val);
                        resultHead = result;
                    } else {
                        result = result.next = new ListNode(lastTemp.val);
                    }
                    lastTemp = lastTemp.next;
                } else {
                    if (result == null) {
                        result = new ListNode(preTemp.val);
                        resultHead = result;
                    } else {
                        result = result.next = new ListNode(preTemp.val);
                    }
                    preTemp = preTemp.next;
                }
            }
        }
        return resultHead;

    }

    /**
     * 对 merge2 的优化
     * @param pre
     * @param last
     * @return
     */
    public ListNode merge3(ListNode pre, ListNode last) {
        if (pre == null && last == null) {
            return null;
        }
        if (pre == null) {
            return last;
        }
        if (last == null) {
            return pre;
        }
        //使用新的 ListNode 存储结果
        ListNode resultHead = new ListNode(0);
        ListNode result = resultHead;
        while (pre != null && last != null) {
            if (pre.val <= last.val) {
                result = result.next = new ListNode(pre.val);
                pre = pre.next;
            } else {
                result = result.next = new ListNode(last.val);
                last = last.next;
            }
        }

        /**
         * 再把2个列表还剩下的加到现在的后面
         */
        if (pre != null) {
            result.next = pre;
        }
        if (last != null) {
            result.next = last;
        }
        return resultHead.next;
    }

}
