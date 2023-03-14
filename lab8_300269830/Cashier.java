public class Cashier{
    private int totalCustomerWaitTime;
    private int customerServed;
    private int totalItemsServed;
    private Queue<Customer> queue;
    private Customer currentCustomer;

    public Cashier(){
        queue=new ArrayQueue<Customer>();
        customerServed=0;
        totalCustomerWaitTime=0;
        totalItemsServed=0;
    }
    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }
    public int getQueueSize() {
        return queue.size();
    }

    public void serveCustomers(int currentTime) {
        if(currentCustomer==null && queue.isEmpty()) return;
  
        if(currentCustomer==null){
        
        currentCustomer=queue.dequeue();
        
        totalCustomerWaitTime += currentTime -currentCustomer.getArrivalTime();
        
        customerServed++;
    }

  
        currentCustomer.serve();
        if(currentCustomer.getNumberOfItems()==0){
        totalItemsServed += currentCustomer.getNumberOfServedItems();
        currentCustomer=null;
        }
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }
    
    public int getTotalCustomerServed() {
        return customerServed;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }
    public String toString(){
  
        StringBuffer results= new StringBuffer();
      
        results.append("The total number of customers served is: ");
        results.append(customerServed);
      
        results.append("The average number of items per customer is: ");
        results.append(totalItemsServed/customerServed);
      
        results.append("The average waiting time(seconds) is: ");
        results.append(totalCustomerWaitTime/customerServed);
      
        return results.toString();
    }
}