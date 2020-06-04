package com.example.arithmetic.arithmeticstu;

/**
 * https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
 *
 * @author xiaobao.chen
 * Create at 2020-05-26
 */
public class StringTest {

    public static void main(String[] args) {
        // == 针对基本数据类型，比较的是具体的数据值。
        // == 针对引用类型。比较的是对象的引用地址。

        //直接使用双引号声明出来的String对象会直接存储在常量池中
        String str3 = "a";
        String str4 = "a";
        System.out.println(str3 == str4);

        //
        String str5 = new String("a");
        System.out.println(str3 == str5);

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja1").append("va").toString();
        System.out.println(str2.intern() == str2);

        String s1 = "helloworld";
        String s2 = "hello" + "world";
        System.out.println(s1 == s2);
    }

    public static void test() {
        //在堆中生成一个对象s . 在常量池中的生成"1"的对象。
        String s = new String("1");
        s.intern();//对象s的内容指向常量池中
        String s2 = "1";//地址指向常量池中。
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
