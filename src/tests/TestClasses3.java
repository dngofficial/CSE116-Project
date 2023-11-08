package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestClasses3 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private FileReader filereader;
    private ArrayList<Movie> expected;

    @Before
    public void setUpFileReader() {

        filereader = new FileReader();

        expected = new ArrayList<>(){{
            add(new Movie("American Pie", new ArrayList<String>() {{
                add("Me!");
            }}));

            add(new Movie("Jay and Silent Bob Strike Back", new ArrayList<String>() {{
                add("Lindsay Crouse");
            }}));
        }};

    }

    @Test
    public void testMovieInfo()
    {
        ArrayList<Movie> expected = new ArrayList<>(){{
            add(new Movie("Powder", new ArrayList<String>() {{
                add("Mary Steenburgen");
                add("Sean Patrick Flanery");
                add("Lance Henriksen");
                add("Jeff Goldblum");
                add("Brandon Smith");
            }}));

            add(new Movie("The Indian in the Cupboard", new ArrayList<String>() {{
                add("Lindsay Crouse");
                add("Richard Jenkins");
                add("Steve Coogan");
                add("David Keith");
                add("Nestor Serrano");
            }}));
        }};

        expected.get(0).setTitle("fortnite");

        assertEquals("fortnite", expected.get(0).getTitle());

    }
@Test
    public void testSongPrintRatings() {


        ArrayList<Movie> movies = FileReader.readMovieRatings(expected, "data/smaller_movie_ratings.csv");
        for (Movie movie : movies)
        {
            System.out.println("Movie: " + movie.getTitle());
            System.out.println(movie.outputtingList());
            System.out.println("----------------------------------------------------");
        }


    }

}