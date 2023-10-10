package ratings;

import java.util.ArrayList;
import java.util.HashMap;
import ratings.datastructures.LinkedListNode;
import ratings.Rating;
import ratings.Reviewer;

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
        if (this.songlinkedlist == null) {
            return null;
        }
        else {
            return this.songlinkedlist;
        }
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
            int antinodesize = 0;
            while (temp != null) {
                double temp_i = temp.getValue().getRating();
                if (temp_i != -1) {
                    i += temp_i;
                }
                else
                {
                    antinodesize++;
                }
                System.out.println(i);
                temp = temp.getNext();
            } //all values
            System.out.println(i);
            System.out.println(antinodesize);

            return (i/(this.songlinkedlist.size() - antinodesize));
        }
    }

    public String outputtingList()
    {
        String str = "";
        if(this.songlinkedlist == null){
            return "";
        }
        else {
            LinkedListNode<Rating> temp = this.songlinkedlist;
            while (temp.getNext() != null) {
                str += temp.getValue().getRating() + " ";
                temp = temp.getNext();
            } //all values
            str += temp.getValue().getRating() + " ";
            return str;
        }

    }



    public void deleteNodeTest(int loc)
    {
        this.songlinkedlist.delete(loc);
    }


    public void removeRatingByReviewer(Reviewer reviewer)
    {
        int loc = 0;
        boolean detectedOnce = true;
        String reviewerIDToRemove = reviewer.getReviewerID();

        if(this.songlinkedlist == null){
        }
        else if (this.songlinkedlist.size() == 1 && this.songlinkedlist.getValue().getReviewerID().equals(reviewerIDToRemove)){
            this.songlinkedlist = null;
        }
        else {
            LinkedListNode<Rating> temp = this.songlinkedlist;
            while (temp != null) {
                if(temp.getValue().getReviewerID().equals(reviewerIDToRemove) && detectedOnce)
                {
                    this.songlinkedlist.delete(loc);
                    System.out.println("Deleted once, value removed was");
                    System.out.println(temp.getValue().getReviewerID());
                    System.out.println(temp.getValue().getRating());
                    detectedOnce = false;
                }
                else
                {
                    loc++;
                }
                temp = temp.getNext();
            } //all values

        }
    }

    public double bayesianAverageRating(int extra_rating_count, int extra_rating_value)
    {
        if ((extra_rating_value < 1 || extra_rating_value > 5) || (extra_rating_count < 0))
        {
            return 0.0;
        }
        else if(this.songlinkedlist == null){
            return 0.0;
        }
        else {
            LinkedListNode<Rating> temp = this.songlinkedlist;
            double i = 0.0;
            int antinodesize = 0;
            while (temp != null) {
                double temp_i = temp.getValue().getRating();
                if (temp_i != -1) {
                    i += temp_i;
                }
                else
                {
                    antinodesize++;
                }
                System.out.println(i);
                temp = temp.getNext();
            } //all values
            System.out.println(i);
            System.out.println(antinodesize);

            return ((i+(extra_rating_count * extra_rating_value))/((this.songlinkedlist.size() - antinodesize)+ extra_rating_count));
        }
    }
}
