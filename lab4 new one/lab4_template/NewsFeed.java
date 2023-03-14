/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() { //Default constructor

    	// Your code here.
		messages =  new Post[MAX_SIZE];
		size = 0;
		
    }

    public void add(Post message) {
      // Your code here.
	  if(size == MAX_SIZE){
		  System.out.println("has reached max size.. //give a meaningful message according to you ");
		  return;
	  }

	  messages[size++]=message;
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
	     return size;
    }

	  public void sort(){
			int i, j, argMin;
			Post tmp;
			for (i = 0; i < size - 1; i++) {
				argMin = i;
				for (j = i + 1; j < size(); j++) {
					if (messages[j].compareTo(messages[argMin]) < 0) {
						argMin = j;
					}
				}

  			tmp = messages[argMin];
  			messages[argMin] = messages[i];
  			messages[i] = tmp;
		  }

	  }

  	public NewsFeed getPhotoPost(){/* these are getter or accessors it should return a values*/
  		// Your code here

  	}

  	public NewsFeed plus(NewsFeed other){

  	  // Your code here
  	}

}
