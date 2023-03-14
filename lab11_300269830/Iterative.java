public class Iterative {

	public BitList complement( BitList in ) {

		//throw new UnsupportedOperationException( "not implemented yet!" );
		// Your code here
        Iterator itr = in.iterator() ;
        BitList out = new BitList();
        Iterator itOut = out.iterator();            
        
        while (itr.hasNext()) {
            int value = itr.next();
            if (value == 0) {
                itOut.add(1);
            }else{
                itOut.add(0);
            }
        }
            return out;
    }
        
	

	public BitList or( BitList a, BitList b ) {

		//throw new UnsupportedOperationException( "not implemented yet!" );
		// Your code here
        Iterator it1 = a.iterator();
        Iterator it2 = b.iterator();
        BitList out = new BitList();
        Iterator itOut = out.iterator();

        int value1, value2;
        while (it1.hasNext() && it2.hasNext()) {
            value1 = it1.next();
            value2 = it2.next();
            if (value1 == 0){
                if (value2 == 0) {
                    itOut.add(0);
                }else{
                    itOut.add(1);
                }
            }else{
                itOut.add(1);
            }
        }
        return out;
	}

	public BitList and( BitList a, BitList b ) {

		//throw new UnsupportedOperationException( "not implemented yet!" );
		// Your code here
        Iterator it1 = a.iterator();
        Iterator it2 = b.iterator();
        BitList out = new BitList();
        Iterator itOut = out.iterator();

        int value1, value2;
        while (it1.hasNext() && it2.hasNext()) {
            value1 = it1.next();
            value2 = it2.next();
            if (value1 == 1){
                if (value2 == 1) {
                    itOut.add(1);
                }else{
                    itOut.add(0);
                }
            }else{
                itOut.add(0);
            }
        }
        return out;
	}

	public BitList xor( BitList a, BitList b ) {

		//throw new UnsupportedOperationException( "not implemented yet!" );
		// Your code here
        Iterator it1 = a.iterator();
        Iterator it2 = b.iterator();
        BitList out = new BitList();
        Iterator itOut = out.iterator();

        int value1, value2;
        while (it1.hasNext() && it2.hasNext()) {
            value1 = it1.next();
            value2 = it2.next();
            if ((value1 == 0 && value2 == 1) || (value1 == 1 && value2 == 0) ){
                itOut.add(1);
            }else{
                itOut.add(0);
            }
        }
        return out;
	}
}