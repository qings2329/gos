package com.test;

public class VolatileDemo {

//    public static boolean finishFlag = false;
    public static volatile boolean finishFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!finishFlag) {
                i++;
                System.out.println(i);
            }
        }, "t1").start();
        Thread.sleep(100);//确保t1先进入while循环后主线程才修改finishFlag
        finishFlag = true;
    }

}
