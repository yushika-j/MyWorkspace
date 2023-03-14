public class Book {

    // Your variables declaration here
    private String author;
    private String title;
    private int year;
    


    public Book (String author, String title, int year) {
        // Your code here
        this.author = author;
        this.title = title;
        this.year = year;

    }

    public String getAuthor() {
        // Your code here
        return author;
    }

    public String getTitle() {
        // Your code here
        return title;
    }

    public int getYear() {
        // Your code here
        return year;
    }

    public boolean equals(Object other) {
        // Your code here
        return this.equals(other);
    }

    public String toString() {
        // Your code here
        return author + ":" + title + "(" + year + ")";
    }
}