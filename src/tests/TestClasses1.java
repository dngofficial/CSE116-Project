package tests;

import org.junit.Before;
import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestClasses1 {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

    //we are testing EACH individual case

    private Song song;
    private Rating rating;

    private Reviewer reviewer;


    @Before
    public void setUpSong() {

        song = new Song("See You Again", "Tyler The Creator", "43");
        rating = new Rating("Gordon Ramsey", 3);
        reviewer = new Reviewer("Devan Ng");
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
    @Test
    public void testEmptyTitle() {
        song.setTitle("");
        assertTrue(song.getTitle().equals(""));
    }

    @Test
    public void testEmptyArtist() {
        song.setArtist("");
        assertTrue(song.getArtist().equals(""));
    }

    @Test
    public void testEmptySongID() {
        song.setSongID("");
        assertTrue(song.getSongID().equals(""));
    }


    @Test
    public void testGetReviewerID()
    {
        assertTrue(rating.getReviewerID().equals("Gordon Ramsey"));
    }

    @Test
    public void testGetRating()
    {
        assertTrue(rating.getRating() == 3);
    }
    @Test
    public void testSetReviewerID()
    {
        rating.setReviewerID("Evil Gordon Ramsey");
        assertTrue(rating.getReviewerID().equals("Evil Gordon Ramsey"));
    }

    @Test
    public void testSetRatingWithinRange()
    {
        rating.setRating(4);
        assertTrue(rating.getRating() ==4);
    }

    @Test
    public void testSetRatingOutsideRange()
    {
        rating.setRating(100);
        assertTrue(rating.getRating() ==-1);
    }

    @Test
    public void testSetRatingOutsideRangeNegative()
    {
        rating.setRating(-100);
        assertTrue(rating.getRating() ==-1);
    }

    @Test
    public void testSetRatingOutsideRangeLarge()
    {
        rating.setRating(1000);
        assertTrue(rating.getRating() ==-1);
        rating.setRating(-1000);
        assertTrue(rating.getRating() ==-1);
    }

    @Test
    public void testSetRatingOutsideRange0()
    {
        rating.setRating(0);
        assertTrue(rating.getRating() ==-1);
    }

    @Test
    public void testSettingMinimumRange()
    {
        rating.setRating(1);
        assertTrue(rating.getRating() ==1);
    }

    @Test
    public void testSettingMaximumRange()
    {
        rating.setRating(5);
        assertTrue(rating.getRating() ==5);
    }


    @Test
    public void testNewRatingConstructorError()
    {
        Rating new_rating = new Rating("placeholder",100);
        assertTrue(new_rating.getRating() ==-1);
    }

    @Test
    public void testEmptyGetRatingReviewer() {
        rating.setReviewerID("");
        assertTrue(rating.getReviewerID().equals(""));
    }

    @Test
    public void testGetReviewerIDForReviweer()
    {
        assertTrue(reviewer.getReviewerID().equals("Devan Ng"));
    }

    @Test
    public void testSetReviewerIDForReviewer()
    {
        reviewer.setReviewerID("Evil Devan Ng");
        assertTrue(reviewer.getReviewerID().equals("Evil Devan Ng"));
    }

    @Test
    public void testEmptyGetRatingReviewerForReviewer() {
        reviewer.setReviewerID("");
        assertTrue(reviewer.getReviewerID().equals(""));
    }

    @Test
    public void testRateSongNormal(){
        Rating rating = reviewer.rateSong(3);
        assertTrue(rating.getRating() == 3);
    }


    @Test
    public void testRateSongMinMax(){
        Rating rating = reviewer.rateSong(1);
        assertTrue(rating.getRating() == 1);
        assertTrue(rating.getReviewerID().equals("Devan Ng"));
        Rating rating2 = reviewer.rateSong(5);
        assertTrue(rating2.getRating() == 5);
        assertTrue(rating2.getReviewerID().equals("Devan Ng"));
    }

    @Test
    public void testRateSongExtremeValue(){
        Rating rating = reviewer.rateSong(1000);
        assertTrue(rating.getRating() == -1);
        assertTrue(rating.getReviewerID().equals("Devan Ng"));
        Rating rating2 = reviewer.rateSong(-1000);
        assertTrue(rating2.getRating() == -1);
        assertTrue(rating2.getReviewerID().equals("Devan Ng"));
    }










}