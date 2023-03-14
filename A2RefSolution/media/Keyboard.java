// Reads keyboad input, displays the characters and corresponding Unicodes,
// stops when the end-of-stream is reached.

import java.io.InputStreamReader;
import java.io.IOException;

public class Keyboard {
    public static void main( String[] args ) throws IOException {
        InputStreamReader in = new InputStreamReader( System.in );
        int i;
        while ( ( i = in.read() ) != -1 ) {
            char c = (char) i;
            System.out.println( "unicode = " + i + ", char = " + c );
        }
        System.out.println( "bye" );
    }
}

// > java Keyboard
// On Unix you must type control-d in order to send an eos (-1) to
// the program.