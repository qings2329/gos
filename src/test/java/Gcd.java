public class Gcd {

    /**
     * 求最大公约数
     * @param args
     */
    public static void main(String[] args) {

        int a = 9;
        int b = 6;

        // 应该从大到小查找
        int max = 1;
        for (int i = 2; i < a && i < b; i++) {
            if (a % i == 0 && b % i == 0) {
                max = i;
            }
        }
        System.out.println(max);

    }

}
