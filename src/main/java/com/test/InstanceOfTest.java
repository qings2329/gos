package com.test;

public class InstanceOfTest {

    public static void main(String[] args) {
        String s = null;
        System.out.println(s instanceof String);

        // 这样写不能通过编译
//        InstanceOfTest test = new InstanceOfTest();
//        System.out.println(test instanceof String);

        Object test = new InstanceOfTest();
        System.out.println(test instanceof String);
    }


}
