package com.test;

public class ArrayRoll {

    public static void main(String[] args) {

        int[] array = new int[]{6, 7, 9, 1, 2, 3, 5};
        int ret = findMin(array);
        System.out.println(ret);


        // 改进，使用二分查找

    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                return array[i];
            } else {
                min = array[i];
            }
        }
        return min;
    }

}
