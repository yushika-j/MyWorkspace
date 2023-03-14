import java.util.StringTokenizer;

public class Song {
  
    // Instance variables

    private String name;
    private String artist;
    private String album;
  
    // Constructor

    public Song( String name, String artist, String album ) {

        if ( name == null || artist == null || album == null )
            throw new IllegalArgumentException( "null value" );

        this.name = name;
        this.artist = artist;
        this.album = album;
    }
  
    // Access methods

    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }

    public boolean equals( Song other ) {

        if ( other == null ) {
            return false;
        }

        return ( name.equals( other.name ) && 
                 artist.equals( other.artist ) && 
                 album.equals( other.album ) );

    }

    // Overriding the method toString

    public String toString() {
        return getName() + ":" + getArtist() + ":" + getAlbum();
    }

    public static Song parseSong( String s ) {

        StringTokenizer st = new StringTokenizer( s, ":" );

        return new Song( st.nextToken(), st.nextToken(), st.nextToken() );
    }

}
