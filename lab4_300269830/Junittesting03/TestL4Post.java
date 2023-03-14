import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;


import static org.junit.Assert.*;

public class TestL4Post {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Post (out of a possible 2.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructorInitUsername() {
      Post myPost = new Post("username");
      assertEquals("Username not initialized in Post constructor", "username", myPost.getUserName());

      grade += 0.25;
    }

    @Test
    public void testConstructorInitLikes() {
      Post myPost = new Post("username");
      assertEquals("Number of likes not initialized in Post constructor", 0, myPost.getLikes());

      grade += 0.25;
    }



    @Test
    public void testLikes() {
      Post myPost = new Post("username");
      for (int i = 0; i < 10; i++) {
        myPost.like();
      }
      assertEquals("Post - incorrect number of likes", 10, myPost.getLikes());

      grade += 0.5;
    }

    @Test
    public void testCompareSamePost() {
      Post myPost = new Post("username");
      assertEquals("Equality between the same post fails to return 0", 0, myPost.compareTo(myPost));

      grade += 0.5;
    }

    @Test
    public void testCompareDifferentPost() {
      Post myPost = new Post("username");
      try {
          Thread.sleep(1);
      } catch (InterruptedException e) {
          ;
      }
      Post yourPost = new Post("username2");
      assertTrue("Earlier posted post comparted to a later one should return a negative value", myPost.compareTo(yourPost) < 0);
      assertTrue(yourPost.compareTo(myPost) > 0);

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL4Post.class);

    }

}
