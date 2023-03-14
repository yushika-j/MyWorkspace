/**
 * COPYRIGHT MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Mehrdad Sabetzadeh 
 */
public class Q1Test {
	public static void main(String args[]) {
		testQ1_1();
		testQ1_2();
		testQ1_3(); 
	}
	
	public static void testQ1_1() {
		System.out.println("============= Testing Q1.1 =============");
		
		System.out.println("String array: {\"A\", \"B\", \"C\", \"D\"}");
		String[] array = {"A", "B", "C", "D"};
		MyLinkedList<String> l = new MyLinkedList<String>(array);
		System.out.println(l);
		System.out.println();
		
		System.out.println("Integer array: {5, 10, 15, 20, 25}");
		Integer[] array2 = {5, 10, 15, 20, 25};
		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>(array2);
		System.out.println(l2);
		System.out.println();
		
		System.out.println("Integer array (single element): {10}");	
		Integer[] array3 = {10};
		MyLinkedList<Integer> l3 = new MyLinkedList<Integer>(array3);
		System.out.println(l3);
		System.out.println();
		
		System.out.println("Integer array (two elements): {10, 20}");	
		Integer[] array4 = {10, 20};
		MyLinkedList<Integer> l4 = new MyLinkedList<Integer>(array4);
		System.out.println(l4);
		System.out.println();

		boolean exceptionThrown = false;
		try {
			System.out.println("Integer array (no element): {}");	
			Integer[] array5 = {};
			MyLinkedList<Integer> l5 = new MyLinkedList<Integer>(array5);
			System.out.println(l5);
		} catch (Exception e) {
			exceptionThrown = true;
		}
		if (exceptionThrown) {
			System.out.println("Hurray! An exception was thrown for empty array.");
		}
		else {
			System.out.println("Oops! You are supposed to throw an exception for an empty or null array.");		
		}
		System.out.println();
	}

	public static void testQ1_2() {
		System.out.println("============= Testing Q1.2 =============");
		
		System.out.println("String array: {\"A\", \"B\", \"C\", \"D\"}");
		String[] array = {"A", "B", "C", "D"};
		MyLinkedList<String> l = new MyLinkedList<String>(array);
		System.out.println(">>>>> Original array toString():");
		System.out.println(l);
		System.out.println();
		System.out.println(">>>>> Tweaked array toString():");
		l.tweak();		
		System.out.println(l);
		System.out.println();
		
		System.out.println("Integer array: {5, 10, 15, 20, 25}");
		Integer[] array2 = {5, 10, 15, 20, 25};
		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>(array2);
		System.out.println(">>>>> Original array toString():");
		System.out.println(l2);
		System.out.println();
		System.out.println(">>>>> Tweaked array toString():");
		l2.tweak();		
		System.out.println(l2);
		System.out.println();
		
		System.out.println("Integer array (single element): {10}");	
		Integer[] array3 = {10};
		MyLinkedList<Integer> l3 = new MyLinkedList<Integer>(array3);
		System.out.println(">>>>> Original array toString():");
		System.out.println(l3);
		System.out.println();
		System.out.println(">>>>> Tweaked array toString():");
		l3.tweak();		
		System.out.println(l3);
		System.out.println();
		
		System.out.println("Integer array (two elements): {10, 20}");	
		Integer[] array4 = {10, 20};
		MyLinkedList<Integer> l4 = new MyLinkedList<Integer>(array4);
		System.out.println(">>>>> Original array toString():");
		System.out.println(l4);
		System.out.println();
		System.out.println(">>>>> Tweaked array toString():");
		l4.tweak();		
		System.out.println(l4);
		System.out.println();
	}

	public static void testQ1_3() {
		System.out.println("============= Testing Q1.3 =============");
		
		////////
		System.out.println("String array: {\"A\", \"B\", \"C\", \"D\", \"E\", \"F\", \"G\"}");
		String[] array0 = {"A", "B", "C", "D", "E", "F", "G"};
		testIterator(array0);


		////////
		System.out.println("String array: {\"A\", \"B\", \"C\", \"D\"}");
		String[] array1 = {"A", "B", "C", "D"};
		testIterator(array1);


		////////
		System.out.println("String array: {\"A\", \"B\"}");
		String[] array2 = {"A", "B"};
		testIterator(array2);
		
		////////
		System.out.println("String array: {\"A\"}");
		String[] array3 = {"A"};
		testIterator(array3);		
	}
	
	public static void testIterator(String[] array) {
		MyLinkedList<String> l = new MyLinkedList<String>(array);
		
		Iterator<String> iStr;
		StringBuffer iBuffer;
		
		iStr = l.iterator();
		
		iBuffer = new StringBuffer();

		while (iStr.hasNext()) {
			iBuffer.append(iStr.next());
			if (iStr.hasNext())
				iBuffer.append(", ");
		}

		System.out.println("Sequence returned by next() on original list: " + iBuffer);

		l.tweak();
		
		iStr = l.iterator();

		iBuffer = new StringBuffer();
		while (iStr.hasNext()) {
			iBuffer.append(iStr.next());
			if (iStr.hasNext())
				iBuffer.append(", ");
		}
		
		System.out.println("Sequence returned by next() on tweaked list: " + iBuffer);
		
		System.out.println();	
	}
}