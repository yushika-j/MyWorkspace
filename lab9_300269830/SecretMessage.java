import java.io.*;

public class SecretMessage {

    public static void encrypt( String inputFilem, String outputFile, int key ) throws IOException, FileNotFoundException {

        InputStreamReader input = null;
		OutputStreamWriter out = null;
        // YOUR CODE HERE (remove the exception)
        // initializing FileInputStream
        FileInputStream fis = new FileInputStream(inputFilem);

        // Initializing InputStreamReader object
        input = new InputStreamReader(fis);
        
        // Creation of new OutputSreamWriter
        OutputStream g = new FileOutputStream(outputFile);
        out = new OutputStreamWriter(g);



        int t;
        while((t=input.read())!= -1) {
        
        // convert the integer to character
        char r = (char)(t+key);
        System.out.println("Character : "+r);
        out.write(r+"");
        }
        // Use of close() method to Close InputStreamReader
        input.close();
        out.close();
        
        // Closing FileInputStream
        fis.close();
        }
    

	
	public static void decrypt( String inputFilem, String outputFile, int key ) throws IOException, FileNotFoundException {
        //throw new UnsupportedOperationException("SecretMessage decrypt not implemented");
        // YOUR CODE HERE (remove the exception)
        // initializing FileInputStream
        InputStreamReader input = null;
        OutputStreamWriter out = null;
         
        FileInputStream fis = new FileInputStream(inputFilem);

        // Initializing InputStreamReader object
        input = new InputStreamReader(fis);
        
        // Creation of new OutputSreamWriter
        OutputStream g = new FileOutputStream(outputFile);
        out = new OutputStreamWriter(g);


        int t;
        while((t=input.read())!= -1)
        {
        // convert the integer to character
        char r = (char)(t-key);
        System.out.println("Character : "+r);
        out.write(r+"");

        }
        
        // Use of close() method to Close InputStreamReader
        input.close();
        out.close();
        
        // Closing FileInputStream
        fis.close();
        }
    

    public static void main( String[] args ) {

        if ( args.length != 4 ) {
            System.out.println( "Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key" );
            System.exit( 0 );
        }

		if(args[0].equals("encrypt")){

		
            try {
                encrypt( args[1],args[2], Integer.parseInt(args[3]));
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found: "+e.getMessage() );
            } catch (IOException e) {
                System.err.println( "Cannot read/write file: "+e.getMessage() );
            }
		}
		else if(args[0].equals("decrypt")){

		
            try {
                decrypt( args[1],args[2], Integer.parseInt(args[3]));
            } catch ( FileNotFoundException e ) {
                System.err.println( "File not found: "+e.getMessage() );
            } catch (IOException e) {
                System.err.println( "Cannot read/write file: "+e.getMessage() );
            }
        }
		else{
			System.out.println( "Usage: java SecretMessage [encrypt|decrypt] inputFile OutputFile key" );
            System.exit( 0 );
		}
        
    }
}