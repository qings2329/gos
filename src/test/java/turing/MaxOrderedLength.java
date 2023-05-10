package turing;

import java.util.ArrayList;
import java.util.List;

public class MaxOrderedLength {

    public static void main(String args[]) {

        // 链表的初始化
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

//        int[] arr = new int[]{1, 3, 4, 5, 7};
//        int[] arr = new int[]{1, 3, 4, 5, 6, 7};
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 8, 7};
        int[] arr = new int[]{1, 2, 3, 4, 6, 7, 8, 9};
//        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        int maxLen = 0;
        int currentSubLen = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                currentSubLen++;
            } else {
                if (maxLen < currentSubLen) {
                    maxLen = currentSubLen;
                }
                currentSubLen = 1;
            }
        }
        if (maxLen < currentSubLen) {
            maxLen = currentSubLen;
        }

        System.out.println(maxLen);
    }

}
