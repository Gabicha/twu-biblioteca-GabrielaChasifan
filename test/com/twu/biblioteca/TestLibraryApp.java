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

    @Before
    public void setUpStreams() throws IOException {
        libraryApp = new LibraryApp();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
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
        libraryApp.waitOneThousandMiliseconds();
    }

    @Test
    public void shouldShowFirstOptionOfMenu() {
        libraryApp.showMenu("1. List Books");
        assertEquals("1. List Books\n", outContent.toString());
    }

    @Test
    public void shouldShowSecondOptionOfMenu() {
        libraryApp.showMenu("2. Exit");
        assertEquals("2. Exit\n", outContent.toString());
    }

    @Test
    public void shouldExitApplication() throws IOException {
        //option=Integer.parseInt(libraryApp.getMenuOption());
        libraryApp.execute(4);
        assertEquals("Finish!\n", outContent.toString());
    }

    @Test
    public void shouldValidateInvalidOption() throws IOException {
        //option=Integer.parseInt(libraryApp.getMenuOption());
        libraryApp.execute(0);
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldExecuteFirstOption() throws IOException {
        libraryApp.loadVariables();
        libraryApp.execute(1);
        String firstBookName = String.format(spaces, "Infierno de Roma");
        String firstBookYear = String.format(spaces, YEAR);
        String secondBookName = String.format(spaces, "Recuerdos del cuerpo");
        String secondBookYear = String.format(spaces, YEAR);
        String text = firstBookName + firstBookYear + "\n" + secondBookName + secondBookYear + "\n";
        assertEquals(text.toUpperCase(), outContent.toString());
    }


}
