package turing;

public class ExceptionTest {
    public Integer divide(int a, int b) {
        try {
            return a/b;
        }
//        catch (Exception ex) {
//
//        }
        finally {
            System.out.print("finally");
        }
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            System.out.print(exceptionTest.divide(10,0));
//            Integer.parseInt();
//            Integer.valueOf();
        } catch (Exception ex){
            System.out.print("Division by 0!");
        }
    }

}


