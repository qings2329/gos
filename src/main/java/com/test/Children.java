package com.test;

public class Children extends Parent  {

    public static int STATIC_FIELD = static_method();

    private static int static_method(){
        System.out.println("Children init static field");
        return 5;
    }

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
        System.out.println("this is children construction method");
    }

    public static void main(String[] args) {
       Children children1 = new Children();
       System.out.println("*************************");
        Children children2 = new Children();
    }

}
