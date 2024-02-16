package com.test.crash;

import java.util.HashMap;
import java.util.Map;
public class HashMapLeakDemo {
    public static class Key {
        String title;
        public Key(String title) {
            this.title = title;
        }
    }
    public static void main(String[] args) {
        Map<Key, Integer> map = new HashMap<>();
        map.put(new Key("1"), 1);
        map.put(new Key("2"), 2);
        map.put(new Key("3"), 2);
        // 忘记了重写对象的hashCode和equals方法，就会产生内存泄漏
        Integer integer = map.get(new Key("2"));
        // 得到空对象, 没能找出以前放置的的key
        System.out.println(integer);
    }
}
