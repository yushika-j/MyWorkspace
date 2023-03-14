public class TextPost extends Post {

    private String message;

    public TextPost(String userName, String message) {
      // Your code here.
      super(userName);
      this.message = message;
    }

    public String getMessage() {
	     return message;
    }

    @Override
    public String toString() {
    	String str = new String();
    	str = super.toString() + ", " + message;
    	return  str;
    }
    @Override
  	public boolean isPopular() {
  		// Your code here.
      if (super.getLikes() > 50){
        return true;
      }else{
        return false;
      }
  	}

}
