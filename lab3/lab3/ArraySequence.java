

//import net.datastructures.*; //copied ArrayList from net.datastructures.*

/**
 * An implementation of Sequence based on ArrayList
 * Only PositionalList methods and bridge methods in Sequence interface need to be provided
 * 
 * Warning: Iterable<Position<E>> positions() method has not been implemented !!!!
 * 
 * Created for csi2110 Lab3, Fall 2021
 * 
 * @author Lucia Moura
 *
 */

public class ArraySequence<E> extends ArrayList<E> implements Sequence<E> {
	
    ArrayList<Index> posList;
    
    /**
     * 
     * inner class that stores Position 
     *
     */
    private class Index implements Position<E> {
    	int index;
    	public Index(int i) {
    		index=i;
    	}
    	int index() {   return index;  }
  
		public E getElement() { return  get(index); // using get from ArrayList<E>
    	}
    	
    	private void setIndex( int i) {	index=i; }
    
    }
    
	// To implement Sequence we need to store Position<E> for each element
    // we artificially create positions that simply stores the index of an object
    public ArraySequence() {
    	posList = new ArrayList<Index>(); // position in an array sequence Index<E> 
    	                                  // which stores index in ArrayList<E>
    	
    }
	
    public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException { 
  	  if (i<0 || i>= size()) { // 
		  throw new  IndexOutOfBoundsException("Index i="+i+" is not in the list");
	  }
      return posList.get(i);
    } 
	
   
	public int indexAtPosition(Position<E> pos) throws IllegalArgumentException {
		if (!(pos instanceof ArraySequence.Index))  throw new IllegalArgumentException("position is instance of ArraySequence.Index");
		Index posi= (Index) pos;
		int i =posi.index();
		if (i<0 || i>= size()) throw new IllegalArgumentException("position is not in the list");
		return i;
	} 
	


  /**
   * Returns the first Position in the list.
   *
   * @return the first Position in the list (or null, if empty)
   */
  public Position<E> first() {return positionAtIndex(0); }

  /**
   * Returns the last Position in the list.
   *
   * @return the last Position in the list (or null, if empty)
   */
  public Position<E> last() {return positionAtIndex(size()-1); }

  /**
   * Returns the Position immediately before Position p.
   * @param p   a Position of the list
   * @return the Position of the preceding element (or null, if p is first)
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  public Position<E> before(Position<E> p)  {
	  int i=indexAtPosition(p);
	  if (i==0) return null;
	  return positionAtIndex(i-1);
  }

  /**
   * Returns the Position immediately after Position p.
   * @param p   a Position of the list
   * @return the Position of the following element (or null, if p is last)
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  public Position<E> after(Position<E> p) {
	  int i=indexAtPosition(p);
	  if (i==size()-1) return null;
	  return positionAtIndex(i+1);
  }
  
  
  // auxiliary private method for insertions at position
  private Position<E> addAtPos(int i, E e)  { 
	  super.add(i,e);
	  posList.add(i,new Index(i));
	  for(int j=i+1; j<posList.size(); j++) { posList.get(j).setIndex(j);}
	  return posList.get(i);
  }
  
  
  /**
   * Inserts the given element at the specified index of the list, shifting all
   * subsequent elements in the list one position further to make room.
   * @param  i   the index at which the new element should be stored
   * @param  e   the new element to be stored
   * @throws IndexOutOfBoundsException if the index is negative or greater than size()
   */
  @SuppressWarnings("unused")
public void add(int i, E e) throws IndexOutOfBoundsException {
	  if (i<0 || i> size()) { // 
		  throw new  IndexOutOfBoundsException("Index="+i+" is not in the list");
	  }
	  Position<E> unused=addAtPos(i,e); 
  }
  
  /* copied from LinkedPositional...
	public void add(int i, E e){ // insert a new element which will have index i 
		if (i==size()) {
			this.addLast(e);
		}
		else {
		   Position<E> pos=positionAtIndex(i);
		   this.addBefore(pos,e);	
		}    
	}
	*/

  /**
   * Inserts an element at the front of the list.
   *
   * @param e the new element
   * @return the Position representing the location of the new element
   *
   */
  public Position<E> addFirst(E e) {
	 return addAtPos(0,e); 
  }	  

  /**
   * Inserts an element at the back of the list.
   *
   * @param e the new element
   * @return the Position representing the location of the new element
   */
  public Position<E> addLast(E e) {
	     int size=size();
	     return addAtPos(size,e); 		  
	  }  

  /**
   * Inserts an element immediately before the given Position.
   *
   * @param p the Position before which the insertion takes place
   * @param e the new element
   * @return the Position representing the location of the new element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  public Position<E> addBefore(Position<E> p, E e) {
	  int i=indexAtPosition(p);
	  return addAtPos(i,e);
  }

  /**
   * Inserts an element immediately after the given Position.
   *
   * @param p the Position after which the insertion takes place
   * @param e the new element
   * @return the Position representing the location of the new element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  public Position<E> addAfter(Position<E> p, E e) {
	  int i=indexAtPosition(p);
	  return addAtPos(i+1,e);
  }	  
	  
	 

  /**
   * Replaces the element stored at the given Position and returns the replaced element.
   *
   * @param p the Position of the element to be replaced
   * @param e the new element
   * @return the replaced element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  public E set(Position<E> p, E e) {
	  int i=indexAtPosition(p);
	  return set(i, e);
  }
  
  
  // auxiliary private method  for removals at position
  private E removeAtPos(int i) { 
	  posList.remove(i); // remove from the variable ArrayList<Index>
	  for(int j=i; j<posList.size(); j++) { posList.get(j).setIndex(j);} // correct the index of cells that moved back
	  return super.remove(i); // remove from this ArrayList<E> returning the removed element
  }
  


  /**
   * Removes and returns the element at the given index, shifting all subsequent
   * elements in the list one position closer to the front.
   * @param  i   the index of the element to be removed
   * @return the element that had be stored at the given index
   * @throws IndexOutOfBoundsException if the index is negative or greater than size()
   */
  public E remove(int i) throws IndexOutOfBoundsException {
	  if (i<0 | i>=size()) throw new IndexOutOfBoundsException("Index="+i+" is out of bounds");
	  return removeAtPos(i);
  }

  /**
   * Removes the element stored at the given Position and returns it.
   * The given position is invalidated as a result.
   *
   * @param p the Position of the element to be removed
   * @return the removed element
   * @throws IllegalArgumentException if p is not a valid position for this list
   */
  public E remove(Position<E> p) throws IllegalArgumentException {
	  int i=indexAtPosition(p);
	  return removeAtPos(i);
  }


  /**
   * Returns the positions of the list in iterable form from first to last.
   * @return iterable collection of the list's positions
   */
  public Iterable<Position<E>> positions() {
 	return null; //**** warning this has not been implemented !!! iterating via positions will cause a bug
  
  }


}
