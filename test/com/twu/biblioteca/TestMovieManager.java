package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by gchasifa on 6/10/15.
 */
public class TestMovieManager {
    public MovieManager movieManager=new MovieManager();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        HashMap<String, Movie> movie=new HashMap<String, Movie>();
        movie.put("GREASE",new Movie("GREASE",1978,"RANDAL KLEISER","10",1));
        movieManager.setMovies(movie);
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    @Test
    public void shouldListOnlyAvailableMovies(){
        movieManager.list();
        String formatMovieName = String.format("%-50s","GREASE");
        String formatMovieYear = String.format("%-15s", 1978);
        String formatMovieDirector = String.format("%-40s", "RANDAL KLEISER");
        String formatMovieRating = String.format("%-15s",10);
        assertEquals(formatMovieName+formatMovieYear+formatMovieDirector+formatMovieRating+"\n",outContent.toString());
    }
    @Test
    public void shouldCheckoutAMovie(){
        movieManager.checkOut("GREASE");
        assertEquals(0,movieManager.getMovies().get("GREASE").getStatus());
    }
    @Test
    public void shouldReturnAMovie(){
        movieManager.returnTo("GREASE");
        assertEquals(1,movieManager.getMovies().get("GREASE").getStatus());
    }
}
