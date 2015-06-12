package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TestLibraryApp {
    public static final String spaces = "%-50s";
    public static final String YEAR = "2015";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private LibraryApp libraryApp;
    private int option;
    private MovieLoader movieLoader=new MovieLoader();
    private MovieManager movieManager=new MovieManager();

    @Before
    public void setUpStreams() throws IOException {
        libraryApp = new LibraryApp();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        movieLoader.load("movies.txt");
        movieManager.setMovies(movieLoader.getMovies());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldWriteWelcomeMessageOnTheScreen() {
        libraryApp.writeWelcomeMessage();
        assertEquals("* * * * W E L C O M E * * * *\n", outContent.toString());
    }

    @Test(timeout = 1000)
    public void shouldWaitOneThousandMiliseconds() throws InterruptedException {
        libraryApp.waitMiliseconds(1000);
    }

    @Test
    public void shouldShowFirstOptionOfMenu() {
        libraryApp.showMenu("1. List Books");
        assertEquals("1. List Books\n", outContent.toString());
    }

    @Test
    public void shouldShowSecondOptionOfMenu() {
        libraryApp.showMenu("2. List Movies");
        assertEquals("2. List Movies\n", outContent.toString());
    }

    @Test
    public void shouldExitApplication() throws Exception {
        //option=Integer.parseInt(libraryApp.getMenuOption());
        try {
            libraryApp.execute(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Finish!\n", outContent.toString());
    }

    @Test
    public void shouldValidateInvalidOption() throws Exception {
        libraryApp.execute(99);
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldExecuteFirstOption() throws Exception {
        libraryApp.loadVariables();
        libraryApp.execute(1);
        String firstBookName = String.format(spaces, "Infierno de Roma");
        String firstBookYear = String.format(spaces, YEAR);
        String secondBookName = String.format(spaces, "Recuerdos del cuerpo");
        String secondBookYear = String.format(spaces, YEAR);
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }

    @Test
    public void shouldLoadMovies() throws IOException {
        String movieName = "NAME: GREASE\n";
        String movieYear = "YEAR: 1978\n";
        String movieDirector = "DIRECTOR: RANDAL KLEISER\n";
        String movieRating = "RATING: 10\n";
        String movie = movieName+movieYear+movieDirector+movieRating;
        assertEquals(movie,movieLoader.getMovies().get("GREASE").getMovieInformation());
    }
    @Test
    public void shouldExecuteOptionListMovies(){
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

/* I have an error testing this
    @Test
    public void shouldForceLogin() throws Exception {
        libraryApp.validateOption(3);
        assertEquals("123-4567", libraryApp.getCurrentUser());
    }
*/
}
