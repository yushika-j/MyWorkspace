import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL4NewsFeed {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for NewsFeed (out of possible 5.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    /*********************** add tests ***************************/

    @Test
    public void TestAddFirstPost() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      feed.add(myPost);
      assertEquals("NewsFeed's first post does not update the size", 1, feed.size());
      assertEquals("The first post in NewsFeed is incorrect", myPost, feed.get(0));

      grade += 0.5;
    }

    @Test
    public void TestAdd25Posts() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      for (int i = 0; i < 25; i++) {
        feed.add(myPost);
      }
      assertEquals("Adding 25 posts to NewsFeed", 25, feed.size());

      grade += 0.5;
    }

    @Test
    public void TestAddMoreThan25Posts() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      try{
        for (int i = 0; i < 26; i++) {
          feed.add(myPost);
        }
        assertEquals("Maximum number of posts exceeded. Add should not add more than MAX_SIZE(25) posts", 25, feed.size());
        grade += 0.5;
      } catch (ArrayIndexOutOfBoundsException e){
        fail("Method add should not attempt to add more than MAX_SIZE(25) posts");
      }

    }

    /*********************** getPhotoPost tests ********************/

    @Test
    public void TestGetPhotoPostEmpty() {
      NewsFeed feed = new NewsFeed();
      NewsFeed feed2 = feed.getPhotoPost();
      assertEquals("Empty NewsFeed - GetPhotoPost does not return a 0-size NewsFeed", 0, feed2.size());

      grade += 0.5;
    }

    @Test
    public void TestGetPhotoPostBlank() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      for (int i = 0; i < 25; i++) {
        feed.add(myPost);
      }
      NewsFeed feed2 = feed.getPhotoPost();
      assertEquals("Non-empty NewsFeed with no PhotoPosts - GetPhotoPost does not return a 0-size NewsFeed", 0, feed2.size());

      grade += 0.5;
    }

    @Test
    public void TestGetPhotoPostSome() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      Post myPhotoPost = new PhotoPost("Hi", "hi.png", "Hi");
      feed.add(myPhotoPost);
      for (int i = 0; i < 10; i++) {
        feed.add(myPost);
      }

      feed.add(myPhotoPost);
      feed.add(myPost);
      feed.add(myPhotoPost);
      NewsFeed feed2 = feed.getPhotoPost();
      assertEquals("GetPhotoPost - wrong returned size for multiple PhotoPosts", 3, feed2.size());

      grade += 0.5;
    }

    /*********************** plus tests *************************/

    @Test
    public void TestAddEmptyFeedToEmptyFeed() {
      NewsFeed feed = new NewsFeed();
      NewsFeed feed2 = new NewsFeed();
      NewsFeed feed3 = feed.plus(feed2);
      assertEquals("Plus - two empty feeds should return a 0-size NewsFeed", 0, feed3.size());

      grade += 0.5;
    }

    @Test
    public void TestAddSingletonFeedToSelf() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      feed.add(myPost);
      NewsFeed feed2 = feed.plus(feed);
      assertEquals("Singleton NewsFeed plus itself should return a 2-size NewsFeed", 2, feed2.size());

      grade += 0.5;
    }

    @Test
    public void TestAddFeedSorted() {
      NewsFeed feed = new NewsFeed();
      Post myPostSorted = new Post("Sorted");
      NewsFeed feed2 = new NewsFeed();
      Post myPostUnsorted = new Post ("Unsorted");
      feed.add(myPostSorted);
      feed2.add(myPostUnsorted);
      NewsFeed feed3 = feed2.plus(feed);
      assertEquals("plus should return a sorted merged NewsFeed", myPostSorted, feed.get(0));

      grade += 0.5;
    }

    @Test
    public void TestAddFeedAtCapacity() {
      NewsFeed feed = new NewsFeed();
      Post myPost = new Post("Hi");
      for (int i = 0; i < 10; i++) {
        feed.add(myPost);
      }
      NewsFeed feed2 = new NewsFeed();
      Post myPost2 = new Post("Ha");
      for (int i = 0; i < 15; i++) {
        feed2.add(myPost2);
      }
      NewsFeed feed3 = feed.plus(feed2);
      assertEquals("Adding the maximum number of posts in a feed", 25, feed3.size());

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL4NewsFeed.class);

    }

}
