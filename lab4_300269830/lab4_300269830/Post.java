
import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;
    
    public Post(String userName) {
      // Your code here
      // this.userName = userName;
      // //likes = 0;
      // //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
      // Date date = new Date(System.currentTimeMillis());
      // //System.out.println(formatter.format(date));
      // date.toString();     
      // timeStamp = date;
      // Your code here
      timeStamp = Calendar.getInstance().getTime();
      this.userName = userName; 
    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
	    return timeStamp;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.
    @Override
    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return  str;
    }


  	public int compareTo(Post other){
  		// Your code here.
      return timeStamp.compareTo(other.getTimeStamp());
  	}

  	public boolean isPopular(){
  	  // Your code here.
      if (likes > 100){
        return true;
      }
      return false;
  	}

    @Override
    public int getLikes(){
      return likes;
    }

    @Override
    public void like() {
      likes++;
    }
}

