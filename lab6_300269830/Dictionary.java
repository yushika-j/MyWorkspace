public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        /* Your code here */
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        /* Your code here */
        if (count == elems.length) {
            increaseCapacity();
        }
        elems[count] = new Pair(key,value);
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
        Pair[] temp = new Pair[elems.length+INCREMENT];
       int j=count-1;
       while(j>=0)
       {
           temp[j]=elems[j];
           j--;
       }
       elems=temp;
    }

    //@Override
    public boolean contains(String key) {
        /* Your code here. */
        int i=count-1;
       while(i>=0){
           if(elems[i].getKey().equals(key))
               return true;
           i--;
       }
       return false;
    }

    //@Override
    public Integer get(String key) {
        /* Your code here. */
        int i=count-1;
        while(i>=0)
        {
            if(elems[i].getKey().equals(key))
                return elems[i].getValue();
            i--;
        }
        return -1; 
    }

    //@Override
    public void replace(String key, Integer value) {
        /* Your code here. */
        int i=count-1;
        while(i>=0)
        {
            if(elems[i].getKey().equals(key))
            {
                elems[i].setValue(value);
                return ;
            }
            i--;
        }
    }

    
    public Integer remove(String key) {
        /* Your code here. */
        int i=count-1;
        while(i>=0)
        {
            if(elems[i].getKey().equals(key))
            {
                Integer temp=elems[i].getValue();
                elems[i]=elems[count-1]; // copy it with last element and decrease the count by 1;
                count--;
                return temp;
            }
            i--;
        }
        return -1; 
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}