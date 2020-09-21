package com.example.arithmetic.jvm;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * softReference 软引用：存在但是非必要的引用对象。
 * 在内存溢出之前，会把软引用对象列入垃圾回收的范围。回收之后，如果还是没有有足够的内存，那么就会报内存溢出。
 *
 * @author xiaobao.chen
 * Create at 2020-09-11
 */
public class SoftReferenceTest {

    public static void main(String[] args) {

        ArrayList<Object> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            byte[] bytes = new byte[1024 * 1024];
            SoftReference<byte[]> softReference = new SoftReference<>(bytes);
            arrayList.add(softReference);
        }

        System.gc();



        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = ((SoftReference) arrayList.get(i)).get();
            System.out.println(obj);
        }
    }
}
