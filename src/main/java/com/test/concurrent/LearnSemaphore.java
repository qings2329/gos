package com.test.concurrent;

import java.util.concurrent.Semaphore;

public class LearnSemaphore {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10);
        try {
//            if (semaphore.availablePermits() == 0) {
//
//            }

            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            // do something
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
