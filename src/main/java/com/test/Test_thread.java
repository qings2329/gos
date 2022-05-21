package com.test;

import java.util.concurrent.*;

public class Test_thread {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;


    // 阻塞队列
    public static void main(String[] args) throws Exception {

        // 1 左移 3 位
        System.out.println(1 << 3);

        System.out.println(CAPACITY);

        ExecutorService singlePool = Executors.newSingleThreadExecutor();

        Callable<Integer> call = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("正在计算结果...");
                Thread.sleep(1000);
                return 1;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask(call);
        singlePool.submit(futureTask);
        System.out.println("FutureTask " + futureTask.get());
        // 线程池不shutdown, 导致jvm不能结束
        singlePool.shutdown();


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

//        Thread thread1 = new Thread(runnable1, "线程1");
//        Thread thread2 = new Thread(runnable2, "线程2");
//
//        thread1.setDaemon(true);
//        thread2.setDaemon(true);

//        thread1.start();
//        thread2.start();

        // 还有一种开启线程的写法
        Thread thread3 = new Thread("thread3") {
            @Override
            public void run() {
                System.out.println(this.getName() + "_" + System.currentTimeMillis());
            }
        };

        Thread thread4 = new Thread("thread4") {
            @Override
            public void run() {
                System.out.println(this.getName() + "_" + System.currentTimeMillis());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " done");
            }
        };

        Thread.yield();

        // 如何重复使用线程 ？
//        for (; ; ) {
        if (thread4.getState() == Thread.State.NEW) {
            thread4.start();
        } else {

        }

        System.out.println(thread3.getState());

        thread4.join();
        thread4.stop();

        thread3.start();
        thread3.join();
        thread3.stop();
//        }


        System.out.println("all done");

    }


}
