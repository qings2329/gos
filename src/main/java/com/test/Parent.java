package com.test;

public class Parent {

    public static int STATIC_FIELD1 = static_method(1);

    private static int static_method(int num){
        System.out.println("Parent init field " + num);
        return num;
    }

    public static int STATIC_FIELD2 = static_method(2);

    public int unstaticField = static_method(3);

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
        System.out.println("this is parent construction method");
    }


}
