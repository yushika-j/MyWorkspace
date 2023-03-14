public abstract class AbstractSeries implements Series {

    public double[] take(int k) {


        //initializing the array
        double nextSums[] = new double[k];
        for (int i = 0; i < k; i++) {
            nextSums[i] = next();
        }
        return nextSums;
    }
    
    @Override
   public abstract double next();
}