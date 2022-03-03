package com.test;

public class Finally {

    public static void main(String[] args) {
        try {
            throw new Exception("");
        } catch (Exception ex) {
            System.out.println("catch ex");
            // 这里return，也会执行 finally
            return;
        } finally {
            System.out.println("finally");
        }

    }
}
