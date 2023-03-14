public class Q1Test {


	public static void testFirstConstructor(){

		Integer[] integerFirstRow = { 0, 1, 2 };
		Integer[] integerSecondRow = { 3, 4, 5 };
		Integer[] integerThirdRow = { 6, 7, 8 };

		LinkedGrid<Integer> integerGrid = new LinkedGrid<Integer>(integerFirstRow);
		integerGrid.addRow(integerSecondRow);
		integerGrid.addRow(integerThirdRow);


		System.out.println("==== Integer grid with " + integerGrid.getRowCount() + 
			" rows x " + integerGrid.getColumnCount() + " columns ====");
		System.out.println("[Test LinkedGrid(E[] array) / addFirstRow(...) and addRow(...)]");
		System.out.println("getTopLeft().getData(): " + integerGrid.getTopLeft().getData());
		System.out.println("getTopLeft().getRight().getRight().getDown().getData(): " + integerGrid.getTopLeft().getRight().getRight().getDown().getData());
		System.out.println("getTopLeft().getDown().getDown().getData(): " + integerGrid.getTopLeft().getDown().getDown().getData());
		System.out.println("getTopLeft().getDown().getRight().getDown().getRight().getData(): " + integerGrid.getTopLeft().getDown().getRight().getDown().getRight().getData());
		System.out.println();

		System.out.println("[Test getElementAt(...)] Print integer grid via toString() which uses getElementAt(...)");
		System.out.println(integerGrid);
		System.out.println();

		System.out.println("[Test LinkedGridIterator] Print integer grid via an iterator");
		Iterator<Integer> iIterator = integerGrid.iterator();

		StringBuffer iBuffer = new StringBuffer();
		while (iIterator.hasNext()) {
			iBuffer.append(iIterator.next());
			if (iIterator.hasNext())
				iBuffer.append(", ");
		}

		System.out.println(iBuffer);
		System.out.println();

		String[] stringFirstRow = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M" };
		String[] stringSecondRow = { "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		LinkedGrid<String> stringGrid = new LinkedGrid<String>(stringFirstRow);
		stringGrid.addRow(stringSecondRow);
		System.out.println("==== String grid with " + stringGrid.getRowCount() + 
			" rows x " + stringGrid.getColumnCount() + " columns ====");

		System.out.println("[Test LinkedGrid(E[] array) / addFirstRow(...) and addRow(...)]");
		System.out.println("getTopLeft().getData(): " + stringGrid.getTopLeft().getData());
		System.out.println("getTopLeft().getRight().getRight().getRight().getRight().getDown().getData(): " + stringGrid.getTopLeft().getRight().getRight().getRight().getRight().getDown().getData());
		System.out.println("getTopLeft().getDown().getRight().getData(): " + stringGrid.getTopLeft().getDown().getRight().getData());
		System.out.println("getTopLeft().getDown().getRight().getRight().getRight().getRight().getRight().getRight().getData(): " + stringGrid.getTopLeft().getDown().getRight().getRight().getRight().getRight().getRight().getRight().getData());
		System.out.println();


		System.out.println("[Test getElementAt(...)] Print string grid via toString() which uses getElementAt(...)");
		System.out.println(stringGrid);
		System.out.println();

		System.out.println("[Test LinkedGridIterator] Print string grid via an iterator");
		Iterator<String> sIterator = stringGrid.iterator();

		StringBuffer sBuffer = new StringBuffer();
		while (sIterator.hasNext()) {
			sBuffer.append(sIterator.next());
			if (sIterator.hasNext())
				sBuffer.append(", ");
		}

		System.out.println(sBuffer);
	}

	public static void testSecondConstructor(){
		Integer[][] integerArray = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };

		LinkedGrid<Integer> integerGrid = new LinkedGrid<Integer>(integerArray);

		System.out.println("==== Integer grid with " + integerGrid.getRowCount() + 
			" rows x " + integerGrid.getColumnCount() + " columns ====");
		System.out.println("[Test LinkedGrid(E[][] array)]");
		System.out.println("getTopLeft().getData(): " + integerGrid.getTopLeft().getData());
		System.out.println("getTopLeft().getRight().getRight().getDown().getData(): " + integerGrid.getTopLeft().getRight().getRight().getDown().getData());
		System.out.println("getTopLeft().getDown().getDown().getData(): " + integerGrid.getTopLeft().getDown().getDown().getData());
		System.out.println("getTopLeft().getDown().getRight().getDown().getRight().getData(): " + integerGrid.getTopLeft().getDown().getRight().getDown().getRight().getData());
		System.out.println();

		System.out.println("[Test getElementAt(...)] Print integer grid via toString() which uses getElementAt(...)");
		System.out.println(integerGrid);
		System.out.println();

		System.out.println("[Test LinkedGridIterator] Print integer grid via an iterator");
		Iterator<Integer> iIterator = integerGrid.iterator();

		StringBuffer iBuffer = new StringBuffer();
		while (iIterator.hasNext()) {
			iBuffer.append(iIterator.next());
			if (iIterator.hasNext())
				iBuffer.append(", ");
		}

		System.out.println(iBuffer);
		System.out.println();

		String[][] stringArray = { { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M" },
				{ "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" } };

		LinkedGrid<String> stringGrid = new LinkedGrid<String>(stringArray);

		System.out.println("==== String grid with " + stringGrid.getRowCount() + 
			" rows x " + stringGrid.getColumnCount() + " columns ====");

		System.out.println("[Test LinkedGrid(E[][] array)]");
		System.out.println("getTopLeft().getData(): " + stringGrid.getTopLeft().getData());
		System.out.println("getTopLeft().getRight().getRight().getRight().getRight().getDown().getData(): " + stringGrid.getTopLeft().getRight().getRight().getRight().getRight().getDown().getData());
		System.out.println("getTopLeft().getDown().getRight().getData(): " + stringGrid.getTopLeft().getDown().getRight().getData());
		System.out.println("getTopLeft().getDown().getRight().getRight().getRight().getRight().getRight().getRight().getData(): " + stringGrid.getTopLeft().getDown().getRight().getRight().getRight().getRight().getRight().getRight().getData());
		System.out.println();


		System.out.println("[Test getElementAt(...)] Print string grid via toString() which uses getElementAt(...)");
		System.out.println(stringGrid);
		System.out.println();

		System.out.println("[Test LinkedGridIterator] Print string grid via an iterator");
		Iterator<String> sIterator = stringGrid.iterator();

		StringBuffer sBuffer = new StringBuffer();
		while (sIterator.hasNext()) {
			sBuffer.append(sIterator.next());
			if (sIterator.hasNext())
				sBuffer.append(", ");
		}

		System.out.println(sBuffer);		
	}

	public static void main(String[] args) {
		testFirstConstructor();
		testSecondConstructor();

	}
}
