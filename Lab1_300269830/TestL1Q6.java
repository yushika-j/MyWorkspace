import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL1Q6 {

    private static final double DELTA = 0.00001;
        
    private static double grade = 0.0;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    @AfterClass
    public static void afterClass() {
	
        System.out.println(TestUtils.DIV);
	
        System.out.println("Grade for Q6 (out of possible 2.0): " + grade);
	
        System.out.println(TestUtils.DIV);
    }

    @Test
    public void testQ6Average() {

        double[] sampleGradesFloat = {12.3, 57.0, 95.0, 68.0, 85.0, 82.5, 93.2, 99.9, 88.0, 70.0};
        double avg = Q6.calculateAverage(sampleGradesFloat);
        
        assertEquals(75.09, avg, DELTA);
        
        grade += 0.25;

    }

    @Test
    public void testQ6Median() {

        double[] sampleGradesFloat = {12.3, 57.0, 95.0, 68.0, 85.0, 82.5, 93.2, 99.9, 88.0, 70.0};

        double median = Q6.calculateMedian(sampleGradesFloat);

        assertEquals(83.75, median, DELTA);

        grade += 0.25;

    }

    @Test
    public void testQ6NumberFailed() {

        double[] sampleGradesFloat = {12.3, 57.0, 95.0, 68.0, 85.0, 82.5, 93.2, 99.9, 88.0, 70.0};
        
        int num_failed = Q6.calculateNumberFailed(sampleGradesFloat);
        
        assertEquals(1, num_failed, DELTA);
        
        grade += 0.25;
        
    }

    @Test
    public void testQ6NumberPassed() {

        double[] sampleGradesFloat = {12.3, 57.0, 95.0, 68.0, 85.0, 82.5, 93.2, 99.9, 88.0, 70.0};
            
        int num_passed = Q6.calculateNumberPassed(sampleGradesFloat);
            
        assertEquals(9, num_passed, DELTA);
            
        grade += 0.25;

    }

    @Test
    public void testQ6Average2() {

        double[] sampleGradesFloat = {92.5, 55.5, 32.5, 74.5, 50.0};
        
        double avg = Q6.calculateAverage(sampleGradesFloat);
        
        assertEquals(61, avg, DELTA);
        
        grade += 0.25;
        
    }

    @Test
    public void testQ6Median2() {

        double[] sampleGradesFloat = {92.5, 55.5, 32.5, 74.5, 50.0};
        
        double median = Q6.calculateMedian(sampleGradesFloat);
        
        assertEquals(55.5, median, DELTA);
        
        grade += 0.25;
        
    }

    @Test
    public void testQ6NumberFailed2() {

        double[] sampleGradesFloat = {92.5, 55.5, 32.5, 74.5, 50.0};
        
        int num_failed = Q6.calculateNumberFailed(sampleGradesFloat);
        
        assertEquals(1, num_failed, DELTA);
        
        grade += 0.25;
        
    }

    @Test
    public void testQ6NumberPassed2() {

        double[] sampleGradesFloat = {92.5, 55.5, 32.5, 74.5, 50.0};
        
        int num_passed = Q6.calculateNumberPassed(sampleGradesFloat);
        
        assertEquals(4, num_passed, DELTA);
        
        grade += 0.25;
        
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL1Q6.class);
        
    }
    
}
