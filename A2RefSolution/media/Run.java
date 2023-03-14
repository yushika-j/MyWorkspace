/**
 * @author Marcel Turcotte, Universite d'Ottawa/University of Ottawa
 */

public class Run {

    public static void displayStudentInfo( ) {

        System.out.println( "************************************************************" );
        System.out.println( "*    Parvisha Jhundoo, 300269830, Section C03              *" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "************************************************************" );
        System.out.println();

    }

    public static void main( String[] args ) {

        if ( args.length != 2 ) {
            System.err.println( "Usage: java Run infile outfile" );
            System.exit( 1 );
        }

        displayStudentInfo();

        PlayListManager manager = new PlayListManager( args[ 0 ], args[ 1 ] );
        manager.copySongListFromFileToFile();
    }
}
