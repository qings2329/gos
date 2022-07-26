package com.test.clasTest;

public class GrandChildrenClass extends ChildrenClass {

    public static void main(String[] args) {
        GrandChildrenClass grandChildrenClass = new GrandChildrenClass();
        // 父类的保护成员，隔代的子代也能访问
        System.out.println(grandChildrenClass.protectedField);
    }
}
