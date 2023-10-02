package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestDataStructures1 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
    private Song song;
    private Rating rating;
    private Reviewer reviewer;

    private final double EPSILON = 0.001;
    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }


    @Before
    public void setUpSong() {

        song = new Song("See You Again", "Tyler The Creator", "43");
        rating = new Rating("Gordon Ramsey", 3);
        reviewer = new Reviewer("Devan Ng");
    }

    @Test
    public void addSong1() {
        Rating rating = new Rating("Me",4);
        song.addRating(rating);
        System.out.println(song.getRatings().toString());
        assertTrue(song.getRatings().getValue().equals(rating));

    }

    @Test
    public void testAverage() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("M2e",4));
        double test = song.averageRating();
        assertEquals(test, 4.0, 0.001);
    }

    @Test
    public void testAverage0() {
        double test = song.averageRating();
        assertEquals(test, 0.0, 0.001);    }

    @Test
    public void testAverageInvalidLists() {
        song.addRating(new Rating("Me",100));
        song.addRating(new Rating("M2e",-100));
        double test = song.averageRating();
        assertEquals(test, 0.0, 0.001);    }



}