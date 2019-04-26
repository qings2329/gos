package com.test;

public class Children extends Parent  {

    static {
        System.out.println("Children static block 1");
    }

    {
        // 块
        System.out.println("Children unstatic block");
    }

    static {
        System.out.println("Children static block 2");
    }

    public Children() {
        System.out.println("this is children class");
    }

    public static void main(String[] args) {
       Children children1 = new Children();
       System.out.println("*************************");
        Children children2 = new Children();
    }

}
