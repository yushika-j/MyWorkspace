import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL1Q5 {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {
        
        System.out.println(TestUtils.DIV);
        
        System.out.println("Grade for Q5 (out of possible 3.0): " + grade);
        
        System.out.println(TestUtils.DIV);
        
    }

    @Test
    public void testQ5getFibonacci0() {

        assertEquals(0, Q5.getFibonacci(0));
        
        grade += 0.25;
        
    }
    
    @Test
    public void testQ5getFibonacci1() {

        assertEquals(1, Q5.getFibonacci(1));
        
        grade += 0.25;
        
    }

    @Test
    public void testQ5getFibonacci2() {

        assertEquals(1, Q5.getFibonacci(2));
        
        grade += 0.25;
        
    }
    
    @Test
    public void testQ5getFibonacci10() {

        assertEquals(55, Q5.getFibonacci(10));
        
        grade += 0.25;
        
    }

    @Test
    public void testQ5isPrime1() {

        assertEquals( "1 is not a prime number", false, Q5.isPrime(1));
        
        grade += 0.5;
        
    }
    
    @Test
    public void testQ5isPrimeNeg() {

        assertEquals("A prime number is a number bigger than 1 that can only be divided by 1 or itself.", false, Q5.isPrime(-9));
        
        grade += 0.5;
        
    }

    @Test
    public void testQ5isPrime31() {

        assertEquals(true, Q5.isPrime(31));
        
        grade += 0.5;
        
    }

    @Test
    public void testQ5isPrime4() {

        assertEquals(false, Q5.isPrime(4));
        
        grade += 0.5;
        
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL1Q5.class);
        
    }

}
