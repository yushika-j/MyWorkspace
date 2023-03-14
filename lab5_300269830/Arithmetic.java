public class Arithmetic extends AbstractSeries {

    // instance variables
        public double current;
        public static final double a = 1;
        public int num = 1;
        public int n;
    public double next() {

        // implement the method
        current+=n;
        n++;
        return current;
        
    }
}