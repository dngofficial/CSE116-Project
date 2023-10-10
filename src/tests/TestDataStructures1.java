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
    public void testAverageSmallListOfOneValue() {
        song.addRating(new Rating("Me",4));
        double test = song.averageRating();
        assertEquals(test, 4.0, 0.001);
    }

    @Test
    public void testAverageSmallerValues() {
        song.addRating(new Rating("Me",1));
        song.addRating(new Rating("M2e",1));
        song.addRating(new Rating("M3e",1));

        double test = song.averageRating();
        assertEquals(test, 1.0, 0.001);
    }

    @Test
    public void testAverageSmallerList() {
        song.addRating(new Rating("Me",2));
        song.addRating(new Rating("M2e",3));
        song.addRating(new Rating("M3e",2));
        song.addRating(new Rating("M4e",1));


        double test = song.averageRating();
        assertEquals(test, 2.0, 0.001);
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
    @Test
    public void testAverageLots() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("M2e",4));
        song.addRating(new Rating("M3e",4));
        song.addRating(new Rating("M4e",4));
        song.addRating(new Rating("M5e",4));
        song.addRating(new Rating("M6e",4));
        song.addRating(new Rating("M7e",4));
        song.addRating(new Rating("M8e",4));
        double test = song.averageRating();
        assertEquals(test, 4.0, 0.001);
    }


    @Test
    public void testRemoveItemFromListFirstItemInList() {
        Rating review = new Rating("Me3",1);
        song.addRating(review);
        Reviewer reviewer1 = new Reviewer("Me3");
        song.removeRatingByReviewer(reviewer1);
        System.out.println(song.getRatings());
        System.out.println(review);

        assertTrue(song.getRatings() == null);
}
    @Test
    public void testRemoveItemFromListLastItemInList() {

        song.addRating(new Rating("Me",1));
        song.addRating(new Rating("Me2",2));
        song.addRating(new Rating("Me4",3));
        Rating review = new Rating("Me3",4);
        song.addRating(review);
        Reviewer reviewer1 = new Reviewer("Me3");
        song.removeRatingByReviewer(reviewer1);
        assertTrue(song.getRatings().getElement(review) == null);
    }

    @Test
    public void testRemoveItemFromListMiddle() {

        song.addRating(new Rating("Me",1));
        song.addRating(new Rating("Me2",2));
        Rating review = new Rating("Me3",3);
        song.addRating(review);
        song.addRating(new Rating("Me4",4));
        Reviewer reviewer1 = new Reviewer("Me3");
        song.removeRatingByReviewer(reviewer1);
        assertTrue(song.getRatings().getElement(review) == null);
    }
    @Test
    public void testRemoveItemFromListSpammingDeleteMethod() {

        song.addRating(new Rating("Me", 1));
        song.addRating(new Rating("Me2", 2));
        Rating review = new Rating("Me3", 3);
        song.addRating(review);
        Rating review2 = new Rating("Me3", 4);
        song.addRating(review2);
        Rating review3 = new Rating("Me3", 4);
        song.addRating(review3);
        song.addRating(new Rating("Me4", 4));
        Reviewer reviewer1 = new Reviewer("Me3");
        song.removeRatingByReviewer(reviewer1);
        assertTrue(song.getRatings().getElement(review) == null);
        assertTrue(song.getRatings().getElement(review2) != null);
        assertTrue(song.getRatings().getElement(review3) != null);
    }

        @Test
        public void testRemoveItemFromListSpammingDeleteMethoda() {

            song.addRating(new Rating("Me",1));
            song.addRating(new Rating("Me2",2));
            Rating review = new Rating("Me3",3);
            song.addRating(review);
            Rating review2 = new Rating("Me3",4);
            song.addRating(review2);
            Rating review3 = new Rating("Me3",5);
            song.addRating(review3);
            song.addRating(new Rating("Me4",1));
            Reviewer reviewer1 = new Reviewer("Me3");
            song.removeRatingByReviewer(reviewer1);
            song.removeRatingByReviewer(reviewer1);
            song.removeRatingByReviewer(reviewer1);
            assertTrue(song.getRatings().getElement(review) == null);
            assertTrue(song.getRatings().getElement(review2) == null);
            assertTrue(song.getRatings().getElement(review3) == null);
        }

}