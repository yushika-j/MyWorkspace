public class ITIStringBuffer {

    SinglyLinkedList currentstring = new SinglyLinkedList<E>();
    private String firststring;

    public ITIStringBuffer() {
        currentstring = null;
        
    }

    public ITIStringBuffer(String  firstString){
        this.firststring = firstString;
        currentstring.add(firstString);
    }

    public void append(String nextString){
        currentstring.add(nextString);

    }

    public String toString(){
        if (currentstring == null){
            throw new NullPointerException("There's no string");
        } else {
            for (int i = 0; i <= (currentstring).size(); i++){

                currentstring.add(firststring);
                    
            }
        }

    }

}
