
public class ArrayStack<E> implements Stack<E> {


    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private int capacity;    // Designates the capacity of the Array
    public static final int DEFAULT_INC = 25;

    @SuppressWarnings( "unchecked" )

    // Constructor

    public ArrayStack( int capacity ) {
        if(capacity < DEFAULT_INC)
            capacity = DEFAULT_INC;
         elems = (E[]) new Object[ capacity ];
         top = 0;
     }

    // Returns true if this ArrayStack is empty

    public boolean isEmpty() {

        // Same as:
        // if ( top == 0 ) {
        //     return true;
        // } else {
        //     return false;
        // }

        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() {

        // pre-conditions: ! isEmpty()

        return elems[ top-1 ];
    }

    // Removes and returns the top element of this stack

    public E pop() {

        // pre-conditions: ! isEmpty()

        // *first* decrements top, then access the value!
        E saved = elems[ --top ];

        elems[ top ] = null; // scrub the memory!

        return saved;
    }

    // Puts the element onto the top of this stack.

        public void push(E element) throws FullStackException {
            if(top >= elems.length) {
                throw new FullStackException();
            }
            elems[top++] = element;
        }
    


    // Gets current capacity of the array (for testing purpose)
    public int getCapacity() {
        return elems.length;
    }


    //@SuppressWarnings( "unchecked" )

    // Add clear method.
    public void clear() {
        top = 0;
        for (int i = 0; i < capacity;i++) {
            elems[i] = null;
        }
    }
}