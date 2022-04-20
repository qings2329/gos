package com.test.lock;

import java.util.concurrent.locks.LockSupport;

public class LearnLock {

    public static void main(String args[]) {


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
            // exception : current thread is not owner
//            lockObj.notifyAll();
            LockSupport.unpark(t1);
        });
        t2.start();


    }


}
