package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestClasses3 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private FileReader filereader;
    private ArrayList<Movie> expected;

    private MediaLibrary medialib;

    @Before
    public void setUpFileReader() {

        filereader = new FileReader();
        medialib = new MediaLibrary();

        expected = new ArrayList<>(){{
            add(new Movie("American Pie", new ArrayList<String>() {{
                add("Me!");
            }}));

            add(new Movie("Jay and Silent Bob Strike Back", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));
            add(new Movie("Rebecca", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));

            add(new Movie("Ocean's Twelve", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));
        }};


    }


    public void testSongPrintRatings() {


        ArrayList<Movie> movies = FileReader.readMovieRatings(expected, "data/smaller_movie_ratings.csv");
        for (Movie movie : movies)
        {
            System.out.println("Movie: " + movie.getTitle());
            System.out.println(movie.outputtingList());
            System.out.println("----------------------------------------------------");
        }


    }

    public void compareLinkedLists(LinkedListNode<Rating> l1, LinkedListNode<Rating> l2) {
        if(!(l1 == null && l2 == null))
        {
            assertTrue("l1 was null, but l2 was not", l1 != null);
            assertTrue("l2 was null, but l1 was not", l2 != null);
            assertTrue("node values are not equal",l1.getValue().getRating() == l2.getValue().getRating());
            assertTrue("node values are not equal - title",l1.getValue().getReviewerID().equals(l2.getValue().getReviewerID()));

            compareLinkedLists(l1.getNext(), l2.getNext());
        }
    }
    @Test
    public void testLinkedLists() {
        LinkedListNode<Rating> expected1 = new LinkedListNode<>(new Rating("2", 3), null);
        expected1 = new LinkedListNode<>(new Rating("1", 4), expected1);

        compareLinkedLists(expected1, FileReader.readMovieRatings(expected, "data/smaller_movie_ratings.csv").get(0).getRatings());
    }
    public static void compareMovies(Movie movie1, Movie movie2) {
        assertEquals(movie1.getTitle(), movie2.getTitle());
        assertEquals(movie1.getCast(), movie2.getCast());
    }

    private void compareMoviesTrueTest(ArrayList<Movie> movie_list_1, ArrayList<Movie> movie_list_2){
        assertEquals(movie_list_1.size(), movie_list_2.size());
        for (int i = 0; i < movie_list_1.size(); i++) {
            compareMovies(movie_list_1.get(i), movie_list_2.get(i));
        }
    }

    @Test
    public void testMovieCompare()
    {

        ArrayList<Movie> old = new ArrayList<>(){{
            add(new Movie("American Pie", new ArrayList<String>() {{
                add("Me!");
            }}));

            add(new Movie("Jay and Silent Bob Strike Back", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));
            add(new Movie("Rebecca", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));

            add(new Movie("Ocean's Twelve", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));
        }};;

        ArrayList<Movie> mov = FileReader.readMovieRatings(expected, "data/smaller_movie_ratings.csv");
        System.out.println(old);

        System.out.println(old.size());


        assertFalse(old.size() == mov.size());


    }
    @Test
    public void testMovieEmpty() {
        assertTrue(FileReader.readMovieRatings(expected, "data/dne.csv").isEmpty());
    }

    public void testMediaLib() {

        medialib.populateLibrary("data/rating_test_1.csv","data/test_movies_ratings.csv", "data/smaller_movie_ratings.csv");

        for (Ratable movie : medialib.returnMasterList())
        {
            System.out.println("Title: " + movie.getTitle());
            System.out.println(movie.outputtingList());
            System.out.println("Bayesian Average: " + movie.bayesianAverageRating(2,3));
            System.out.println("----------------------------------------------------");
        }
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------------------------------------------");

        for (Ratable movie : medialib.topKRatables(5))
        {
            System.out.println("Title: " + movie.getTitle());
            System.out.println(movie.outputtingList());
            System.out.println("----------------------------------------------------");
        }
    }

    @Test
    public void testMediaLibKOverflow() {

        medialib.populateLibrary("data/rating_test_1.csv","data/test_movies_ratings.csv", "data/smaller_movie_ratings.csv");
        assertTrue(medialib.topKRatables(5).size() == 4);

    }

    @Test
    public void testMediaLibTopTitleTest() {

        medialib.populateLibrary("data/rating_test_1.csv","data/test_movies_ratings.csv", "data/smaller_movie_ratings.csv");
        assertTrue(medialib.topKRatables(3).size() == 3);

        assertTrue("failed", medialib.topKRatables(3).get(0).getTitle().equals("Bitter"));


    }

    @Test
    public void testMediaLibMoviesOnly() {

        medialib.populateLibrary("data/DNE.csv","data/test_movies_ratings.csv", "data/smaller_movie_ratings.csv");
        assertTrue(medialib.topKRatables(2).size() == 2);

        assertTrue("failed", medialib.topKRatables(2).get(0).getTitle().equals("Jay and Silent Bob Strike Back"));
    }

    @Test
    public void testMediaLibSongsOnly() {

        medialib.populateLibrary("data/rating_test_1.csv","data/dne.csv", "data/dne.csv");
        assertTrue(medialib.topKRatables(2).size() == 1);

        assertTrue("failed", medialib.topKRatables(2).get(0).getTitle().equals("Bitter"));
    }





}