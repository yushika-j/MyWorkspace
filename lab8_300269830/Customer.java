
public class Customer {
    public int arrivalTime = 0;
    public int initialNumberOfItems;
    public int numberOfItems = 0;
    public static final int MAX_NUM_ITEMS = 50;


    public Customer(int arrivalTime){
        this.arrivalTime=arrivalTime;
        numberOfItems=(int)((MAX_NUM_ITEMS-1) * Math.random() +1);
        initialNumberOfItems = numberOfItems;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return initialNumberOfItems-numberOfItems;
    }

    public void serve() {
        numberOfItems--;
    }
}

