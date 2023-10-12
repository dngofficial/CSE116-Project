package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import ratings.datastructures.LinkedListNode;
import ratings.Rating;
import ratings.Reviewer;

public class Song extends Ratable{
    private String title;
    private String artist;
    private String song_id;

    public Song(String title, String artist, String song_id) {
        super(title);
        this.setArtist(artist);
        this.setSongID(song_id);
    }

    public String getArtist() {
        return this.artist;
    }
    public String getSongID () {
        return this.song_id;
    }

    public void setArtist(String artist){this.artist = artist;}

    public void setSongID(String song_id){this.song_id = song_id;}

}
