package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class TestClasses2 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private Song song;
    private Rating rating;

    private Reviewer reviewer;
    private Movie movie;

    public static boolean compareLists(ArrayList<String> list1, ArrayList<String> list2){
        if (list1.size() != list2.size())
        {
            return  false;
        }
        for(int i = 0; i < list1.size(); i++){
            if(!(list1.get(i).equalsIgnoreCase(list2.get(i)))){
                return false;
            }
        }
        return true;
    }


    @Before
    public void setUpSong() {

        song = new Song("A", "Tyler The Creator", "43");
        rating = new Rating("Gordon Ramsey", 3);
        reviewer = new Reviewer("Devan Ng");
        ArrayList<String> zero_list = new ArrayList<>(){{add("Chris Pratt");add("Zoe Saldana");add("Dave Bautista");}};
        movie = new Movie("Oceans Eleven", zero_list);
    }

    @Test
    public void testBayenianAverage() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("Me2",5));
        double test = song.bayesianAverageRating(2,3);
        assertEquals(test, 3.75, 0.001);
    }

    @Test
    public void testBayenianAverageAlterate() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("Me2",5));
        double test = song.bayesianAverageRating(3,2);
        assertEquals(test, 3.00, 0.001);
    }

    @Test
    public void testBayenianAverage2x() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("Me2",5));
        double test = song.bayesianAverageRating(2,3);
        assertEquals(test, 3.75, 0.001);
        test = song.bayesianAverageRating(2,3);
        assertEquals(test, 3.75, 0.001);
    }

    @Test
    public void testBayenianAverage0total() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("Me2",5));
        double test = song.bayesianAverageRating(0,3);
        assertEquals(test, 4.5, 0.001);

    }

    @Test
    public void testBayenianAverage0totalNil() {
        double test = song.bayesianAverageRating(0,3);
        assertEquals(test, 0.00, 0.001);

    }

    @Test
    public void testBayenianAverageNoRatings() {
        double test = song.bayesianAverageRating(0,3);
        assertEquals(test, 0.0, 0.001);
    }

    @Test
    public void testBayenianAverageInvalidParams() {
        song.addRating(new Rating("Me",4));
        song.addRating(new Rating("Me",5));
        double test = song.bayesianAverageRating(-1,3);
        assertEquals(test, 0.0, 0.001);

        test = song.bayesianAverageRating(1,100);
        assertEquals(test, 0.0, 0.001);

        test = song.bayesianAverageRating(-3,100);
        assertEquals(test, 0.0, 0.001);
    }
    @Test
    public void testGetTitle()
    {
        assertTrue(movie.getTitle().equals("Oceans Eleven"));
    }

    @Test
    public void testGetCast()
    {
        ArrayList<String> expected = new ArrayList<>(){{add("Chris Pratt");add("Zoe Saldana");add("Dave Bautista");}};
        assertTrue(compareLists(movie.getCast(), expected));
    }

    @Test
    public void testGetCastDuplicateNames()
    {
        ArrayList<String> expected = new ArrayList<>(){{add("Chris Pratt");add("Chris Pratt");add("Zoe Saldana");add("Dave Bautista");}};
        assertTrue(!(compareLists(movie.getCast(), expected)));
    }

    @Test
    public void testGetCastImproperNaming()
    {
        ArrayList<String> expected = new ArrayList<>(){{add("CHRIS pratt");add("ZoE SalDANA");add("dAVE bautistA");}};
        assertTrue(compareLists(movie.getCast(), expected));
    }

    @Test
    public void testGetCastMissingLastCastMember()
    {
        ArrayList<String> expected = new ArrayList<>(){{add("CHRIS pratt");add("ZoE SalDANA");}};
        assertTrue(!(compareLists(movie.getCast(), expected)));
    }

    @Test
    public void testGetCastMissingFirst()
    {
        ArrayList<String> expected = new ArrayList<>(){{add("ZoE SalDANA");add("dAVE bautistA");}};
        assertTrue(!(compareLists(movie.getCast(), expected)));
    }

    @Test
    public void compareTitles()
    {
        Song song2 = new Song("B", "Tyler The Creator", "43");
        SongTitleComparator a = new SongTitleComparator();
        System.out.println(a.compare(song, song2));
        assertTrue(a.compare(song, song2));
    }








}