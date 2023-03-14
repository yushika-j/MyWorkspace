import java.util.Random;

public class SecurityAgency {

    public static void main( String[] args ) {

        int maximum_number_of_attempts = 3;

        Random generator = new Random();

        // Creates a new security agent called bob!
        SecurityAgent bob = new SecurityAgent();

        // Ask bob to give us access to the door lock
        DoorLock aLock = bob.getDoorLock();

        // Let's find bob's secret combination
        Combination c = null;
        boolean open = false;
        int iter = 0;

        while (! open && iter < maximum_number_of_attempts) {

            // bob knows the combination and will
            // re-activate the DoorLock

            if ( ! aLock.isActivated() ) {
               bob.activateDoorLock();
            }

            // let's create a new random combination

            int first = generator.nextInt(5) + 1;
            int second = generator.nextInt(5) + 1;
            int third = generator.nextInt(5) + 1;

            c = new Combination( first, second, third );
            
            // if this combination opens the lock
            // we're done.
            if ( aLock.open( c ) ) {
                open = true;
            }

            iter++;
        }
        if( iter < maximum_number_of_attempts) {
            System.out.println( "Success!" );
            System.out.println( "Number of attemtps: " + iter );
            System.out.println( "The combination is: " + c );
        } else {
            System.out.println( "Failed!" );
            System.out.println( "Reached the maximum number of attempts before finding the combination!" );
        }
    }
}