package com.test.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class WeakReferenceExample {

    private static final ReferenceQueue<byte[]> RQ = new ReferenceQueue<>();

    public static void main(String[] args) {
        final Map<WeakReference<byte[]>, Object> map = new HashMap<>();

        final Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while ((k = (WeakReference<byte[]>) RQ.remove()) != null) {
                    log.info("第 {} 个回收对象，对象打印为：{}", cnt++, k);
                }
            } catch (InterruptedException ignored) {
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            map.put(new WeakReference<>(new byte[1024 * 1024], RQ), new Object());
        }

        log.info("map.size ：{}", map.size());
    }
    /* 部分输出如下：
     * 第 789 个回收对象，对象打印为：java.lang.ref.WeakReference@26653222
     * 第 790 个回收对象，对象打印为：java.lang.ref.WeakReference@553f17c
     * 第 791 个回收对象，对象打印为：java.lang.ref.WeakReference@56ac3a89
     * 第 792 个回收对象，对象打印为：java.lang.ref.WeakReference@6fd02e5
     * 第 793 个回收对象，对象打印为：java.lang.ref.WeakReference@2b98378d
     * 第 794 个回收对象，对象打印为：java.lang.ref.WeakReference@26be92ad
     * 第 795 个回收对象，对象打印为：java.lang.ref.WeakReference@6d00a15d
     * map.size ：1000
     */
}