import java.util.NoSuchElementException;

public class LinkedGrid<E> {
	public static class Node<T> {
		private T data;
		private Node<T> right, down;

		Node(T data, Node<T> right, Node<T> down) {
			this.data = data;
			this.right = right;
			this.down = down;
		}

		public T getData() { return data;}
		public Node<T> getRight(){ return right; }
		public Node<T> getDown(){ return down;}
	}

	private Node<E> topLeft;
	private int rowCount, columnCount;

	public LinkedGrid(E[] array) {
		if (array == null)
			throw new NullPointerException("array cannot be null");
		if (array.length == 0)
			throw new IllegalArgumentException("array must contain elements");

		// Add your code here

 		throw new UnsupportedOperationException( "not implemented yet!" );
		
	}

	private void addFirstRow(E[] array) {

		if (!isEmpty())
			throw new IllegalStateException("Grid must be empty to add a first row");

		// Add your code here

 		throw new UnsupportedOperationException( "not implemented yet!" );
	}

	public void addRow(E[] array) {
		if (array == null)
			throw new NullPointerException("array cannot be null");
		if (rowCount == 0)
			throw new IllegalStateException("Need to add first row first");
		if (array.length != this.columnCount)
			throw new IllegalArgumentException("array must contain contain " + this.columnCount + " elements");

		// Add your code here

 		throw new UnsupportedOperationException( "not implemented yet!" );


	}

	public LinkedGrid(E[][] array) {

		if (array == null)
			throw new NullPointerException("array cannot be null");

		// Add your code here

 		throw new UnsupportedOperationException( "not implemented yet!" );

	}

	public int getRowCount() {
		return rowCount;
	}
	
	public int getColumnCount() {
		return columnCount;
	}
	
	public boolean isEmpty() {
		return topLeft == null;
	}

	public Node<E> getTopLeft(){
		return topLeft;
	}

	public E getElementAt(int row, int column) {
		if (row < 0 || row >=  rowCount || column < 0 || column >= columnCount)
			throw new IllegalArgumentException("The row and column parameters both have to be within range");

		// Add your code here

 		throw new UnsupportedOperationException( "not implemented yet!" );

	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				buffer.append(getElementAt(i, j));
				if (j < columnCount - 1)
					buffer.append(", ");
			}
			if (i < rowCount - 1)
				buffer.append(System.lineSeparator());
		}

		return buffer.toString();

	}

	private class LinkedGridIterator implements Iterator<E> {

		// ADD you instance variables here
 
        public LinkedGridIterator() {

        	// ADD your code here
        }

        public E next() {

			// Add your code here

	 		throw new UnsupportedOperationException( "not implemented yet!" );
        }

        public boolean hasNext(){
			// Add your code here

	 		throw new UnsupportedOperationException( "not implemented yet!" );
		}

	}

	public Iterator<E> iterator() {
		return new LinkedGridIterator();
	}
}
