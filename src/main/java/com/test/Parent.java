package com.test;

public class Parent {

    static {
        System.out.println("Parent static block 1");
    }

    {
        // 块
        System.out.println("Parent unstatic block");
    }

    static {
        System.out.println("Parent static block 2");
    }

    public Parent(){
        System.out.println("this is parent class");
    }


}
