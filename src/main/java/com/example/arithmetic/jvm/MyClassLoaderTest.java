package com.example.arithmetic.jvm;

/**
 * @author xiaobao.chen
 * Create at 2020/9/15
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("User");
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
}
