/**
 * @author Marcel Turcotte, Guy-Vincent Jourdan and Mehrdad Sabetzadeh
 *         (University of Ottawa)
 * 
 *         The implementation of this class is complete. You do *not* need to
 *         change this class in this assignment.
 * 
 */

//TODO:
//1) keep track of size and implement a size() method
//2) write a peek method

public class LinkedQueue<D> implements Queue<D> {

	private int size;

	private static class Elem<T> {
		private T value;
		private Elem<T> next;

		private Elem(T value, Elem<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	private Elem<D> front;
	private Elem<D> rear;

	public LinkedQueue() {
		front = rear = null;
		size = 0;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void enqueue(D newElement) {

		if (newElement == null) {
			throw new NullPointerException("no null object in my queue !");
			// could have been IllegalArgumentException but NPE seems
			// to be the norm
		}

		Elem<D> newElem;
		newElem = new Elem<D>(newElement, null);
		if (isEmpty()) {
			front = newElem;
			rear = newElem;
		} else {
			rear.next = newElem;
			rear = newElem;
		}

		size++;
	}

	public D dequeue() {

		if (isEmpty()) {
			throw new IllegalStateException("Dequeue method called on an empty queue");
		}

		D returnedValue;
		returnedValue = front.value;

		if (front.next == null) {
			front = rear = null;
		} else {
			front = front.next;
		}

		size--;

		return returnedValue;
	}

	public D peek() {

		if (isEmpty()) {
			throw new IllegalStateException("Peek method called on an empty queue");
		}

		return front.value;
	}

	public int size() {
		return size;
	}

	public String toString() {

		StringBuffer returnedValue = new StringBuffer("[");

		if (!isEmpty()) {
			Elem<D> cursor = front;
			returnedValue.append(cursor.value);
			while (cursor.next != null) {
				cursor = cursor.next;
				returnedValue.append(", " + cursor.value);
			}
		}

		returnedValue.append("]");
		return returnedValue.toString();

	}
}
