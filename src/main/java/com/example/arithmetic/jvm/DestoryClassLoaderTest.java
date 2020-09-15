package com.example.arithmetic.jvm;

/**
 * 破坏双亲委派模型
 *
 * @author xiaobao.chen
 * Create at 2020/9/15
 */
public class DestoryClassLoaderTest {

    public static void main(String[] args) {
        DestoryClassLoader destoryClassLoader = new DestoryClassLoader();
        Class<?> aClass = destoryClassLoader.loadClass("User", false);
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
}
