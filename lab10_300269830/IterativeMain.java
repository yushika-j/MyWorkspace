public class IterativeMain{

    public static void main( String[] args ) {
    
          BitList a, b;
          Iterative it = new Iterative();
    
          for ( int i=0; i<args.length; i++ ) {
    
              a = new BitList( args[i] );
              System.out.println( "> " + a );
              System.out.println( "< " + it.complement( a ) );
              System.out.println();
    
          }
    
          a = new BitList( "10001" );
          b = new BitList( "00011" );
    
            System.out.println( "a = " + a );
            System.out.println( "b = " + b );
            System.out.println( "a or b = " + it.or( a, b ) );
            System.out.println( "a and b = " + it.and( a, b ) );
            System.out.println( "a xor b = " + it.xor( a, b ) );
                
      }
    
    }