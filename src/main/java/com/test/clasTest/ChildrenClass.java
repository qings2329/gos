package com.test.clasTest;

public class ChildrenClass extends FatherClass {

    protected String name = "children";

    private int privateField = 1;

    protected static String staticField = "2";

//    protected static int staticField = 2;


    //不能重写父类私有方法
    private void privateMethod() {
        System.out.println("ChildrenClass privateMethod");
    }

    public static void main(String[] args) {
        ChildrenClass childrenClass = new ChildrenClass();
        childrenClass.test();
        System.out.println(childrenClass.privateField);
        System.out.println(childrenClass.protectedField);

        childrenClass.protectedMethod();
    }

}
