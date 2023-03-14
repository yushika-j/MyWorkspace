//import java.util.NoSuchElementException;

public class OrderedList<E extends Comparable<E>> implements OrderedStructure<E> {
    // Implementation of the doubly linked nodes (nested-class)

    private static class Node<E> {

      	private Comparable<E> value;
      	private Node<E> previous;
      	private Node<E> next;

      	private Node ( Comparable<E> value, Node<E> previous, Node<E> next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node<E> head;

    // Representation of the empty list.

    public OrderedList() {
        // Your code here.
        head = new Node<E>(null, null, null);
    }

    // Calculates the size of the list

    public int size() {
      	// Remove line below and add your implementation.
        //throw new UnsupportedOperationException( "not implemented yet!" );
        int count = 0;
        Node<E> pointer = head.next;
        while (pointer != null ) {
            count++;
            pointer= pointer.next;
        }
        return count;
    }
    


    public Object get( int pos ) {
        // Remove line below and add your implementation.
        Node<E> ptr = head.next;
        while(ptr != null && pos != 0) {
                pos--;
                ptr = ptr.next;
        }
        if(pos == 0 && ptr != null) {
            return ptr.value;
        }
        return null;
    }

    // Adding an element while preserving the order

    public boolean add(Comparable o ) {
        // Remove line below and add your implementation.
        Node<E> prev = head;
        
        while(prev.next != null && prev.next.value.compareTo((E) o) < 0) {
                prev = prev.next;
        }
        
        prev.next = new Node<E>(o, prev, prev.next);
        if(prev.next.next != null) {
                prev.next.next.previous = prev.next.next;
        }
        
        return true;
        //throw new UnsupportedOperationException( "not implemented yet!" );
    }
    private void addAfter(Node<E> oldNode, Comparable<E> value) {
        Node<E> newNode = new Node<>(value, oldNode, oldNode.next);
        if(oldNode.next != null) {
                oldNode.next.previous = newNode;
        }
        oldNode.next = newNode;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
      // Remove line below and add your implementation.
      Node<E> prev = head;
      Node<E> ptr = head.next;
      while(ptr != null && pos != 0) {
              pos--; prev = ptr; ptr = ptr.next;
      }
      
      if(pos == 0 && ptr != null) {
              prev.next = ptr.next;
              if(ptr.next != null) {
                      ptr.previous = prev;
              }
      }
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList<E> other ) {
      // Remove line below and add your implementation.
      Node<E> prev1 = head;
      Node<E> start1 = head.next;
      Node<E> start2 = other.head.next;
      
      while(start2 != null) {
              // we need to insert start2 value.
              while(start1 != null && start1.value.compareTo((E) start2.value) < 0) {
                      prev1 = start1;
                      start1 = start1.next;
              }
              addAfter(prev1, start2.value);
              start1 = prev1.next;
              start2 = start2.next;
      }
    }
    public static void main(String args[]) {
        OrderedList<Integer> list1 = new OrderedList<>();
        list1.add(8);
        list1.add(18);
        list1.add(16);
        list1.add(23);
        list1.add(3);
        list1.add(7);
        
        System.out.println(list1);
        
        // remember remove taks position, not value
        list1.remove(0);
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);
        System.out.print("List1: ");
        System.out.println(list1);

        OrderedList<Integer> list2 = new OrderedList<>();
        list2.add(8);
        list2.add(18);
        list2.add(13);
        list2.add(71);
        list2.add(9);
        list2.add(15);
        System.out.print("List2: ");
        System.out.println(list2);
        
        list1.merge(list2);

        System.out.print("Merged List: ");
        System.out.println(list1);
}
}
