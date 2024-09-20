package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {


    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task 1");
            }
        });

        // 线程池的核心参数可以修改
        ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        cachedThreadPool.setCorePoolSize(10);
        cachedThreadPool.setMaximumPoolSize(20);

    }


}
