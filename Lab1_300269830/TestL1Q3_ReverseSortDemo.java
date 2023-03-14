import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL1Q3_ReverseSortDemo {

    private static double grade = 0.0;
// 
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested



    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);
        
        System.out.println("Grade for Q3_ReverseSortDemo (out of possible 1.0): " + grade);
        
        System.out.println(TestUtils.DIV);
        
    }

    @Test
    public void testQ3ReverseSortDemo() {

        char[] unordered = new char[] {'x', 'a', 'b', 'r', 'p'};
        
        char[] ordered = new char[] {'x', 'r', 'p', 'b', 'a'};
        
        Q3_ReverseSortDemo.reverseSort(unordered);
        
        assertArrayEquals(ordered, unordered);
        
        grade += 0.5;
        
    }

    @Test
    public void testQ3ReverseSortDemoSorted() {

        char[] unordered = new char[] {'x', 'r', 'p', 'b', 'a'};
        
        char[] ordered = new char[] {'x', 'r', 'p', 'b', 'a'};
        
        Q3_ReverseSortDemo.reverseSort(unordered);
        
        assertArrayEquals(ordered, unordered);
        
        grade += 0.25;
        
    }

    @Test
    public void testQ3ReverseSortDemoBlank() {

        char[] unordered = new char[] {};
        
        char[] ordered = new char[] {};
        
        Q3_ReverseSortDemo.reverseSort(unordered);
        
        assertArrayEquals(ordered, unordered);
        
        grade += 0.25;
        
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL1Q3_ReverseSortDemo.class);
        
    }

}
