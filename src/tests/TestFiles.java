package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;


public class TestFiles {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private FileReader filereader;

    @Before
    public void setUpFileReader() {

        filereader = new FileReader();

    }

    public static boolean compareLists(ArrayList<String> list1, ArrayList<String> list2) {
        if(list1.size() == 0 || list2.size() == 0)
        {
            return false;
        }
        else {
            assertTrue(list1.size() ==list2.size());
            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i));
                System.out.println(list2.get(i));

                assertTrue(list1.get(i).equals(list2.get(i)));
            }
            return true;
        }
    }

    public static boolean existenceMovie(ArrayList<Movie> list1, String title) {

        assertNotNull(list1);
        assertTrue(!(list1.isEmpty()));

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void existenceMovie(ArrayList<Song> list1, Song song) {

        assertNotNull(list1);
        assertFalse(list1.isEmpty());

        boolean bool = false;

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getTitle().equals(song.getTitle()) && list1.get(i).getSongID().equals(song.getSongID()) && list1.get(i).getArtist().equals(song.getArtist())) {
                bool = true;
            }
        }
        assertTrue(bool);
    }


    public static boolean testLists(LinkedListNode<Rating> node, ArrayList<Integer> list2) {
        if (node == null) {
            return false;
        } else {
            int i = 0;
            LinkedListNode<Rating> temp = node;
            while (temp != null) {
                if (temp.getValue().getRating() != list2.get(i)) {
                    return false;
                }
                temp = temp.getNext();
                i++;
            } //all values
        }
        return true;
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

        compareMoviesTrueTest(FileReader.readMovies("data/movie_test_1.csv"), expected);
    }
    @Test
    public void testMovieCast() {
        ArrayList<String> zero_list = new ArrayList<>() {{
            add("Mary Steenburgen");
            add("Sean Patrick Flanery");
            add("Lance Henriksen");
            add("Jeff Goldblum");
            add("Brandon Smith");
        }};

        ArrayList<String> cast_list = FileReader.readMovies("data/movie_test_2.csv").get(1).getCast();
        assertFalse(cast_list.isEmpty() || cast_list.size() == 0 || cast_list.get(0) == null);
        assertFalse(zero_list.isEmpty() || zero_list.size() == 0 || zero_list.get(0) == null);
        assertArrayEquals(cast_list.toArray(), zero_list.toArray());
    }


    public void testSongPrintRatings() {
        ArrayList<Song> songs = FileReader.readSongs("data/ratings.csv");
        for (Song song : songs)
        {
            System.out.println("Song: " + song.getTitle() + " Artist: " + song.getArtist() + " ID: " + song.getSongID());
            System.out.println(song.outputtingList());
        }


    }

        @Test
    public void testSongRatings() {
        LinkedListNode<Rating> node = FileReader.readSongs("data/rating_test_1.csv").get(0).getRatings();
        ArrayList<Integer> zero_list = new ArrayList<>() {{
            add(5);
            add(4);
            add(4);
        }};

        System.out.println(zero_list);
        assertTrue(testLists(node, zero_list));
    }

    @Test
    public void testMovieEmpty() {
        assertTrue(FileReader.readMovies("data/moviesdne.csv").isEmpty());
    }

    @Test
    public void testSongEmpty() {
        assertTrue(FileReader.readSongs("data/ratingsdne.csv").isEmpty());
    }

    @Test
    public void testMovieBasicInfo() {
        assertTrue(existenceMovie(FileReader.readMovies("data/movies.csv"), "Wind River"));
    }



    public static boolean testMovOrder() {
        try {
            ArrayList<String> return_arraylist = new ArrayList<String>();
            ArrayList<String> master_csv_lines = new ArrayList<>(Files.readAllLines(Paths.get("data/movies.csv")));
            for (String unsplit_movie_list : master_csv_lines) {
                ArrayList<String> split_string_movie = new ArrayList<>(Arrays.asList(unsplit_movie_list.split(",")));
                return_arraylist.add(split_string_movie.get(0));
            }

            for (Movie mov : FileReader.readMovies("data/movies.csv")) {
                if (!(return_arraylist.contains(mov.getTitle()))) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMovieListOrder() {
        assertTrue(testMovOrder());
    }

    @Test
    public void testSongBasicInfo1() {
        existenceMovie(FileReader.readSongs("data/ratings.csv"), new Song("Purple Haze", "Jimmy Hendrix", "0wJoRiX5K5BxlqZTolB2LD"));
    }
@Test
    public void testSongBasicInfoID() {
        String id = FileReader.readSongs("data/rating_test_1.csv").get(0).getRatings().getValue().getReviewerID();

        assertTrue(id.equals("264"));
    }


        public void compareLinkedLists(LinkedListNode<Rating> l1, LinkedListNode<Rating> l2) {
        if(!(l1 == null && l2 == null))
        {
            assertTrue("l1 was null, but l2 was not", l1 != null);
            assertTrue("l2 was null, but l1 was not", l2 != null);
            assertTrue("node values are not equal",l1.getValue().getRating() == l2.getValue().getRating());
            compareLinkedLists(l1.getNext(), l2.getNext());
        }
    }
    @Test
    public void testLinkedLists() {
        LinkedListNode<Rating> expected = new LinkedListNode<>(new Rating("1", 4), null);
        expected = new LinkedListNode<>(new Rating("1", 4), expected);
        expected = new LinkedListNode<>(new Rating("1", 5), expected);

        compareLinkedLists(expected, FileReader.readSongs("data/rating_test_1.csv").get(0).getRatings());
    }

}