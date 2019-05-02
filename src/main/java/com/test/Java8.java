package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Java8 {

    public String name = "new_" + System.currentTimeMillis();

    /**
     * 传方法的引用
     * @param supplier
     * @return
     */
    public static Java8 create(final Supplier<Java8> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        List<Integer> dataList = Arrays.asList(1,2,3,4,5);
        dataList.stream().map(item -> item + 1).forEach(System.out::println);

        Java8 java8 = Java8.create(Java8::new);
        System.out.println(java8.name);

    }

}
