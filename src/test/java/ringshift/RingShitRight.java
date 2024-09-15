package ringshift;

import java.util.Arrays;

/**
 * 循环右移位
 *
 */
public class RingShitRight {


    public static void main(String[] args) {

//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        int[] array = {1, 2};
        int[] array = {1};
        int n = 7, k = 3;

        // 方法1: 需要额外空间, 空间复杂度O(n)
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int index = (i + k) % array.length;
            newArray[index] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(newArray[i]);
        }
        System.out.println();
        System.out.println("##########################################################");


        // 方法2: 迭代, 不需要额外空间, 空间复杂度O(1)
        int count = 1;
        int currentIndex = 0;
        int nextIndex;
        int temp1 = array[currentIndex];
        while (count <= array.length) {
            nextIndex = (currentIndex + k) % array.length;
            int temp2 = array[nextIndex];
            array[nextIndex] = temp1;

            temp1 = temp2;
            currentIndex = nextIndex;
            count++;

            Arrays.stream(array).forEach(System.out::print);
            System.out.println();
        }

//        Arrays.stream(array).forEach(System.out::print);
//        System.out.println();


        // 方法2: 分治

    }

    void leftReverse(int[] array, int begin, int end) {
        for (int i = 0; i < (end - begin + 1) / 2; i++) {
            int temp = array[begin + i];
            array[begin + i] = array[end - i];
            array[end - i] = temp;
        }
    }

}
