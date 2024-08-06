package com.test;

public class TestAcquireCallFuncName {


    public static void main(String[] args) {
        acquireCallFuncName();
        methodA();
    }

    public static void acquireCallFuncName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        System.out.println(methodName);
    }

    public static void methodA() {
        printPreviousMethodName();
    }

    public static void printPreviousMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 注意：索引0是getStackTrace()本身，索引1是printPreviousMethodName，索引2是调用printPreviousMethodName的方法
        if(stackTrace.length > 2) {
            String methodName = stackTrace[2].getMethodName();
            System.out.println("上一层调用的方法名是: " + methodName);
        }
    }
}
