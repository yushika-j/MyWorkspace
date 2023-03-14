//                              -*- Mode: Java -*- 
// Simulation.java --- implements this discrete time simulation
// Author          : Marcel Turcotte
// Created On      : Sat Mar  3 07:56:14 2007
// Last Modified By: Vahdat Abdelzad
// Last Modified On: Wed Mar  9 23:00:00 2016
// ITI 1121/1521. Introduction to Computer Science II

public class Simulation {

    // Constants

    private static final String nl = System.lineSeparator();

    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int TICK = 5;

    private static final double PROBABILITY_NEW_ARRIVAL = 0.125;

    private static final int EXPRESS_MAX_NUM_ITEMS = 12;

    // Instance variables

    private Cashier express;
    private Cashier regular;

    private int lengthOfSimulation;

    // Constructor

    public Simulation( int duration ) {

        lengthOfSimulation = duration;

        express = new Cashier();
        regular = new Cashier();

    }
   
    public void run() {

        int currentTime = 0;

        while ( currentTime < lengthOfSimulation ) {

            if ( Math.random() <= PROBABILITY_NEW_ARRIVAL ) {

                Customer customer = new Customer( currentTime );

                if ( customer.getNumberOfItems() <= EXPRESS_MAX_NUM_ITEMS ) {
                    express.addCustomer( customer );
                } else  {
                    regular.addCustomer( customer );
                }
            }

            express.serveCustomers( currentTime );
            regular.serveCustomers( currentTime );

            currentTime += TICK;

        }

        display();
    }

    private void display() {

        System.out.println( "SIMULATION :: " );
        System.out.println( "The duration (in seconds) of the simulation was " + lengthOfSimulation + nl );

        System.out.println( "EXPRESS CHECKOUT LINE :: " );
        System.out.println( express );

        System.out.println( "REGULAR CHECKOUT LINE :: " );
        System.out.println( regular );

    }

    public static void main(String[] args) {

        int duration = SECONDS_PER_MINUTE * MINUTES_PER_HOUR * 8;
        Simulation sim = new Simulation( duration );
        sim.run();

    }
}