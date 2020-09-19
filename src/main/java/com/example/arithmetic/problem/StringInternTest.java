package com.example.arithmetic.problem;

/**
 * @author xiaobao.chen
 * Create at 2020-09-10
 */
public class StringInternTest {

    /**
     * jdk 1.6之后的版本
     *
     * @param args
     */
    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");
        //两个匿名的对象 1.   然后 对象 s3  11.  都在堆中
        s3.intern();//堆中的常量池中  创建一个11.  引用执行 s3的地址
        String s4 = "11";//在常量池中发现已经有了，直接使用，地址指向s3的引用地址
        System.out.println(s3 == s4);//true

        String s5 = new String("1") + new String("1");
        String s6 = "11";//常量池中没有，新创建一个
        s3.intern();//发现常量池中已经有了
        System.out.println(s5 == s6);//地址不一样，false
    }
}
