package com.twu.biblioteca;

import java.io.*;
import java.util.HashMap;

/**
 * Created by gchasifa on 6/9/15.
 */
public class BookLoader implements Loader {
    private HashMap<String, Book> books = new HashMap<String, Book>();

    public void load(String filename) throws IOException{
        String text;
        BufferedReader buffer = new BufferedReader(findFile(filename));
        while ((text = buffer.readLine()) != null) {
            String[] booksRecord = text.trim().split(",");
            Book book = new Book(booksRecord[0], Integer.parseInt(booksRecord[1]), Integer.parseInt(booksRecord[2]));
            books.put(booksRecord[0].toUpperCase(), book);
        }
        buffer.close();
    }

    public HashMap<String, Book> getBooks(){
        return books;
    }

    private FileReader findFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        return new FileReader(file);
    }
}
