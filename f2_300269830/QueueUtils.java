import java.util.ArrayList;

/**
 * COPYRIGHT MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Mehrdad Sabetzadeh 
 */
public class QueueUtils {
	public static Queue<String> merge(Queue<String>[] array){
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException();
		}
		Queue<String> queue = new Queue<String>();
		//throw new UnsupportedOperationException("You need to complete this method!");
		int size = array.length;
		for (int i = 0; i < size; i++) {
			if( array[i] == null){
				throw new NullPointerException();
			}else if (array[i].isEmpty() == true){
				throw new IllegalArgumentException("Queue is empty");

			queue.enqueue(array[i].dequeue());
		}
			
		return queue;
	}
	}
}