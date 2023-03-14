public class SortByAlbum implements java.util.Comparator<Song> {

    // The only method of the interface Comparator.

    public int compare(Song a, Song b) {

        int result;

        // Considering null values greather than non-null values, this
        // will force the sort to move all the null values toward the
        // end of the array.

        if ( a == null && b == null )
            result = 0;
        else if ( a == null && b != null )
            result = 1;
        else if ( a != null && b == null )
            result = -1;
        else
            result = a.getAlbum().compareTo( b.getAlbum() );

        return result;
    }
}
