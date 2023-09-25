package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.Song;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.HashMap;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses1 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private Song song;

    @Before
    public void setUpSong() {
        song = new Song("See You Again", "Tyler The Creator", "43");
    }

    @Test
    public void testGetTitle() {
        assertTrue(song.getTitle().equals("See You Again"));
    }
    @Test

    public void getSongArtist() {
        assertTrue(song.getArtist().equals("Tyler The Creator"));

    }
    @Test
    public void testGetSongID() {
        assertTrue(song.getSongID().equals("43"));

    }

    @Test
    public void testSetTitle() {
        song.setTitle("Live Wire");
        assertTrue(song.getTitle().equals("Live Wire"));
    }

    @Test
    public void testSetSongID() {
        song.setSongID("57");
        assertTrue(song.getSongID().equals("57"));
    }

    @Test
    public void testSetArtist() {
        song.setArtist("Motley Crue");
        assertTrue(song.getArtist().equals("Motley Crue"));
    }






}