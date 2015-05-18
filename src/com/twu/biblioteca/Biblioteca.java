package com.twu.biblioteca;

import com.sun.tools.classfile.ConstantPool;

import java.io.*;
import java.util.*;

public class Biblioteca {
    private HashMap<String, Book> books = new HashMap<String, Book>();

    public Biblioteca() {
    }

    public void checkOut(String name){
            books.get(name).setStatus(0);
    }

    public void loadBooks(String filename) throws IOException {
        String text;
        BufferedReader buffer = new BufferedReader(findFile(filename));
        while ((text = buffer.readLine()) != null) {
            String[] cadena = text.trim().split(",");
            Book book = new Book(cadena[0], Integer.parseInt(cadena[1]), Integer.parseInt(cadena[2]));
            books.put(cadena[0].toUpperCase(), book);
        }
        buffer.close();
    }

    private FileReader findFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        return new FileReader(file);


    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public void listBooks() {
        for (Book book : this.getBooks().values()) {
            String formatBookName = String.format("%-50s", book.getName());
            String formatBookYear = String.format("%-50s", book.getYear());
            System.out.println(formatBookName + formatBookYear);
        }
    }

    public Book findBook(String bookName) {
        for (Book book : getBooks().values()) {
            if (bookName.toUpperCase().compareTo(book.getName().toUpperCase()) == 0) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(String bookName) {
        books.get(bookName).setStatus(1);
    }

    public void listOnlyAvailableBooks() {
        for (Book book : this.getBooks().values()) {
            if (book.getStatus() == 1) {
                String formatBookName = String.format("%-50s", book.getName());
                String formatBookYear = String.format("%-50s", book.getYear());
                System.out.println(formatBookName + formatBookYear);
            }
        }
    }
}