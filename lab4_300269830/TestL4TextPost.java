import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL4TextPost {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested
    
    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for TextPost (out of a possible 1.5): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructorInitUserName() {
      TextPost myPost = new TextPost("username", "hello world");
      assertEquals("Username not initialized in TextPost constructor","username", myPost.getUserName());

      grade += 0.25;

    }

    @Test
    public void testConstructorInitMessage() {
      TextPost myPost = new TextPost("username", "hello world");
      assertEquals("Message not initialized in TextPost constructor", "hello world", myPost.getMessage());

      grade += 0.25;
    }


    @Test
    public void testNotPopularTextPost() {
      TextPost myPost = new TextPost("username", "hello world");
      assertFalse("New TextPost without any likes should not be popular", myPost.isPopular());
      for (int i = 0; i < 49; i++) {
        myPost.like();
      }
      assertFalse("A TextPost with less than 50 likes should not be popular", myPost.isPopular());

      grade += 0.5;
    }

    @Test
    public void testPopularTextPost() {
      TextPost myPost = new TextPost("username", "hello world");
      for (int i = 0; i < 51; i++) {
        myPost.like();
      }
      assertTrue("A TextPost with more than 50 likes should be popular", myPost.isPopular());
      myPost.like();
      assertTrue("A TextPost with more than 50 likes should be popular", myPost.isPopular());

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL4TextPost.class);

    }

}
