package com.test.concurrent;

public class Interrupt {


    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("t1 run");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }

        };

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        t1.interrupt();
//        Thread.interrupted();
//        t1.isInterrupted();

        t1.stop();


    }

}
