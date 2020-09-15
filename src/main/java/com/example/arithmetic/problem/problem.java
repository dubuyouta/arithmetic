package com.example.arithmetic.problem;


/**
 * 自旋流程中的if else 判断的执行流程、。具体的参考执行结果
 *
 *
 * @author xiaobao.chen
 * Create at 2020/7/30
 */
public class problem {

    public static void main(String[] args) {
        boolean flag = false;
        int i = 1;
        for (; ; ) {
            i++;
            if (!flag) {
                System.out.println("first step " + i);
                flag = true;
            } else if (flag) {
                System.out.println("true "+i);
                break;
            }
        }
    }
}
