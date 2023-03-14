/**
 * ITI 1521. Introduction � l'informatique II (Hiver 2008).
 * ITI 1121. Introduction to Computer Science II (Winter 2008).
 *
 * @author Marcel Turcotte, Universit� d'Ottawa/University of Ottawa
 */

public class L6Q1 {

    public static void main( String[] args ) {

        Stack<String> s;

        s = new ArrayStack<String>( 10 );

        for ( int i=0; i<10; i++ ) {
            s.push( "Elem-" + i );
        }

        s.clear();

        while ( ! s.isEmpty() ) {
            System.out.println( s.pop() );
        }

        for ( int i=0; i<10; i++ ) {
            s.push( "** Elem-" + i );
        }

        while ( ! s.isEmpty() ) {
            System.out.println( s.pop() );
        }

    }

}

// > java L6Q1
// ** Elem-9
// ** Elem-8
// ** Elem-7
// ** Elem-6
// ** Elem-5
// ** Elem-4
// ** Elem-3
// ** Elem-2
// ** Elem-1
// ** Elem-0