public class Q2Test {

	public static void main(String[] args) {

		UniquifiableLinkedQueue<Integer> integerQueue = new UniquifiableLinkedQueue<Integer>();
		integerQueue.enqueue(0);
		integerQueue.enqueue(1);
		integerQueue.enqueue(1);
		integerQueue.enqueue(1);
		integerQueue.enqueue(2);
		integerQueue.enqueue(2);
		integerQueue.enqueue(3);
		integerQueue.enqueue(3);
		integerQueue.enqueue(3);
		integerQueue.enqueue(4);

		System.out.println("Original Integer Queue: " + integerQueue);
		System.out.println("Integer Queue without immediately consecutive duplicates: " + integerQueue.uniquify());
		System.out.println("Original Integer Queue (after uniquify): " + integerQueue);

		System.out.println();

		UniquifiableLinkedQueue<String> stringQueue = new UniquifiableLinkedQueue<String>();
		stringQueue.enqueue("a");
		stringQueue.enqueue("a");
		stringQueue.enqueue("b");
		stringQueue.enqueue("b");
		stringQueue.enqueue("b");
		stringQueue.enqueue("c");
		stringQueue.enqueue("d");
		stringQueue.enqueue("d");
		stringQueue.enqueue("d");
		stringQueue.enqueue("e");
		stringQueue.enqueue("e");

		System.out.println("Original String Queue: " + stringQueue);		
		System.out.println("String Queue without immediately consecutive duplicates: " + stringQueue.uniquify());
		System.out.println("Original String Queue (after uniquify): " + stringQueue);
		
		System.out.println();
		System.out.println("---- Now, testing with some non-consecutive duplicates ----- ");
		System.out.println();

		
		UniquifiableLinkedQueue<String> stringQueueWithNonConsecutiveDuplicates = new UniquifiableLinkedQueue<String>();
		stringQueueWithNonConsecutiveDuplicates.enqueue("a");
		stringQueueWithNonConsecutiveDuplicates.enqueue("b");
		stringQueueWithNonConsecutiveDuplicates.enqueue("b");
		stringQueueWithNonConsecutiveDuplicates.enqueue("c");
		stringQueueWithNonConsecutiveDuplicates.enqueue("a");
		stringQueueWithNonConsecutiveDuplicates.enqueue("d");
		stringQueueWithNonConsecutiveDuplicates.enqueue("d");
		stringQueueWithNonConsecutiveDuplicates.enqueue("e");
		stringQueueWithNonConsecutiveDuplicates.enqueue("e");
		stringQueueWithNonConsecutiveDuplicates.enqueue("d");
		stringQueueWithNonConsecutiveDuplicates.enqueue("d");
		stringQueueWithNonConsecutiveDuplicates.enqueue("d");
		stringQueueWithNonConsecutiveDuplicates.enqueue("d");
		stringQueueWithNonConsecutiveDuplicates.enqueue("b");		
		
		System.out.println("Original String Queue: " + stringQueueWithNonConsecutiveDuplicates);		
		System.out.println("String Queue without immediately consecutive duplicates: " +
		  stringQueueWithNonConsecutiveDuplicates.uniquify());
		System.out.println("Original String Queue (after uniquify): " + stringQueueWithNonConsecutiveDuplicates);

		
	}
}
