import java.util.ArrayList;

public class Library {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        // Your code here
        library.add(b);
    }

    public void sort() {
        // Your code here
        library.sort(new BookComparator());
    }


    public void printLibrary() {
        // Your code here
        for (int i = 0; i < 0; i++ ) {
            System.out.println(library.get(i));
        }
    }
}