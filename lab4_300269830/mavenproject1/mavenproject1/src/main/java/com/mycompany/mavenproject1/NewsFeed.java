package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.NewsFeed.MAX_SIZE;

/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */
public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

    public NewsFeed() {
        // Your code here.
        size = 0;
        messages = new Post[MAX_SIZE];
    }

    public void add(Post message) {
        // Your code here.
        if (size < MAX_SIZE) {
            messages[size] = message;
            size++;
        }
    }

    public Post get(int index) {
        return messages[index];
    }

    public int size() {
        return size;
    }

    public void sort() {
        int i, j, argMin;
        Post tmp;
        for (i = 0; i < size - 1; i++) {
            argMin = i;
            for (j = i + 1; j < size(); j++) {
                if (messages[j].compareTo(messages[argMin]) < 0) {
                    argMin = j;
                }
            }

            tmp = messages[argMin];
            messages[argMin] = messages[i];
            messages[i] = tmp;
        }

    }

    public NewsFeed getPhotoPost() {
        // Your code here
        PhotoPost photoPost = new PhotoPost("","","");
        NewsFeed feed = new NewsFeed();
        feed.add(photoPost);
        return feed;
    }

    public NewsFeed plus(NewsFeed other) {
        // Your code here
        int count = other.size();
        NewsFeed combinationFeed = new NewsFeed();
        
    // add first this object posts
        for (int i = 0; i < count; i++) {
            combinationFeed.add(messages[i]);
        }
        // add the other object posts
        for (int j = count; j < MAX_SIZE; j++) {
            if (other.get(j) != null) {
                combinationFeed.add(other.get(j));
            } else {
                break;
            }
        }
        // sort them
        combinationFeed.sort();
        return combinationFeed;
    }

}
