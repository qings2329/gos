package com.test;

import java.util.HashMap;
import java.util.Map;

public class FindTreeInArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 5, 6, 8, -1, 4};
        int target = 13;
        int[] result = find(arr, target);

        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }

    public static int[] find(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int diff1 = target - arr[i];
            for (int j = 0; j < arr.length - 1; j++) {
                if (j == i) {
                    continue;
                }
                int diff2 = diff1 - arr[j];
                Integer ret = map.get(diff2);
                if (ret != null && ret != j) {
                    return new int[]{i, j, ret};
                }
            }
        }
        return null;
    }

}
