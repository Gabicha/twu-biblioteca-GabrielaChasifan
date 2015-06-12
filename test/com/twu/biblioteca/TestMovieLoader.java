package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by gchasifa on 6/11/15.
 */
public class TestMovieLoader {
    @Test
    public void shouldLoadTheMovies() throws IOException {
        MovieLoader movieLoader=new MovieLoader();
        movieLoader.load("movies.txt");
        String movieName = "NAME: GREASE\n";
        String movieYear = "YEAR: 1978\n";
        String movieDirector = "DIRECTOR: RANDAL KLEISER\n";
        String movieRating = "RATING: 10\n";
        String movie = movieName+movieYear+movieDirector+movieRating;
        assertEquals(movie,movieLoader.getMovies().get("GREASE").getMovieInformation());
    }
}
