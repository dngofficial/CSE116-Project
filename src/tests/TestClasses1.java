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
        assertEquals("See You Again", song.getTitle());
    }
    @Test
    public void testGetSongID() {
        assertEquals("43", song.getSongID());
    }

    @Test
    public void getSongArtist() {
        assertEquals("Tyler The Creator", song.getArtist());
    }

    @Test
    public void testSetTitle() {
        song.setTitle("Live Wire");
        assertEquals("Live Wire", song.getTitle());
    }

    @Test
    public void testSetSongID() {
        song.setSongID("57");
        assertEquals("57", song.getSongID());
    }

    @Test
    public void testSetArtist() {
        song.setArtist("Motley Crue");
        assertEquals("Motley Crue", song.getArtist());
    }






}