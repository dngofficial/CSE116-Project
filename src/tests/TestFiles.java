package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestFiles {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private FileReader filereader;

    @Before
    public void setUpFileReader() {

        filereader = new FileReader();

    }

    public static boolean compareLists(ArrayList<String> list1, ArrayList<String> list2){
        if (list1.size() != list2.size() || list1.isEmpty() || list2.isEmpty())
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

    public static boolean testLists(LinkedListNode<Rating> node, ArrayList<Integer> list2)
    {
        if(node == null){
            return false;
        }
        else {
            int i = 0;
            LinkedListNode<Rating> temp = node;
            while (temp != null) {
                if (temp.getValue().getRating() != list2.get(i)){ return false;}
                temp = temp.getNext();
                i++;
            } //all values
        }
        return true;

    }

    @Test
    public void testMovieCast() {
        ArrayList<String> zero_list = new ArrayList<>(){{add("Mary Steenburgen");add("Sean Patrick Flanery");add("Lance Henriksen");add("Jeff Goldblum");add("Brandon Smith");}};

        assertTrue(compareLists(zero_list, FileReader.readMovies("data/movies.csv").get(17).getCast()));
    }

    @Test
    public void testSongRatings() {
        LinkedListNode<Rating> node = FileReader.readSongs("data/ratings.csv").get(1).getRatings();
        ArrayList<Integer> zero_list = new ArrayList<>(){{add(5);add(4);add(4);}};

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

}