package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestBibliotecaApp {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private BibliotecaApp bibliotecaApp;
    private int option;

    @Before
    public void setUpStreams() throws IOException {
        bibliotecaApp = new BibliotecaApp();
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
        bibliotecaApp.writeWelcomeMessage();
        assertEquals("* * * * W E L C O M E * * * *\n", outContent.toString());
    }

    @Test(timeout = 1000)
    public void shouldWaitOneThousandMiliseconds() throws InterruptedException {
        bibliotecaApp.waitOneThousandMiliseconds();
    }

    @Test
    public void shouldShowFirstOptionOfMenu() {
        bibliotecaApp.showMenu("1. List Books");
        assertEquals("1. List Books\n", outContent.toString());
    }
    @Test
    public void shouldShowSecondOptionOfMenu() {
        bibliotecaApp.showMenu("2. Exit");
        assertEquals("2. Exit\n", outContent.toString());
    }
    @Test
    public void shouldExitApplication() throws IOException {
        //option=Integer.parseInt(bibliotecaApp.getMenuOption());
        bibliotecaApp.execute(2);
        assertEquals("Finish!\n", outContent.toString());
    }
    @Test
    public void shouldValidateInvalidOption() throws IOException {
        //option=Integer.parseInt(bibliotecaApp.getMenuOption());
        bibliotecaApp.execute(2);
        assertEquals("Select a valid option!\n", outContent.toString());
    }
    @Test
    public void shouldExecuteFirstOption() throws IOException {
        bibliotecaApp.execute(1);
        assertEquals("Finish!\n", outContent.toString());
    }


}
