package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by gchasifa on 5/12/15.
 */
public class TestBibiloteca {
    private Biblioteca biblioteca;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private String bookName;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        bookName="RECUERDOS DEL CUERPO";
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testFileNotFoundException() throws IOException {
        biblioteca.loadBooks("librose.txt");
    }

    @Test
    public void shouldFindABook() throws IOException {
        biblioteca.loadBooks("libros.txt");
        String bookName = "Infierno de roma";
        assertEquals(bookName.toUpperCase(), biblioteca.findBook(bookName).getName().toUpperCase());
    }

    @Test
    public void shouldReadTheCorrectNumberOfBooks() throws IOException {
        biblioteca.loadBooks("libros.txt");
        assertEquals(2, biblioteca.getBooks().size());
    }

    @Test
    public void shouldReadTheFirstBookFromTheInputFile() throws IOException {
        biblioteca.loadBooks("libros.txt");
        Book firstBook = biblioteca.getBooks().get(bookName);
        assertEquals(bookName, firstBook.getName());
        assertEquals(2015, firstBook.getYear());
    }

    @Test
    public void shouldListBooks() throws IOException {
        String firstBookName = String.format("%-50s", "Infierno de Roma");
        String firstBookYear = String.format("%-50s", "2015");
        String secondBookName = String.format("%-50s", "Recuerdos del cuerpo");
        String secondBookYear = String.format("%-50s", "2015");
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        biblioteca.loadBooks("libros.txt");
        biblioteca.listBooks();
        assertEquals(text.toUpperCase(), outContent.toString());
    }
    @Test
    public void shouldCheckoutBook() throws IOException {
        biblioteca.loadBooks("libros.txt");
        biblioteca.checkOut(bookName);
        assertEquals(0, biblioteca.getBooks().get(bookName).getStatus());
    }
    @Test
    public void shouldListOnlyAvailableBooks() throws IOException {
        biblioteca.loadBooks("libros.txt");
        biblioteca.listOnlyAvailableBooks();
        String firstBookName = String.format("%-50s", "Infierno de Roma");
        String firstBookYear = String.format("%-50s", "2015");
        String secondBookName = String.format("%-50s", "Recuerdos del cuerpo");
        String secondBookYear = String.format("%-50s", "2015");
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }

    @Test
    public void shouldCheckOutAndListOnlyAvailableBooks() throws IOException {
        biblioteca.loadBooks("libros.txt");
        biblioteca.checkOut(bookName);
        biblioteca.listOnlyAvailableBooks();
        String firstBookName = String.format("%-50s", "Infierno de Roma");
        String firstBookYear = String.format("%-50s", "2015");
        String text = firstBookName + firstBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }
    @Test
    public void shouldReturnBook() throws IOException {
        biblioteca.loadBooks("libros.txt");
        biblioteca.returnBook(bookName);
    }
}