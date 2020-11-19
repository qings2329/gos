package org.leetcode.bitcoinreaver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] result = twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();

//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int diff = target - nums[i];
//            Integer result = map.get(diff);
//            if (result != null && result != i) {
//                return new int[]{i, result};
//            }
//        }

        // 实际上一次循环就可以了
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            Integer result = map.get(diff);
            if (result != null) {
                return new int[]{result, i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
