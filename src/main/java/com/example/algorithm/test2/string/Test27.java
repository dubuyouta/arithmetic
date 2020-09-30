package com.example.algorithm.test2.string;

import java.util.Stack;

/**
 * @author heshineng
 * created by 2020/9/15
 */
public class Test27 {

    public static void main(String[] args) {
        Test27 test27 = new Test27();
        String val = "(())";
        System.out.println(test27.isValid(val));
        System.out.println(test27.isValid1(val));
        String s = "())(())((())))";
        // String s = "())(())()((((())))";
        System.out.println(test27.maxValidLength(s));
        System.out.println(test27.maxValidLength1(s));
        System.out.println(test27.maxValidLength2(s));
        System.out.println(test27.longestValidParentheses(s));
    }

    /**
     * 给定一个只包括 '('，')'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
     *
     * 示例 1:
     * 输入: "(())"
     * 输出: true
     *
     *  实例 2：
     *  输入: "())("
     * 输出: false
     *
     * 时间复杂度 O(n) 空间复杂度 O(1)
     */
    private boolean isValid(String val) {
        if (val == null || val.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '(') {
                stack.push(val.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 还是上面题目，优化空间复杂度为 o(1)
     */
    private boolean isValid1(String val) {
        if (val == null || val.length() == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '(') {
                sum++;
            } else {
                if (sum == 0) {
                    return false;
                } else {
                    sum--;
                }
            }
        }
        return sum == 0;
    }

    /**
     *给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * 上面题目的变种
     * 示例 1:
     *
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     *
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     *
     * 首先暴力破解 时间 o（n^2） 空间o（1）
     */
    private int maxValidLength(String val) {
        if (val == null || val.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < val.length(); i++) {
            char pre = val.charAt(i);
            if (pre != '(') {
                continue;
            }
            int j = i + 1;
            int sum = 1;
            for (; j < val.length(); j++) {
                if (val.charAt(j) == '(') {
                    sum++;
                } else {
                    sum--;
                }

                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                    // break;
                    //此处返回有问题，后面可能还有需要继续，直到小于0为止
                } else if (sum < 0) {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 对上面的时间复杂度优化
     * 使用栈来存放元素的下标
     * 时间复杂度降低 为 O(n),空间复杂度也为 O(n)
     */
    private int maxValidLength1(String val) {
        if (val == null || val.length() == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '(') {
                stack.push(i);
            } else {
                //否则元素就要出栈，保持成对出现
                stack.pop();
                //判断栈顶为空
                if (stack.isEmpty()) {
                    //哪怕此时是一个 ），作为差值的下标进行计算
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    /**
     * 优化为 时间复杂度为 O(n) 空间复杂度为 O(1)
     */
    private int maxValidLength2(String val) {
        if (val == null || val.length() == 0) {
            return 0;
        }
        int max = 0;
        /**
         * 使用一个当前最大值来继承之前每一次的最大值结果
         */
        int currentMax = 0;
        //作为计算的标志
        int sum = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '(') {
                sum++;
                currentMax++;
            } else {
                sum--;
                currentMax++;
            }

            //形成闭环，先计算一次合理的最大值并存储
            if (sum == 0) {
                max = Math.max(max, currentMax);
            }

            if (sum < 0) {
                //重置计算配对标志
                sum = 0;
                //重置当前最大值
                currentMax = 0;
            }
        }
        /**
         * 但是只做上面的一遍循环，只能判断刚好匹配
         * 或者 ）比 （多的
         * 对于 ((( ))  这种左边多余右边的无法计算最大值，所以还需
         * 从右往左循环匹配一次
         */
        currentMax = sum = 0;
        for (int i = val.length() - 1; i >= 0; i--) {
            //从右往左，就要以 ）为主进行计算了
            if (val.charAt(i) == ')') {
                sum++;
                currentMax++;
            } else {
                sum--;
                currentMax++;
            }
            if (sum == 0) {
                //完全匹配计算一次值
                max = Math.max(max, currentMax);
            } else if (sum < 0) {
                sum = currentMax = 0;
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        // 从左到右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        // 从右到左
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
