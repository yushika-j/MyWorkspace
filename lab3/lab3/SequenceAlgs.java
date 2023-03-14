

//import net.datastructures.*; // copied Position from net.datatructures.*

public class SequenceAlgs<E> {
	
	
	/**
	 * Verify if a Sequence is palindrome
	 * the sequence is palidrome if it is the same reading from begining to end or end to begining
	 * This should run in O(n) whether Sequence is an ArraySequence or LinkedSequence
	 * Choose wisely the methods to use to go through the list.
	 * @param S  the sequence (it can be an ArraySequence<E> or a LinkedSequence<E>)
	 * @return true if palindrome false otherwise
	 */
	
	public boolean isPalindrome (Sequence<E> S) {
		
		// ***** add your code here  *******************
		
		return true;
 		
	}
	
	

	
	/**
	 * Reverse the values of the sequence. 
	 * If sequence is (2,4,6,8) after this method it will be (8,4,6,2).
	 * Please do it in-place if you can; that is do not use extra memory except for some O(1) space.
	 * This shouls run in O(n), where n is the size of the sequence.
	 * @param S the sequence (it can be an ArraySequence<E> or a LinkedSequence<E>)
	 */
	
	public void inplaceReverse(Sequence<E> S) {
		
		// ***** add your code here  *******************
		
	}
	
	/**
	 * OPTIONAL CHALENGE:
	 * Reverse every k values in a sequence
	 * If S=(1,2,3,4,5,6,7,8) k=4 then output is S=(4,3,2,1,8,7,6,5)
	 * If S=(1,2,3,4,5,6,7,8) k=3 then output is S=(3,2,1,6,5,4,8,7)
	 * If S=(1,2,3,4,5,6,7,8) k=5 then output is S=(5,4,3,2,1,8,7,6)
	 * @param S the sequence (it can be an ArraySequence<E> or a LinkedSequence<E>)
	 * @param k the length of the subreversals
	 */
	
	public void inplaceKReverse(Sequence<E> S,int k) {
		
		// ***** add your code here  *******************
		    	
	}
	

	
	/**
	 * This is a basic testing for the previous methods 
	 * Tests various methods involving a Sequence
	 * @param S the sequence (it can be an ArraySequence<E> or a LinkedSequence<E>)
	 * 
	 */
	// this is code given to students
	// this code can be enhanced with more complete set of tests
	
	public static void initializeAndTest(Sequence<Integer> S) {
        	SequenceAlgs<Integer> tester = new SequenceAlgs<Integer>();
		for (int i=0;i<20;i++) S.addLast(2*i);
        	System.out.println("Sequence:\n"+S);
        	System.out.println("Is palindrome?="+tester.isPalindrome(S));
        	tester.inplaceKReverse(S,3);
        	System.out.println("After 3 reversal:\n"+S);
        	tester.inplaceReverse(S);
        	System.out.println("After  reversal\n"+S);
        	System.out.println("Is palindrome?="+tester.isPalindrome(S));
        	for (int i=19;i>=10;i--) S.set(i,S.get(19-i));
        	System.out.println("After Update\n"+S);
        	System.out.println("Is palindrome?="+tester.isPalindrome(S));
        	tester.inplaceKReverse(S,5);
        	System.out.println("After 5 reversal\n"+S);
        
	}
	
	

	public static void main(String[] args) {
		// this is code given to students
		// you may comment in and out the two parts to test each type of sequence separately 
        
        System.out.println("\nTesting LinkedSequence:\n");
        Sequence<Integer> linked = new LinkedSequence<Integer>();
        initializeAndTest(linked);
        
        System.out.println("\nTesting ArraySequence:\n");
        Sequence<Integer> array = new ArraySequence<Integer>();
        initializeAndTest(array);
        
       
	}

}
