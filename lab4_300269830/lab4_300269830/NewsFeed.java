//import java.util.Arrays;

/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {
    private Post[] messages;
    private int size = 0;
    public static final int MAX_SIZE = 25;
	
    public NewsFeed() {
    	// Your code here.
		size = 0;
		messages = new Post[MAX_SIZE];
    }

    public void add(Post message) {
      // Your code here.
	  
	  if (size < MAX_SIZE) {
		messages[size] = message;
		size++;
	}
	}
	

    public Post get(int index) {
	    return messages[index];
    }

    public int size() {
		// int i=0;
		
		// for ( i = 0;i < 25; i++){
		// 	if (messages[i] != null){
		// 		size++;
		// 	}
		// }
		
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

  	public NewsFeed getPhotoPost(){
		PhotoPost photoPost = new PhotoPost("","","");
        NewsFeed feed = new NewsFeed();
        feed.add(photoPost);
        return feed;
  	}

  	public NewsFeed plus(NewsFeed other){
  	  // Your code here
        int count = other.size();
        NewsFeed combinationFeed = new NewsFeed();
        
        for (int i = 0; i < count; i++) {
            combinationFeed.add(messages[i]);
        }
        
        for (int j = count; j < MAX_SIZE; j++) {
            if (other.get(j) != null) {
                combinationFeed.add(other.get(j));
            } else {
                break;
            }
        }
        
        combinationFeed.sort();
        return combinationFeed;
    }
  	
	  public static void main(String[] args)  throws InterruptedException {

		NewsFeed messages = new NewsFeed();
		PhotoPost msg1;
		TextPost msg2;
	
		Post [] myPosts = new Post[12];
		NewsFeed newsFeed1 = new NewsFeed();
		NewsFeed newsFeed2 = new NewsFeed();
	
	
		for(int i = 0 ; i < 10 ; i++){
			Thread.sleep(400);
	
			if(i >4){
				myPosts[i] = new PhotoPost( "Student" + i, "photo" + i + ".png", "My day #" + i);
				newsFeed1.add(myPosts[i]);
			}
			else{
				myPosts[i] = new TextPost("Student" + i, "My favourite number is " + i);
			}
	
			if(i%3 == 0){
				messages.add(myPosts[i]);
			}
		}
	
		for(int i = 4  ; i >= 0 ; i-- ){
			newsFeed2.add(myPosts[i]);
		}
	
		for(int i = 0  ; i < 50 ; i++ ){
			myPosts[0].like();
			myPosts[9].like();
			myPosts[9].like();
		}
		myPosts[0].like();
		myPosts[9].like();
	
		System.out.println();
		System.out.println("NewsFeed #1 " );
		System.out.println("newsfeed size = " + newsFeed1.size());
		for (int i=0; i < newsFeed1.size(); i++) {
			if(newsFeed1.get(i).isPopular())
				System.out.print("POPULAR : ");
			System.out.println(newsFeed1.get(i));
		}
	
		System.out.println();
		System.out.println("NewsFeed #2 " );
	
		for (int i=0; i < newsFeed2.size(); i++) {
			if(newsFeed2.get(i).isPopular())
				System.out.print("POPULAR : ");
			System.out.println(newsFeed2.get(i));
		}
	
		NewsFeed newsFeed3 = newsFeed1.plus(newsFeed2);
	
		System.out.println();
		System.out.println("NewsFeed #3 = NewsFeed #1 + NewsFeed #2  (sorted) " );
	
		for (int i=0; i < newsFeed3.size(); i++) {
			System.out.println(newsFeed3.get(i));
		}
	
		newsFeed3 = newsFeed3.getPhotoPost();
	
		System.out.println();
		System.out.println("NewsFeed #3 after getPhotoPost()" );
	
		for (int i=0; i < newsFeed3.size(); i++) {
			System.out.println(newsFeed3.get(i));
		}
	}
}
