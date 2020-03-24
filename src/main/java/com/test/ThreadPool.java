package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {


    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("task 1");
            }
        });

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    }


}
