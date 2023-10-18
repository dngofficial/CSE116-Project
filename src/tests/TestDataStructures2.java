package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.Playlist;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;


public class TestDataStructures2 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
    private Song song;
    private Rating rating;
    private Reviewer reviewer;
    private Playlist playlistTitleCompare;
    private Playlist playlistBayesianCompare;


    private final double EPSILON = 0.001;
    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }


    @Before
    public void setUpSong() {

        song = new Song("See You Again", "Tyler The Creator", "43");
        rating = new Rating("Gordon Ramsey", 3);
        reviewer = new Reviewer("Devan Ng");
        playlistTitleCompare = new Playlist(new SongTitleComparator());
        playlistBayesianCompare = new Playlist(new SongBayesianRatingComparator());

    }

    @Test
    public void addSong() {
        playlistTitleCompare.addSong(new Song("See You Again", "Tyler The Creator", "43"));
        assertTrue(playlistTitleCompare.getSongTree().getValue().getTitle().equals("See You Again"));
        assertTrue(playlistTitleCompare.getSongTree().getValue().getArtist().equals("Tyler The Creator"));
        assertTrue(playlistTitleCompare.getSongTree().getValue().getSongID().equals("43"));



    }


}