package com.twu.biblioteca;

import java.io.*;
import java.util.HashMap;

/**
 * Created by gchasifa on 6/11/15.
 */
public class MovieLoader {
    private HashMap<String, Movie> movies = new HashMap<String, Movie>();

    public void load(String filename) throws IOException {
        String text;
        BufferedReader buffer = new BufferedReader(findFile(filename));
        while ((text = buffer.readLine()) != null) {
            String[] moviesRecord = text.trim().split(",");
            Movie movie = new Movie(moviesRecord[0], Integer.parseInt(moviesRecord[1]), moviesRecord[2],moviesRecord[3],Integer.parseInt(moviesRecord[4]));
            movies.put(moviesRecord[0].toUpperCase(), movie);
        }
        buffer.close();
    }

    public HashMap<String, Movie> getMovies(){
        return movies;
    }

    private FileReader findFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        return new FileReader(file);
    }
}
