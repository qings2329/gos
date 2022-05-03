package com.test;

import java.util.TreeMap;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "test3");
        treeMap.put(1, "test1");
        treeMap.put(2, "test2");
        System.out.println(treeMap.firstKey());

        // 内部使用了 treemap
        TreeSet treeSet = new TreeSet();
        treeSet.size();
        treeSet.add(11);
        treeSet.add(14);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println(treeSet.last());

    }

}
