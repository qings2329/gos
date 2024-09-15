package ringshift;

import java.util.Arrays;

/**
 * 循环左移位
 */
public class RingShitLeft {


    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        int[] array = {1, 2};
//        int[] array = {1};
        int n = 7, k = 3;

        // 方法1: 分治
        leftReverse(array, 0, k - 1);
        leftReverse(array, k, n - 1);
        leftReverse(array, 0, n - 1);

        Arrays.stream(array).forEach(System.out::print);
        System.out.println();

        System.out.println();
        System.out.println("##########################################################");
        // 方法2: 迭代, 不需要额外空间, 空间复杂度O(1)

        int[] array2 = {1, 2, 3, 4, 5, 6, 7};

        int count = 1;
        int currentIndex = 0;
        int nextIndex;
        int temp1 = array2[currentIndex];
        while (count <= array.length) {
            nextIndex = (currentIndex - k) % array2.length;
            if (nextIndex < 0) {
                nextIndex += array2.length;
            }
            int temp2 = array2[nextIndex];
            array2[nextIndex] = temp1;

            temp1 = temp2;
            currentIndex = nextIndex;
            count++;

            Arrays.stream(array2).forEach(System.out::print);
            System.out.println();
        }


    }

    static void leftReverse(int[] array, int begin, int end) {
        for (int i = 0; i < (end - begin + 1) / 2; i++) {
            int temp = array[begin + i];
            array[begin + i] = array[end - i];
            array[end - i] = temp;
        }
    }

}
