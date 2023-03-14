import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL1Q3_AverageDemo {

    private static double grade = 0.0;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested



    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);
        
        System.out.println("Grade for Q3_AverageDemo (out of possible 1.0): " + grade);
        
        System.out.println(TestUtils.DIV);
        
    }

    @Test
    public void testQ3AverageDemo() {

        double tolerance = 0.00001;
        double expected_value = 72.14285714285714;
        double[] valuesArray = new double[] {100.0, 34.0, 72.0, 56.0, 82.0, 67.0, 94.0};
        
        double computed_value = Q3_AverageDemo.calculateAverage(valuesArray);
        
        assertEquals(expected_value, computed_value, tolerance);
        
        grade += 0.5;
        
    }

    @Test
    public void testQ3AverageDemoSingleton() {

        double tolerance = 0.00001;
        double expected_value = 0.0;
        double[] valuesArray = new double[] {0.0};
        double computed_value = Q3_AverageDemo.calculateAverage(valuesArray);

        assertEquals(expected_value, computed_value, tolerance);
        
        grade += 0.5;
        
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL1Q3_AverageDemo.class);
        
    }

}

