public class TextPost extends Post {

    private String message;

    public TextPost(String userName, String message) {
      // Your code here.
      super(username);
      this.message=messages;
    }

    public String getMessage() {
	     return message;
    }

    public String toString() {
    	String str = new String();
    	str = super.toString() + ", " + message;
    	return  str;
    }

  	public boolean isPopular() {
  		// Your code here.
      return popular;
  	}

}
