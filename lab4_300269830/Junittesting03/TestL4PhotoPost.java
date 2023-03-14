import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL4PhotoPost {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested
    
    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for PhotoPost (out of a possible 1.5): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructorInitUsername() {
      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
      assertEquals("username not initialized in PhotoPost constructor", "username", myPost.getUserName());

      grade += 0.1;
    }

    @Test
    public void testConstructorInitCaption() {
      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
      assertEquals("caption not initialized in PhotoPost constructor", "hello world", myPost.getCaption());

      grade += 0.2;
    }

    @Test
    public void testConstructorInitFileName() {
      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
      assertEquals("fileName not initialized in PhotoPost constructor", "hello.jpg", myPost.getFileName());

      grade += 0.2;
    }

    @Test
    public void testNewNotPopularPhotoPost() {
      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
      assertFalse("A new PhotoPost without likes should not be popular", myPost.isPopular());

      grade += 0.25;
    }

    @Test
    public void testNotPopularPhotoPost() {
      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
      for (int i = 0; i < 99; i++) {
        myPost.like();
      }
      assertFalse("A PhotoPost with less than 100 likes should not be popular", myPost.isPopular());

      grade += 0.25;
    }


    @Test
    public void testPopularPhotoPost() {
      PhotoPost myPost = new PhotoPost("username", "hello.jpg", "hello world");
      for (int i = 0; i < 101; i++) {
        myPost.like();
      }
      assertTrue("A PhotoPost with more than 100 likes should be popular", myPost.isPopular());
      myPost.like();
      assertTrue("A PhotoPost with more than 100 likes should be popular", myPost.isPopular());

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL4PhotoPost.class);

    }

}
