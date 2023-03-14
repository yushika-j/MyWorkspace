
/*
* Class created for use in CSI2110 labstack.
* Implements a stack using a singly linked list. 
* The package net.datastructures developped by Tamasia et al. 
* contains a different implementation of LinkedStack
* that "adapts" a class LinkedList also given in that package.
* You can compare this class with that one.
*/

public class LinkedStack<E> implements Stack<E> {

  // ---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its element and to
   * the subsequent node in the list (or null if this is the last node).
   */
  private static class Node<E> {
    private E element; // reference to the element stored at this node
    private Node<E> next; // reference to the subsequent node in the list
    
    /**
     * Creates a node with the given element and next node.
     */

    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }

    // Modifier method
    public void setNext(Node<E> n) {
      next = n;
    }
  } // ----------- end of nested Node class -----------

  // instance variables of the LinkedStack

  private Node<E> head = null;

  private int size = 0; // number of nodes in the stack

  /** Constructs an initially empty stack. */
  public LinkedStack() {
  } // new stack is initially empty

  /**
   * Returns the number of elements in the stack.
   * 
   * @return number of elements in the stack
   */
  public int size() {
    return size;
  }

  /**
   * Tests whether the stack is empty.
   * 
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Inserts an element at the top of the stack.
   * 
   * @param element the element to be inserted
   */
  public void push(E element) {
    Node<E> temp = new Node<E>(element,null);
    size++;
    // this is a dummy method now; it needs to be implemented <<<<<<<<<<<<<<<
    
  }

  /**
   * Returns, but does not remove, the element at the top of the stack.
   * 
   * @return top element in the stack (or null if empty)
   */
  public E top() {
    return null; // this is a dummy method now; it needs to be implemented <<<<<<<<<<<<<<<
  }

  /**
   * Removes and returns the top element from the stack.
   * 
   * @return element removed (or null if empty)
   */
  public E pop() {
    return null; // this is a dummy method now; it needs to be implemented <<<<<<<<<<<<<<<
  }

  /**
   * Produces a string representation of the contents of the stack. (ordered from
   * top to bottom)
   *
   * This exists for debugging purposes only.
   *
   * @return textual representation of the stack
   */
  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk.getNext() != null)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }

  /** Demonstrates sample usage of a stack. For testing purposestack. */
  public static void main(String[] args) {
    Stack<Integer> stack = new LinkedStack<>(); // contents: ()
    stack.push(5); // contents: (5)
    stack.push(3); // contents: (5, 3)
    System.out.println(stack.size()); // contents: (5, 3) outputs 2
    System.out.println(stack.pop()); // contents: (5) outputs 3
    System.out.println(stack.isEmpty()); // contents: (5) outputs false
    System.out.println(stack.pop()); // contents: () outputs 5
    System.out.println(stack.isEmpty()); // contents: () outputs true
    System.out.println(stack.pop()); // contents: () outputs null
    stack.push(7); // contents: (7)
    stack.push(9); // contents: (7, 9)
    System.out.println(stack.top()); // contents: (7, 9) outputs 9
    stack.push(4); // contents: (7, 9, 4)
    System.out.println(stack.size()); // contents: (7, 9, 4) outputs 3
    System.out.println(stack.pop()); // contents: (7, 9) outputs 4
    stack.push(6); // contents: (7, 9, 6)
    stack.push(8); // contents: (7, 9, 6, 8)
    System.out.println(stack.pop()); // contents: (7, 9, 6) outputs 8
  }

}
