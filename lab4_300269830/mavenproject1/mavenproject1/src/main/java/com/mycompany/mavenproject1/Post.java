package com.mycompany.mavenproject1;


import java.util.Calendar;
import java.util.Date;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    public Post(String userName) {
        // Your code here
        timeStamp = Calendar.getInstance().getTime();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.
    @Override
    public String toString() {
        String str = new String();
        str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
        return str;
    }

    @Override
    public int compareTo(Post other) {
        // Your code here.
        return timeStamp.compareTo(other.getTimeStamp());
    }

    public boolean isPopular() {
        // Your code here.
        if (likes > 100) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void like() {
        likes++;
    }

    @Override
    public int getLikes() {
        return likes;
    }

}
