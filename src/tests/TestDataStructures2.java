package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.Playlist;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.util.LinkedList;

import static org.junit.Assert.*;


public class TestDataStructures2 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class
    private Song song;
    private Rating rating;
    private Reviewer reviewer;
    private Playlist playlistTitleCompare;
    private Playlist playlistBayesianCompare;


    private final double EPSILON = 0.001;
    public void compareDoubles(double d1, double d2) {
        assertTrue(Math.abs(d1 - d2) < EPSILON);
    }


    @Before
    public void setUpSong() {

        song = new Song("See You Again", "Tyler The Creator", "43");
        rating = new Rating("Gordon Ramsey", 3);
        reviewer = new Reviewer("Devan Ng");
        playlistTitleCompare = new Playlist(new SongTitleComparator());
        playlistBayesianCompare = new Playlist(new SongBayesianRatingComparator());

    }

    @Test
    public void addSong() {
        playlistTitleCompare.addSong(new Song("See You Again", "Tyler The Creator", "43"));
        assertTrue(playlistTitleCompare.getSongTree().getValue().getTitle().equals("See You Again"));
        assertTrue(playlistTitleCompare.getSongTree().getValue().getArtist().equals("Tyler The Creator"));
        assertTrue(playlistTitleCompare.getSongTree().getValue().getSongID().equals("43"));
    }

    @Test
    public void noSongs() {
        assertTrue(playlistTitleCompare.getSongTree() == null);

    }

    @Test
    public void testSongListTitle() {
        Song song1 = new Song("Song A", "Artist1", "1");
        playlistTitleCompare.addSong(song1);
        Song song2 = new Song("Song B", "Artist2", "2");
        playlistTitleCompare.addSong(song2);
        Song song3 = new Song("Song C", "Artist3", "3");
        playlistTitleCompare.addSong(song3);
        Song song4 = new Song("Song D", "Artist4", "4");
        playlistTitleCompare.addSong(song4);

        LinkedListNode<Song> song_list = playlistTitleCompare.getSongList();

        System.out.println(song_list.getValue().getTitle());
        System.out.println(song_list.getNext().getValue().getTitle());
        System.out.println(song_list.getNext().getNext().getValue().getTitle());
        System.out.println(song_list.getNext().getNext().getNext().getValue().getTitle());

        assertTrue(playlistTitleCompare.getSongList().getElement(song1) != null);
        assertTrue(playlistTitleCompare.getSongList().getElement(song2) != null);
        assertTrue(playlistTitleCompare.getSongList().getElement(song3) != null);
        assertTrue(playlistTitleCompare.getSongList().getElement(song4) != null);


        assertTrue(playlistTitleCompare.getSongList().getElement(song1).getValue().getTitle().equals("Song A"));
        assertTrue(playlistTitleCompare.getSongList().getElement(song2).getValue().getTitle().equals("Song B"));
        assertTrue(playlistTitleCompare.getSongList().getElement(song3).getValue().getTitle().equals("Song C"));
        assertTrue(playlistTitleCompare.getSongList().getElement(song4).getValue().getTitle().equals("Song D"));
    }



    @Test
    public void testSongListTitleTrueTest() {

        Song song2 = new Song("Song B", "Artist2", "2");
        playlistTitleCompare.addSong(song2);
        Song song1 = new Song("Song A", "Artist1", "1");
        playlistTitleCompare.addSong(song1);
        Song song4 = new Song("Song D", "Artist4", "4");
        playlistTitleCompare.addSong(song4);
        Song song3 = new Song("Song C", "Artist3", "3");
        playlistTitleCompare.addSong(song3);


        LinkedListNode<Song> song_list = playlistTitleCompare.getSongList();

        assertTrue(song_list.getValue().getTitle().equals("Song A"));
        assertTrue(song_list.getNext().getValue().getTitle().equals("Song B"));
        assertTrue(song_list.getNext().getNext().getValue().getTitle().equals("Song C"));
        assertTrue(song_list.getNext().getNext().getNext().getValue().getTitle().equals("Song D"));

    }





}