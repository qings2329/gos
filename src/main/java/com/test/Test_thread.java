package com.test;

import java.util.concurrent.ArrayBlockingQueue;

public class Test_thread {


    // 阻塞队列
    public static void main(String[] args) {

        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(20);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                long count = 0;
                try {
                    while (true) {
                        System.out.println("入列 " + count);
                        queue.put(count);
                        count++;
                        Thread.sleep(100);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        };


        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Object obj = queue.take();
                        System.out.println("出列 " + obj);
                        Thread.sleep(50);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable1, "线程1");
        Thread thread2 = new Thread(runnable2, "线程2");
        thread1.start();
        thread2.start();

        // 还有一种开启线程的写法
        Thread thread3 = new Thread("thread3") {
            @Override
            public void run(){
                System.out.println(this.getName());
            }
        };

        thread3.start();

    }



}
