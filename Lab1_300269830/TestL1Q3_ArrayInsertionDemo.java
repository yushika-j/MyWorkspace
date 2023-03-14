
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL1Q3_ArrayInsertionDemo {

    private static double grade = 0.0;

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested


    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Q3_ArrayInsertionDemo (out of possible 2.0): " + grade);

        System.out.println(TestUtils.DIV);
        
    }
    @Test
    public void testQ3ArrayInsertionMiddle() {
        
        int[] valuesArray = new int[]{1,5,4,7,9,6};
        int[] expectedArray = new int[]{1,5,4,15,7,9,6};
        int[] finalArray = Q3_ArrayInsertionDemo.insertIntoArray(valuesArray, 3, 15);
      
        assertArrayEquals(expectedArray, finalArray);
      
        grade += 0.5;
      
    }

    @Test
    public void testQ3ArrayInsertionBeginning() {

        int[] valuesArray = new int[]{1,5,4,7,9,6};
        int[] expectedArray = new int[]{15,1,5,4,7,9,6};
        int[] finalArray = Q3_ArrayInsertionDemo.insertIntoArray(valuesArray, 0, 15);
        
        assertArrayEquals(expectedArray, finalArray);

        grade += 0.5;
        
    }

    @Test
    public void testQ3ArrayInsertionEnd() {

        int[] valuesArray = new int[]{1,5,4,7,9,6};
        int[] expectedArray = new int[]{1,5,4,7,9,6,15};
        int[] finalArray = Q3_ArrayInsertionDemo.insertIntoArray(valuesArray, valuesArray.length, 15);
        
        assertArrayEquals(expectedArray, finalArray);

        grade += 0.5;
        
    }

    @Test
    public void testQ3ArrayInsertionEmptyArray() {
        
        int[] valuesArray = new int[]{};
        int[] expectedArray = new int[]{15};
        int[] finalArray = Q3_ArrayInsertionDemo.insertIntoArray(valuesArray, valuesArray.length, 15);
        
        assertArrayEquals(expectedArray, finalArray);

        grade += 0.5;
    }
    
    public static void main(String[] args) {

        TestUtils.runClass(TestL1Q3_ArrayInsertionDemo.class);
        
    }
    
}
