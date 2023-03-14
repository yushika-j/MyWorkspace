public class Geometric extends AbstractSeries {

    // instance variables
    
    public double current = 1;
    public int n;
    public Geometric() {
        current=0;
        n=0;
    }
    @Override

    public double next() {
        //implement the method
        
        current+=(1.0/Math.pow(2, n));
        //increment n
        n++;
        return current;

    }
    
    }
