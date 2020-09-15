package com.example.arithmetic.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器
 * 1.基础 classloader 类
 * 2.重载 findClass 方法
 *
 *
 * @author xiaobao.chen
 * Create at 2020/9/15
 */
public class MyClassLoader extends ClassLoader {

    public static final String driver = "D:/test/com/my/";

    public static final String fileTyep = ".class";

    public MyClassLoader() {
    }

    private byte[] loadByte(String name) {
        FileInputStream fis = null;
        byte[] data = null;
        try {
            File file = new File(driver + name + fileTyep);
            System.out.println(file.getAbsolutePath());
            fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = fis.read()) != -1) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("loadClassData-IOException");
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] data = loadByte(name);
        return defineClass(name, data, 0, data.length);
    }
}
