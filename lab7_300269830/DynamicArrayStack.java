import java.util.EmptyStackException;

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
        
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elems[top - 1];    }

    //@SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elems[--top];
    }

    //@SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.
        if (top == elems.length) {
            resize();
        }
        // increments top, stores the element at position top
        elems[top++] = element;
    }
    
    @SuppressWarnings("unchecked")
    public void resize() {
        int newSize = (int) (elems.length * 2);
        E[] newElems = (E[]) new Object[newSize];
        System.arraycopy(elems, 0, newElems, 0, elems.length);
        elems = newElems;
    }
    //@SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here
        top = 0;
    }

}