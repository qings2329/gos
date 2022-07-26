package com.test.clasTest;

public class FatherClass {

    // 子类属性不会覆盖同名的父类属性
    protected String name = "father";

    private String privateField = "privateField";

    protected String protectedField = "protectedField";

    protected static String staticField = "staticField";

    protected void test() {
        System.out.println(name + " " + privateField + " " + staticField);
    }
}
