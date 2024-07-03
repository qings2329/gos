package com.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterTerminateExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 使用limit()终止流处理
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(result); // 输出: [2, 4, 6]
    }
}
