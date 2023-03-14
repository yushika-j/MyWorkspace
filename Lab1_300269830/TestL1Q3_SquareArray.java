import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL1Q3_SquareArray {

    private static double grade = 0.0;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested



    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);
        
        System.out.println("Grade for Q3_SquareArray (out of possible 1.0): " + grade);
        
        System.out.println(TestUtils.DIV);
        
    }

    @Test
    public void testQ3SquareArray() {

        int[] theArray = Q3_SquareArray.createArray(14);
        
        int[] expectedArray = new int[] {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169};
        
        assertArrayEquals(expectedArray, theArray);
        
        grade += 0.5;
        
    }

    @Test
    public void testQ3SquareArraySingleton() {

        int[] theArray = Q3_SquareArray.createArray(1);
        
        int[] expectedArray = new int[] {0};
        
        assertArrayEquals(expectedArray, theArray);
        
        grade += 0.5;

    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL1Q3_SquareArray.class);
        
    }
    
}
