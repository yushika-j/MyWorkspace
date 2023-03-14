/**
 * @author Marcel Turcotte, Guy-Vincent Jourdan and Mehrdad Sabetzadeh
 *         (University of Ottawa)
 * 
 *         The declaration of this interface is complete. You do *not* need to
 *         change this interface in this assignment.
 * 
 */

public interface Queue<E> {
	boolean isEmpty();

	void enqueue(E newElement);

	E dequeue();
}
