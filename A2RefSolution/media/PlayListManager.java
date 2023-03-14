public class PlayListManager{

    private static final long serialVersionUID = 1L;

    // Instance variables
    private PlayList model;  // main PlayList
    private PlayList newPlayList;

    private String inFile;
    private String outFile;

    public PlayListManager( String in, String out ) {
    
        // Taking of the data structures that will be storing our data

        try {
            this.model = PlayList.getSongsFromFile( in );
        } catch ( java.io.IOException e ) {
            e.printStackTrace();
            System.exit( 1 );
        }

        newPlayList = new PlayList();  // we'll be adding Songs to this PlayList
        inFile = in;
        outFile = out;
    }

    public void copySongListFromFileToFile(){
        PlayList from;
        try {
            from = PlayList.getSongsFromFile( inFile );
            from.writeSongsToFile(outFile);
        } catch ( java.io.IOException e ) {
            e.printStackTrace();
            System.exit( 1 );
        }
    }

    public void copySongToNewPlayList(int index){

        if ( index == -1 ) {

            System.err.println( "Select a song from the list (0, " + (model.getSize()-1) + ")");

        } else {

            newPlayList.addSong( model.getSongAt( index ) ); // copy the Song
            displaySongs();
        }
    }

    public void sortSongsByName (PlayList model){

        SortByName c = new SortByName();  // Comparator

        model.sort( c );

        displaySongs(model);
    }

    public void sortPlayListByName (PlayList model){

        SortByName c = new SortByName();  // Comparator

        model.sort( c );

        displaySongs(model);
    }

    public void sortPLayListByArtist(PlayList model){

        SortByArtist c = new SortByArtist();

        model.sort( c );
        newPlayList.sort( c );

        displaySongs();
    }

    public void sortPLayListByAlbum(PlayList model){

        SortByAlbum c = new SortByAlbum();

        model.sort( c );
        newPlayList.sort( c );

        displaySongs();
    }

    private static void displaySongs( PlayList model) {
        for ( int i=0; i<model.getSize(); i++ ) {
            System.out.println(model.getSongAt( i ).toString());
        }
    }

    public void displaySongs() {
        displaySongs( model );
        displaySongs( newPlayList );
    }

}
