import java.io.*;

public class Copy {

    public static void copy( String fileName ) 
        throws IOException, FileNotFoundException {  

        InputStreamReader input;

        input = new InputStreamReader( new FileInputStream( fileName ) ); //open file
        
        int c;
        while ( ( c = input.read() ) != -1 ) {  //we read character by character
            System.out.write( c );		//prints on the console
        }

        input.close();	//close the opened file
    }

    public static void main( String[] args ) 
        throws IOException, FileNotFoundException {

        if ( args.length != 1 ) {
            System.out.println( "Usage: java Copy file" );
            System.exit( 0 );
        }

        copy( args[0] );

    }
}