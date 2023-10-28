package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.*;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestFiles {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private FileReader filereader;

    @Before
    public void setUpSong() {

        filereader = new FileReader();

    }

    @Test
    public void addSong() {
        System.out.println(FileReader.readMovies("data/movies.csv").get(2).getCast());
        assertTrue(2 ==2);
    }
}