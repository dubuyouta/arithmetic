package com.example.arithmetic.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author xiaobao.chen
 * Create at 2020/9/15
 */
public class DestoryClassLoader extends ClassLoader {

    public static final String driver = "D:/test/com/my/";

    public static final String fileTyep = ".class";

    public DestoryClassLoader() {
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) {
        synchronized (getClassLoadingLock(name)) {
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                c = findClass(name);
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
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
