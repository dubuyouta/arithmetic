package com.example.arithmetic.jvm;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * WeakReference: 弱引用。在第一次进行垃圾回收时，会被回收掉。
 *
 * @author xiaobao.chen
 * Create at 2020-09-11
 */
public class WeakReferenceTest {

    public static void main(String[] args) {

        ArrayList<Object> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            byte[] bytes = new byte[1024 * 1024];
            WeakReference<byte[]> weakReference = new WeakReference<>(bytes);
            arrayList.add(weakReference);
        }
        System.gc();

        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = ((WeakReference) arrayList.get(i)).get();
            System.out.println(obj);
        }
    }
}
