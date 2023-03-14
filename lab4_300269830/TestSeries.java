public class TestSeries {

    public static void main(String[] args) {

        AbstractSeries sn;
        double[] tuple;

        sn = new Arithmetic();

        System.out.println("The first five terms of the arithmetic series are:");

        for (int n=0; n<5; n++) {
            System.out.println(sn.next());
        }

        sn = new Geometric();

        System.out.println();
        System.out.println("The first five terms of the geometric series are:");

        tuple = sn.take(5);

        for (int n=0; n<5; n++) {
            System.out.println(tuple[n]);
        }

    }
}