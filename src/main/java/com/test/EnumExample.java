package com.test;

public enum EnumExample {

    TEST1, TEST2;



    public static void main(String[] args) {
        System.out.println(EnumExample.valueOf("TEST1"));
        System.out.println(TEST1.ordinal());
    }

}
