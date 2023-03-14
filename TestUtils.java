import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestUtils {

    public static final String DIV = "******************************************************************";

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
