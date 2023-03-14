public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
        super();
        top = 0;
        elems = (E[]) new Object[ DEFAULT_INC ];
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    //@SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
        E saved = null;
        if (top > DEFAULT_INC){
            saved = elems[ --top ];

            elems[ top ] = null; // scrub the memory!
        }else{
            System.out.println("Stack Underflow");
        }
        return saved;
    }

    //@SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.
        if (top < getCapacity()) {
        elems[ top++ ] = element;
        }else{
            System.out.println("Stack overflow");
        }
    }

    //@SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        for (int i = 0; i< elems.length; i++){
            elems[i] = null;
        }
    }

}