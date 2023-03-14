import java.util.NoSuchElementException;

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
        // if key or value is null, throwing NullPointerException
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
      }
      if (count == elems.length) {
            increaseCapacity();
      }
      elems[count] = new Pair(key, value);
      count++;
    }

    private void increaseCapacity() {
        /* Your code here.  Use this in put() where necessary. */
        Pair[] temp = new Pair[elems.length+INCREMENT];
        // copying elements from old array to new

        System.arraycopy(elems, 0, temp, 0, count);

        // replacing old with new

        elems = temp;
    }

    @Override
        
        public boolean contains(String key) {
            /* Your code here. */
            if (key == null) {
                  // key is null
                  throw new NullPointerException("key is null");
            }
            // loop and check if key exists
            for (int i = 0; i < count; i++) {
                  if (elems[i].getKey().equals(key)) {
                        // found
                        return true;
                  }
            }
            // not found
            return false;
    }

    //@Override
    public Integer get(String key) {
        /* Your code here. */
        if (key == null) {
            throw new NullPointerException("key is null");
      }
      for (int i = 0; i < count; i++) {
            if (elems[i].getKey().equals(key)) {
                  // found, returning value
                  return elems[i].getValue();
            }
      }
      // not found, throwing NoSuchElementException
      throw new NoSuchElementException("key not found");
    }

    @Override
    public void replace(String key, Integer value) {
        /* Your code here. */
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }
        for (int i = 0; i < count; i++) {

            if (elems[i].getKey().equals(key)) {
                  // replacing old value with new one
                  elems[i].setValue(value);
                  
            }
      }
    }

    public Integer remove(String key) {
        /* Your code here. */
        if (key == null) {
            throw new NullPointerException("key is null");
      }
      for (int i = 0; i < count; i++) {
            if (elems[i].getKey().equals(key)) {
                  // found
                  Integer value = elems[i].getValue();
                  for (int j = i; j < count - 1; j++) {
                        elems[j] = elems[j + 1];
                  }
                  //update count
                  count--;
                  return value; //returning removed value
            }
      }
      // not found, throwing NoSuchElementException
      throw new NoSuchElementException("key not found");

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