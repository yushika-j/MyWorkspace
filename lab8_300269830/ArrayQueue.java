// -*- Mode: Java -*- 
// ArrayQueue.java --- simple implementation of a queue, fixed size, 
// moves the queue to the start of the array whenever it reaches the end
// Author          : Marcel Turcotte
// Created On      : Mon Mar  8 20:52:03 2004
// Last Modified By: Marcel Turcotte
// Last Modified On: Sat Mar  3 07:58:44 2007
// ITI 1121/1521. Introduction to Computer Science II

public class ArrayQueue<E> implements Queue<E> {

    // Constant

    private static final int MAX_QUEUE_SIZE = 10000;

    // Instance variables

    private E[] elems; // stores the elements of this queue
    private int front, rear, size;

    @SuppressWarnings( "unchecked" )

    public ArrayQueue() {
        elems = (E []) new Object[MAX_QUEUE_SIZE];
        front =  0;
        rear = -1;
        size = 0;
    }

    // Instance methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_QUEUE_SIZE;
    }
    
    public void enqueue( E elem ) {

        // pre-condition: ???

        if ( rear == ( MAX_QUEUE_SIZE -1 ) ) {
            
            int j=0;
            for ( int i=front; i<=rear; i++ ) {
                elems[ j++ ] = elems[ i ];
            }

            front = 0;
            rear = size - 1;

        }

        elems[ ++rear ] = elem;
        size++;
    }

    public E dequeue() {

        // pre-condition: ???

        E saved = elems[ front ];
        elems[ front ] = null; // scrubbing the memory!

        front++;
        size--;

        return saved;
    }

}