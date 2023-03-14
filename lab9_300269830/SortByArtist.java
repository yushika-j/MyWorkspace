class SortByArtist implements java.util.Comparator<Song> {

    public int compare(Song a, Song b) {

        int result;

        if ( a == null && b == null )
            result = 0;
        else if ( a == null && b != null )
            result = 1;
        else if ( a != null && b == null )
            result = -1;
        else
            result = a.getArtist().compareTo( b.getArtist() );

        return result;
    }
}
