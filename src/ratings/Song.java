package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class Song {
    private String title;
    private String artist;
    private String song_id;
    public Song(String title, String artist, String song_id) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setSongID(song_id);
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }
    public String getSongID () {
        return this.song_id;
    }

    public void setTitle(String title){this.title = title;}

    public void setArtist(String artist){this.artist = artist;}

    public void setSongID(String song_id){this.song_id = song_id;}






}
