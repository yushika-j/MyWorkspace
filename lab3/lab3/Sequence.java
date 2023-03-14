
// import net.datastructures.*; // copied positionalList from net.datastructes.*

/****
 * 
 * An interface for Sequence 
 * it contains methods for PositionalList, List (called ArrayList ADT in class) plus bridge methods
 * 
 * Created for csi2110 Lab3
 * 
 * @author Lucia Moura
 *
 */


public interface Sequence<E> extends PositionalList<E>,List<E> {
 
	Position<E> positionAtIndex(int i);
	
	int indexAtPosition(Position<E> pos);
	

}
