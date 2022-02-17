package com.test.exception;

public class TestException {

    // must check
    private void testCheckEx() throws CheckException {
        throw new CheckException();
    }

    private void testEx() throws Exception {
        throw new Exception();
    }

    private void testThrowable() throws Throwable {
        throw new Throwable();
    }

    private void testThrowableChild() throws ThrowableChild {
        throw new ThrowableChild();
    }


    // no need to check
    // RuntimeException 类 和 Error 类，以及他们的子类，属于uncheck
    private void testUncheckEx() {
        throw new UncheckException();
    }

    private void testRuntimeEx() {
        throw new RuntimeException();
    }

    private void testErrorChild() {
        throw new ErrorChild();
    }

    private void testError() {
        throw new Error();
    }



//    public static void main(String... arg) {
//
//    }

}
