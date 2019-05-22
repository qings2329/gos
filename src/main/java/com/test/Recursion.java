package com.test;

public class Recursion {
    // 照样溢出， java 没有尾递归优化
    public static void main(String[] args) {
        System.out.println(Fibonacci(1999999999, 1, 1));
    }

    // 尾递归
    public static int Fibonacci(int n, int pf, int ps) {
        if (n <= 1) {
            return pf;
        } else {
            return Fibonacci(n - 1, ps, pf + ps);
        }
    }

}
