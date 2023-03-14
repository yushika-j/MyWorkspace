import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class TestL2DoorLock {
    
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;


    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for DoorLock (out of possible 7.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructorSetsToClosed() {

      Combination c1 = new Combination(1, 2, 3);
      DoorLock lock = new DoorLock(c1);
      boolean expected = false;
      boolean actual = lock.isOpen();
      assertEquals("The constructor does not initialize open state to false.", expected, actual);
      grade += 1;
    }

    @Test
    public void testConstructorSetsToActivated() {

      Combination c1 = new Combination(1, 2, 3);
      DoorLock lock = new DoorLock(c1);
      boolean expected = true;
      boolean actual = lock.isActivated();
      assertEquals("The constructor does not initialize activation state to true.", expected, actual);
      grade += 1;
    }

    @Test
    public void testUnactivatedAfterThreeFailedAttempts() {
      Combination c1 = new Combination(1, 2, 3);
      DoorLock lock = new DoorLock(c1);
      Combination c2 = new Combination(3, 2, 1);
      lock.open(c2);
      lock.open(c2);
      lock.open(c2);
      boolean expected = false;
      boolean actual = lock.isActivated();
      assertEquals("The DoorLock does not deactivate after 3 failed attempts.", expected, actual);
      grade += 1;
    }

    @Test
    public void testReactivateAfterDeactivation() {
      Combination c1 = new Combination(1, 2, 3);
      DoorLock lock = new DoorLock(c1);
      Combination c2 = new Combination(3, 2, 1);
      lock.open(c2);
      lock.open(c2);
      lock.open(c2);
      lock.activate(c1);
      boolean expected = true;
      boolean actual = lock.isActivated();
      assertEquals("The DoorLock does not get activated with the correct combination.", expected, actual);
      grade += 1;
    }

    @Test
    public void testOpenWithCorrectCombinationWhenActivated() {
      Combination c1 = new Combination(1, 2, 3);
      DoorLock lock = new DoorLock(c1);
      lock.open(c1);
      boolean expected = true;
      boolean actual = lock.isOpen();
      assertEquals("The DoorLock is not opened with a correct combination.", expected, actual);
      grade += 1;
    }

    @Test
    public void testOpenWithCorrectCombinationWhenDeactivated() {
      Combination c1 = new Combination(1, 2, 3);
      Combination c2 = new Combination(3, 2, 1);
      DoorLock lock = new DoorLock(c1);
      lock.open(c2);
      lock.open(c2);
      lock.open(c2);
      lock.open(c1);
      boolean expected = false;
      boolean actual = lock.isOpen();
      assertEquals("After exceeding the maximum number of attempts, the DoorLock should be deactivated, thus it cannot be opened.", expected, actual);
      grade += 1;
    }

    @Test
    public void testOpenWithIncorrectCombinationWhenActivated() {
      Combination c1 = new Combination(1, 2, 3);
      Combination c2 = new Combination(3, 2, 1);
      DoorLock lock = new DoorLock(c1);
      lock.open(c2);
      boolean expected = false;
      boolean actual = lock.isOpen();
      assertEquals("The DoorLock is opened with an incorect combination.", expected, actual);
      grade += 1;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL2DoorLock.class);

    }

}
