//import java.util.LinkedList;
//import java.util.List;
import java.util.NoSuchElementException;

/**
 * COPYRIGHT MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Mehrdad Sabetzadeh 
 */
public class MyLinkedList<E> {
	private static class Node<T> {
		private T value;
		private Node<T> backward, forward;

		private Node(T value, Node<T> backward, Node<T> forward) {
			this.value = value;
			this.backward = backward;
			this.forward = forward;
		}
	}

	private Node<E> head;
	private Node<E> tail;

	public MyLinkedList(E[] array) {
		//MyLinkedList<E> linkedList = new MyLinkedList<E>(array);
		
			//Node<E> newNode = new Node<E>(array[i], null, null);
			
				if (array == null) {
					throw new NullPointerException("Array contains null value! ");
				}else if (array.length == 0){
					throw new IllegalArgumentException("Length of array cannot be zero!");
				}
			
			head = new Node<E>(array[0],null,null);
			tail = new Node<E>(array[array.length-1],null,null);
			Node<E> current = head;
			for (int i = 0; i < array.length;i++) {
				current.forward = new Node<E>(array[i],current,null);
				current = current.forward;

				if (i == array.length - 1) {
					tail.backward = current.backward;
				}
			// if ( head == null ){ //queue is empty
			// 	head = newNode;
			// } else {
			// 	Node<E> p = head;
			// 	while ( p.forward != null ) {
			// 	p = p.forward;
			// 	}
			// 	p.forward = newNode;
			// }
		}
		

	}

	public void tweak() {
		//throw new UnsupportedOperationException("You need to complete this method!");
		Node<E> current = head;

		if (current == null){
			throw new IllegalArgumentException("Linked list cannot be empty");
		}
		while (current.forward != null) {
			current.forward = current.forward.forward;
			current = current.forward;
		}
		current = tail;
		while (current.backward != head) {
			current.backward = current.backward.backward;
			current = current.backward;
		}
		//current.forward.forward = current.forward.forward.backward.backward;
	}

	public String toString() {

		StringBuffer buffer;
		buffer = new StringBuffer("Forward traversal:  [");

		Node<E> current = head;

		while (current != null) {
			if (current != head) {
				buffer.append("->");
			}
			buffer.append(current.value);
			current = current.forward;
		}

		buffer.append("]");
	
		buffer.append(System.lineSeparator());
	
		buffer.append("Backward traversal: [");

		current = tail;

		while (current != null) {
			if (current != tail) {
				buffer.append("->");
			}
			buffer.append(current.value);
			current = current.backward;
		}
		
		buffer.append("]");

		return buffer.toString();
	}
	
	public Iterator<E> iterator() {
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements Iterator<E> {

		// DEFINE YOUR INSTANCE VARIABLES HERE!
		private Node<E> current;
		MyLinkedList<E> linkedList = new MyLinkedList<E>(null);
        public MyLinkedListIterator() {
			//throw new UnsupportedOperationException("You need to complete this method!");
			//Iterator<E> itr = linkedList.iterator();
			current = null;
        }

	
        public E next() {
			
			if (current == null) {
				current = linkedList.head;
			}else{
				current = current.forward;
			}
			if (current == null) {
				throw new NoSuchElementException();
			}
			return current.value;
        }
        
        public boolean hasNext(){
			return ( ( current == null && linkedList.head != null ) || ( current != null && current.forward != null) );
		}
	}
}