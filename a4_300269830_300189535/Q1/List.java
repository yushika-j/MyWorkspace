/**
* A minimalist description of the Abstract Data Type (ADT) List.  A
* List is a linear abstract data type that places no restrictions on
* accessing the data; inspections, insertions and deletions can occur
* at any position.
*
* @author Guy-Vincent Jourdan and Marcel Turcotte
*/

public interface List<E> {

	void add( int index, E elem );
	void add( E elem );

	E remove( int index );
	boolean remove( E o );

	E get( int index );

	int size();
	boolean isEmpty();
}
