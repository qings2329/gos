package turing;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] k = new int[]{1, 2, 3, 2, 4};
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < k.length; i++) {
            Integer c = countMap.get(k[i]);
            if (c == null) {
                c = 1;
            } else {
                c++;
            }
            countMap.put(k[i], c);
        }
        Integer integer = null;
        int weight = 0;
        for (Integer key : countMap.keySet()) {
            int c = countMap.get(key);
            if (c > weight) {
                weight = c;
                integer = key;
            }
        }
        int subLength = 0;
        int count = weight;
        for (int i = 0; i < k.length && count > 0; i++) {
            if (integer == k[i]) {
                count--;
            }
            // 开始计算长度
            if (count < weight) {
                subLength++;
            }
        }
        System.out.println(subLength);
    }
}
