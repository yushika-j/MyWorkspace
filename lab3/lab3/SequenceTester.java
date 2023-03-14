

/**
 * 
 * A Basic Tester to Check Functionality of Sequence Methods
 * 
 * @author Lucia Moura 
 *
 */
public class SequenceTester {
	
	// More Tests Needs to be implemented !!! 
	
    static void CrazyTest(Sequence<Integer> S) {
    	
    	for (int i=0;i<10;i++) {
    	     S.addLast(i);
    	     S.addFirst(2*i);
    	}
    	System.out.println("S="+S);
 
    	for (int i=0;i<5;i++) {
   	      S.remove(S.first());
   	      S.remove(S.last());
   	    }
   	    System.out.println("S="+S);
   	    
   	    S.set(5,-1);
   	    S.remove(4);
   	    
   	    System.out.println("S="+S);
   	    
   	    Position<Integer> pos= S.positionAtIndex(5);
   	    S.remove(pos);
   	    
   	    System.out.println("S="+S);
   	    
   	    for (int i=0; i<S.size(); i++) {
   	    	pos= S.positionAtIndex(i);
   	    	S.set(pos, (-1)*pos.getElement());
   	    }
   	    
   	    System.out.println("S="+S);
   	    
   	    for (int i=0;i<5;i++) {
   	    	S.addAfter(S.positionAtIndex(2),0);
   	    }
   	    System.out.println("S="+S);
   	    
  	    for (int i=0;i<5;i++) {
   	    	S.remove(S.positionAtIndex(3));
   	    }
   	    System.out.println("S="+S);
   	    
   	    
   	   // corner cases needs to be added while catching exceptions such as:
  	   // S.remove(15);
   	   // pos=S.positionAtIndex(15); 
   	   
   	    S.add(8, 99); // delicate case of adding beyond the last
   	    
   	    System.out.println("S="+S);   
   	    
   	    S.add(0, 55);

   	    System.out.println("S="+S); 
   	    
   	    // little test for positions forward
   	    for (pos=S.first(); pos!=null; pos=S.after(pos)) {
   	    	System.out.print(pos.getElement()+",");
   	    }
   	    System.out.println();
   	    //little test for positions backward
   	    for (pos=S.last(); pos!=null; pos=S.before(pos)) {
   	    	System.out.print(pos.getElement()+",");
   	    }
   	    System.out.println();	    
   	    
    }

	public static void main(String[] args) {
		
		System.out.println("\nTesting Results for ArraySequence\n");
        Sequence<Integer> myArraySeq = new  ArraySequence<Integer>();
        CrazyTest(myArraySeq);
        
        System.out.println("\nTesting Results for LinkedSequence\n");
        Sequence<Integer> myLinkedSeq = new  LinkedSequence<Integer>();
        CrazyTest(myLinkedSeq);
        
	}

}
