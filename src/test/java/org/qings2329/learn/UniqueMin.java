package org.qings2329.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UniqueMin {

    private int size = 0;
    private int[] arr = new int[10];

    public void insert(int a) {
        if (arr.length < size + 1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size] = a;
        size++;
    }

    public int uniqMin() {
        if (size == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet();
        Set<Integer> treeSet = new TreeSet();
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            if (set.contains(tmp)) {
                treeSet.remove(tmp);
                continue;
            } else {
                set.add(tmp);
                treeSet.add(tmp);
            }
        }

        if (treeSet.size() > 0) {
            return (int) treeSet.toArray()[0];
        }
        return -1;
    }

    public static void main(String args[]) {

    }


}
