package org.leetcode.bitcoinreaver;

import java.util.Arrays;

public class MoveZero {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12,0,0,0,0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (count > 0) {
                int newPosition = i - count;
                nums[newPosition] = nums[i];
            }
        }

        for (int i = nums.length - 1; count > 0; i--, count--) {
            nums[i] = 0;
        }

//        System.out.println(Arrays.toString(nums));
    }
}
