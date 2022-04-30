package com.test.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        myHashMap();
        myWeakHashMap();

//        既然有WeakHashMap，那么有WeakHashSet吗？
//        可以通过Collections.newSetFromMap(Map<E,Boolean> map)方法可以将任何 Map包装成一个Set
    }

    public static void myHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        String key = new String("k1");
        String value = "v1";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();

        System.out.println(map);
    }

    public static void myWeakHashMap() throws InterruptedException {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
//        String key = "weak";
        // 刚开始写成了上边的代码
        //思考一下，写成上边那样会怎么样？ 那可不是引用了
        String key = new String("weak");
        String value = "map";
        map.put(key, value);
        System.out.println(map);
        //去掉强引用
        key = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(map);
    }


}
