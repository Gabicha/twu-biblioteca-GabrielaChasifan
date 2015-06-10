package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by gchasifa on 5/12/15.
 */
public class TestLibrarian {
    public static final String SPACES = "%-50s";
    public static final String YEAR = "2015";
    public static final String FILE_NAME = "libros.txt";
    public static final String INFIERNO_DE_ROMA_BOOK = "Infierno de Roma";
    public static final String RECUERDOS_DEL_CUERPO_BOOK = "Recuerdos del cuerpo";
    private Librarian librarian;
    private LoaderTextFile booksLoaderTextFile;
    private HashMap<String, Book> books;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private String bookName;

    @Before
    public void setUp() {
        booksLoaderTextFile=new LoaderTextFile();
        books=booksLoaderTextFile.getBooks();
        librarian = new Librarian(books);

        //librarian.setBooks(books);
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
        booksLoaderTextFile.load("librose.txt");
    }

    @Test
    public void shouldFindABook() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        String bookName = INFIERNO_DE_ROMA_BOOK;
        assertEquals(bookName.toUpperCase(), librarian.findBook(bookName).getName().toUpperCase());
    }

    @Test
    public void shouldReadTheCorrectNumberOfBooks() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        assertEquals(2, librarian.getBooks().size());
    }

    @Test
    public void shouldReadTheFirstBookFromTheInputFile() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        Book firstBook = librarian.getBooks().get(bookName);
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
        booksLoaderTextFile.load(FILE_NAME);
        librarian.listBooks();
        assertEquals(text.toUpperCase(), outContent.toString());
    }
    @Test
    public void shouldCheckoutBook() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        librarian.checkOut(bookName);
        assertEquals(0, librarian.getBooks().get(bookName).getStatus());
    }
    @Test
    public void shouldListOnlyAvailableBooks() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        librarian.listOnlyAvailableBooks();
        String firstBookName = String.format(SPACES, INFIERNO_DE_ROMA_BOOK);
        String firstBookYear = String.format(SPACES, YEAR);
        String secondBookName = String.format(SPACES, RECUERDOS_DEL_CUERPO_BOOK);
        String secondBookYear = String.format(SPACES, YEAR);
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }

    @Test
    public void shouldCheckOutAndListOnlyAvailableBooks() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        librarian.checkOut(bookName);
        librarian.listOnlyAvailableBooks();
        String firstBookName = String.format(SPACES, INFIERNO_DE_ROMA_BOOK);
        String firstBookYear = String.format(SPACES, YEAR);
        String text = firstBookName + firstBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }
    @Test
    public void shouldReturnBook() throws IOException {
        booksLoaderTextFile.load(FILE_NAME);
        librarian.returnBook(bookName);
    }
}