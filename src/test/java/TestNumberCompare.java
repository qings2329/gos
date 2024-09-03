public class TestNumberCompare {


    public static void main(String[] args) {
        int a = 10;
        long b = 10L;
        double c = 10f;

        System.out.println(a == b);
        System.out.println(b == c);


        Integer a1 = Integer.valueOf(10);
        Integer a2 = new Integer(10);

        Long b1 = Long.valueOf(10L);
        Long b2 = new Long(10L);

        Double c1 = Double.valueOf(10);
        Double c2 = new Double(10);

        System.out.println(a1 == a2);

        System.out.println(b1 == b2);

        System.out.println(c1 == c2);

    }

}
