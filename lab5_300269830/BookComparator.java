import java.util.Comparator;


public class BookComparator implements Comparator<Book> {
    // Implement the comparator method for books.

    @Override
    public int compare(Book book1, Book book2) {
        int result = book1.getAuthor().compareTo(book2.getAuthor());
        
        if (result == 0) {
            result = book1.getTitle().compareTo(book2.getTitle());
            
            if (result == 0) {
                result = Integer.compare(book1.getYear(), book2.getYear());
            }
        }
        return 0;
    }
}