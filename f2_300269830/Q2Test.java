/**
 * COPYRIGHT MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Mehrdad Sabetzadeh 
 */
public class Q2Test {
	public static void main(String[] args) {
	
		System.out.println("============= Testing Q2 =============");
		test1();
		System.out.println();
		test2();	
	}
	
	private static void test1() {
	System.out.println(">>>> Testing with two queues >>>>>");
	
	@SuppressWarnings("unchecked")
		Queue<String>[] array = (Queue<String>[]) new Queue[2];
		
		for (int i = 0; i < 2; i++)
			array[i] = new LinkedQueue<String>();
			
		array[0].enqueue("A1");
		array[0].enqueue("A2");		
		array[0].enqueue("A3");
		array[0].enqueue("A4");
		array[0].enqueue("A5");					
		array[0].enqueue("A6");					
		array[0].enqueue("A7");					
		array[0].enqueue("A8");

		array[1].enqueue("B1");
		array[1].enqueue("B2");		
		array[1].enqueue("B3");
		array[1].enqueue("B4");

		System.out.println("Queue0: " + array[0]);
		System.out.println("Queue1: " + array[1]);
				
		Queue<String> result = QueueUtils.merge(array);

		System.out.println("Merged queue: " + result);	
	}
	private static void test2() {
	
	System.out.println(">>>> Testing with five queues >>>>>");
	
	@SuppressWarnings("unchecked")
		Queue<String>[] array = (Queue<String>[]) new Queue[5];
		
		for (int i = 0; i < 5; i++)
			array[i] = new LinkedQueue<String>();
			
		array[0].enqueue("A1");
		array[0].enqueue("A2");		
		array[0].enqueue("A3");
		array[0].enqueue("A4");
		array[0].enqueue("A5");					

		array[1].enqueue("B1");
		array[1].enqueue("B2");		
		array[1].enqueue("B3");

		array[2].enqueue("C1");
		
		array[4].enqueue("E1");
		array[4].enqueue("E2");		
		array[4].enqueue("E3");
		array[4].enqueue("E4");
		array[4].enqueue("E5");		
		array[4].enqueue("E6");
		array[4].enqueue("E7");

		System.out.println("Queue0: " + array[0]);
		System.out.println("Queue1: " + array[1]);
		System.out.println("Queue2: " + array[2]);
		System.out.println("Queue3: " + array[3]);				
		System.out.println("Queue4: " + array[4]);
				
		Queue<String> result = QueueUtils.merge(array);

		System.out.println("Merged queue: " + result);
	}
	
}