package com.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LearnLock {

    public static void main(String args[]) throws InterruptedException {



        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        // 都是使用了AQS
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();


        Object lockObj = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("t1 park....");
            LockSupport.park(lockObj);

            System.out.println("t1 done.");
        });
        t1.start();


        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t1);

            // exception : current thread is not owner
//            lockObj.notifyAll();

            // 造成死锁, 不能这样用
//            synchronized (lockObj) {
//                lockObj.notifyAll();
//            }


        });
        t2.start();


        // wait notify 用法
        Integer value = 0;
        Thread t3 = new Thread(() -> {
            synchronized (value) {
                System.out.println("t3 wait.");
                try {
                    value.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t3 run.");
        });
        t3.start();


        Thread.sleep(1000);
        synchronized (value) {
            value.notifyAll();
        }


    }


}
