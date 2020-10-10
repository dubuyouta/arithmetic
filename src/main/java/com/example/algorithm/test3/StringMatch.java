package com.example.algorithm.test3;


import java.util.Stack;

/**
 * @author heshineng
 * created by 2020/9/16
 */
public class StringMatch {
    /**
     * 字符串配对
     * {@link}
     * 题目要求
     */

    public static void main(String[] args) {
        StringMatch test27 = new StringMatch();
        String val = "(())";
        System.out.println(test27.isValid(val));
        System.out.println(test27.isValid1(val));
        String s = "())(())((())))";
        // String s = "())(())()((((())))";
        System.out.println(test27.maxValidLength(s));
        System.out.println(test27.maxValidLength1(s));
        System.out.println(test27.maxValidLength2(s));
    }

    //检查是否 匹配
    private boolean isValid(String val) {
        if (val == null || val.isEmpty()) {
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

    //优化
    private boolean isValid1(String val) {
        if (val == null || val.isEmpty()) {
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

    //最长匹配长度，暴力破解
    private int maxValidLength(String val) {
        if (val == null || val.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < val.length(); i++) {
            char temp = val.charAt(i);
            if (temp != '(') {
                continue;
            }
            //注此处sum==1
            int sum = 1;
            for (int j = i + 1; j < val.length(); j++) {
                if (val.charAt(j) == temp) {
                    sum++;
                } else {
                    sum--;
                }

                if (sum == 0) {
                    //完全匹配一次，暂存数据
                    max = Math.max(max, j - i + 1);
                    //注意，此处不应该返回值，可能右面还有匹配 (),直到小于0，才跳出内层循环
                } else if (sum < 0) {
                    break;
                }
            }
        }
        return max;
    }

    //最长匹配，优化2 只用栈，减少时间复杂度
    private int maxValidLength1(String val) {
        if (val == null || val.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '(') {
                stack.push(i);
            } else {
                //不同的，需要成对
                stack.pop();
                if (stack.isEmpty()) {
                    //作为下次差值的前一个点，这样差值就不用加1了
                    stack.push(i);
                }
                //计算一次最大值
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    //最长匹配，在优化3 空间复杂度O（1）
    private int maxValidLength2(String val) {
        if (val == null || val.isEmpty()) {
            return 0;
        }
        //首先从左到右，可以检测正对匹配的数，但匹配不出 左边个数大于右边的情况
        int max = 0;
        int currentMax = 0;
        int sum = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '(') {
                sum++;
                currentMax++;
            } else {
                sum--;
                currentMax++;
            }

            if (sum == 0) {
                //匹配成功，暂存最大值
                max = Math.max(max, currentMax);
            } else if (sum < 0) {
                //不能继承当前最大值，重置
                sum = currentMax = 0;
            }
        }
        sum = currentMax = 0;
        //从右往左
        for (int i = val.length() - 1; i >= 0; i--) {
            if (val.charAt(i) == ')') {
                sum++;
                currentMax++;
            } else {
                sum--;
                currentMax++;
            }

            if (sum == 0) {
                //匹配成功，暂存最大值
                max = Math.max(max, currentMax);
            } else if (sum < 0) {
                //不能继承当前最大值，重置
                sum = currentMax = 0;
            }
        }
        return max;

    }
}
