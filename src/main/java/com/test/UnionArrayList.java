package com.test;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionArrayList {

    public static void main(String args[]) {
        // 下面的list 有几个可以和上面的list对上
        ArrayList<String> a = new ArrayList(Arrays.asList("1", "2", "3", "4", "4", "4"));
        ArrayList<String> b = new ArrayList(Arrays.asList("1", "2", "3", "4", "4"));
//        a.retainAll(b);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            String item = b.get(i);
            if (a.contains(item)) {
                res.add(item);
            }
        }
        System.out.println(res);
    }

}
