package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by gchasifa on 5/12/15.
 */
public class TestBibiloteca {
    public static final String SPACES = "%-50s";
    public static final String YEAR = "2015";
    public static final String FILE_NAME = "libros.txt";
    public static final String INFIERNO_DE_ROMA_BOOK = "Infierno de Roma";
    public static final String RECUERDOS_DEL_CUERPO_BOOK = "Recuerdos del cuerpo";
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
        biblioteca.loadBooks(FILE_NAME);
        String bookName = INFIERNO_DE_ROMA_BOOK;
        assertEquals(bookName.toUpperCase(), biblioteca.findBook(bookName).getName().toUpperCase());
    }

    @Test
    public void shouldReadTheCorrectNumberOfBooks() throws IOException {
        biblioteca.loadBooks(FILE_NAME);
        assertEquals(2, biblioteca.getBooks().size());
    }

    @Test
    public void shouldReadTheFirstBookFromTheInputFile() throws IOException {
        biblioteca.loadBooks(FILE_NAME);
        Book firstBook = biblioteca.getBooks().get(bookName);
        assertEquals(bookName, firstBook.getName());
        assertEquals(2015, firstBook.getYear());
    }

    @Test
    public void shouldListBooks() throws IOException {
        String firstBookName = String.format(SPACES, INFIERNO_DE_ROMA_BOOK);
        String firstBookYear = String.format(SPACES, YEAR);
        String secondBookName = String.format(SPACES, RECUERDOS_DEL_CUERPO_BOOK);
        String secondBookYear = String.format(SPACES, YEAR);
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        biblioteca.loadBooks(FILE_NAME);
        biblioteca.listBooks();
        assertEquals(text.toUpperCase(), outContent.toString());
    }
    @Test
    public void shouldCheckoutBook() throws IOException {
        biblioteca.loadBooks(FILE_NAME);
        biblioteca.checkOut(bookName);
        assertEquals(0, biblioteca.getBooks().get(bookName).getStatus());
    }
    @Test
    public void shouldListOnlyAvailableBooks() throws IOException {
        biblioteca.loadBooks(FILE_NAME);
        biblioteca.listOnlyAvailableBooks();
        String firstBookName = String.format(SPACES, INFIERNO_DE_ROMA_BOOK);
        String firstBookYear = String.format(SPACES, YEAR);
        String secondBookName = String.format(SPACES, RECUERDOS_DEL_CUERPO_BOOK);
        String secondBookYear = String.format(SPACES, YEAR);
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }

    @Test
    public void shouldCheckOutAndListOnlyAvailableBooks() throws IOException {
        biblioteca.loadBooks(FILE_NAME);
        biblioteca.checkOut(bookName);
        biblioteca.listOnlyAvailableBooks();
        String firstBookName = String.format(SPACES, INFIERNO_DE_ROMA_BOOK);
        String firstBookYear = String.format(SPACES, YEAR);
        String text = firstBookName + firstBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }
    @Test
    public void shouldReturnBook() throws IOException {
        biblioteca.loadBooks(FILE_NAME);
        biblioteca.returnBook(bookName);
    }
}