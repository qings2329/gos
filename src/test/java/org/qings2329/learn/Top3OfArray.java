package org.qings2329.learn;

public class Top3OfArray {

    Integer first;
    int second;
    String three;

    public Top3OfArray() {
        second = 1;
    }

    public Top3OfArray(String str) {
        this();
    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 1};
        // 输出前三大
        // 用链表效率更高
        int[] result = new int[3];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < result.length; j++) {
                if(array[i] > result[j]) {
                    // 移动元素
                    for(int x = result.length - 1; x > j; x--) {
                        result[x] = result[x - 1];
                    }
                    result[j] = array[i];
                    break;
                }
            }
        }

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        Thread t = new Thread();
        t.getPriority();
    }

}
