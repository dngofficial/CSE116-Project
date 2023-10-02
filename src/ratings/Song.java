package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import ratings.datastructures.LinkedListNode;
import ratings.Rating;

public class Song {
    private String title;
    private String artist;
    private String song_id;

    private LinkedListNode<Rating> songlinkedlist = null;
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

    public void addRating(Rating rating)
    {
        if(this.songlinkedlist == null)
        {
            this.songlinkedlist = new LinkedListNode<>(rating, null);
        }
        else {
            this.songlinkedlist.append(rating);
        }
    }

    public LinkedListNode<Rating> getRatings()
    {
        return this.songlinkedlist;
    }

    public void setRatings(LinkedListNode<Rating> rating)
    {
        this.songlinkedlist = rating;
    }

    public double averageRating()
    {
        if(this.songlinkedlist == null){
            return 0.0;
        }
        else {
            LinkedListNode<Rating> temp = this.songlinkedlist;
            double i = 0.0;
            while (temp.getNext() != null) {
                double temp_i = temp.getValue().getRating();
                if (temp_i != -1) {
                    i += temp_i;
                }
                temp = temp.getNext();
            }
            double temp_i = temp.getValue().getRating();
            if (temp_i != -1) {
                i += temp_i;
            }
            return i/this.songlinkedlist.size();
        }

    }




}
