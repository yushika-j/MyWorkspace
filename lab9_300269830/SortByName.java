class SortByName implements java.util.Comparator<Song> {

    public int compare(Song a, Song b) {

        int result;

        if ( a == null && b == null )
            result = 0;
        else if ( a == null && b != null )
            result = 1;
        else if ( a != null && b == null )
            result = -1;
        else
            result = a.getName().compareTo( b.getName() );

        return result;
    }
}
