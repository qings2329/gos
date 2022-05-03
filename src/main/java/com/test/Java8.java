package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Java8 {

    public String name = "new_" + System.currentTimeMillis();

    /**
     * 把方法作为参数
     *
     * @param supplier
     * @return
     */
    public static Java8 create(final Supplier<Java8> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        // supplier 传new
        Java8 java8 = Java8.create(Java8::new);
        System.out.println(java8.name);

        List<Integer> dataList = Arrays.asList(1, 2, 3, 4, 5);
        // forEach Consumer 传println
        dataList.stream().map(item -> item * 2).forEach(System.out::println);

        Integer integer = null;
        Optional<Integer> a = Optional.ofNullable(integer);
        // 默认值
        Integer integer1 = a.orElse(1);
        System.out.println(integer1);
        // 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(integer);





    }

}
