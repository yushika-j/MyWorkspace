/**
 * The class TestUtils provides the method runClass, which is used to
 * run all the tests for a given JUnit program. It also declaires the
 * constant DIV, which is also used by the JUnit programs. These are
 * used for the automated grading of laboratories in ITI 1121/1521.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 * @version Sun Jan 12 11:02:02 2020
 */

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestUtils {

    /**
     * A constant used when executing tests.
     */
    
    public static final String DIV = "******************************************************************";

    /**
     * The method runClass is used by the JUnit programs for a given
     * laboratory. It prints various statistics about the number of
     * successful and failed tests.
     *
     * @param the reference of a class that contains a series of JUnit tests.
     */
    
    public static void runClass(java.lang.Class<?> c) {

        System.out.println("Running " + c.getName());
        System.out.println();

        Result result;
        result = JUnitCore.runClasses(c);

        System.out.println("Number of tests run: " + result.getRunCount());
        System.out.println("Number of tests that failed: " + result.getFailureCount());

        if (! result.wasSuccessful()) {
            System.out.println();
            System.out.println("List of failed tests:");
            for (Failure failure : result.getFailures()) {
                System.out.println();
                System.out.println(failure.toString());
                for (StackTraceElement elem : failure.getException().getStackTrace()) {
                    if (elem.getClassName().equals(c.getName())) {
                        System.out.println("	at " + elem);
                    }
                }

            }
        }

        System.out.println();

    }
}
