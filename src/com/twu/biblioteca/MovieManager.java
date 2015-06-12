package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by gchasifa on 6/10/15.
 */
public class MovieManager implements LibraryManager {
    private HashMap<String, Movie> movies = new HashMap<String, Movie>();

    public void list() {
            int count=0;
            for (Movie movie : this.getMovies().values()) {
                if (movie.getStatus() == 1) {
                    String formatMovieName = String.format("%-50s", movie.getName());
                    String formatMovieYear = String.format("%-15s", movie.getYear());
                    String formatMovieDirector = String.format("%-40s", movie.getDirector());
                    String formatMovieRating = String.format("%-15s", movie.getRating());
                    System.out.println(formatMovieName + formatMovieYear + formatMovieDirector + formatMovieRating);
                    count++;
                }
            }
        if(count == 0){
            System.out.println("Not Available movies");
        }
    }

    public HashMap<String, Movie> getMovies() {
        return movies;
    }

    public void setMovies(HashMap<String, Movie> movies) {
        this.movies = movies;
    }

    public void checkOut(String name) {
        movies.get(name).setStatus(0);
        System.out.println("Movie Check out Sucessfull!!");
    }

    public void returnTo(String name) {
        movies.get(name).setStatus(1);
        System.out.println("Movie Return Sucessfull!!");
    }

}
