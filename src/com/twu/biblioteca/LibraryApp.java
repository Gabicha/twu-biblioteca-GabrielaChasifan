package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class LibraryApp {
    private Librarian librarian;
    private MovieManager movieManager;

    public String getCurrentUser() {
        return currentUser;
    }

    private String currentUser;

    public static void main(String[] args) throws IOException, InterruptedException {

        LibraryApp libraryApp = new LibraryApp();
        libraryApp.writeWelcomeMessage();
        libraryApp.waitMiliseconds(500);
        libraryApp.loadVariables();

        while (true) {
            createMenu(libraryApp, null);
            String option = libraryApp.inputUser();
            try {
                int intOption = Integer.parseInt(option);
                libraryApp.execute(intOption);
            } catch (Exception e) {
                System.out.println("You can only insert numbers!!!");
            }
        }

    }

    private static void createMenu(LibraryApp libraryApp, String currentUser) {
        if (currentUser == null) {
            libraryApp.showMenu("1. List Books");
            libraryApp.showMenu("2. List Movies");
            libraryApp.showMenu("3. CheckOut Books");
            libraryApp.showMenu("4. Return Books");
            libraryApp.showMenu("5. CheckOut Movies");
            libraryApp.showMenu("6. Return Movies");
            libraryApp.showMenu("0. Exit");
            libraryApp.showMenu("Choose an option...");

        } else {
            libraryApp.showMenu("1. List Books");
            libraryApp.showMenu("2. List Movies");
            libraryApp.showMenu("3. CheckOut Books");
            libraryApp.showMenu("4. Return Books");
            libraryApp.showMenu("5. CheckOut Movies");
            libraryApp.showMenu("6. Return Movies");
            libraryApp.showMenu("7. Show User Information");
            libraryApp.showMenu("0. Exit");
            libraryApp.showMenu("Choose an option...");
        }

    }

    public void loadVariables() throws IOException {
        BookLoader bookLoader = new BookLoader();
        bookLoader.load("libros.txt");
        librarian = new Librarian(bookLoader.getBooks());
        MovieLoader movieLoader=new MovieLoader();
        movieLoader.load("movies.txt");
        movieManager= new MovieManager();
        movieManager.setMovies(movieLoader.getMovies());
    }

    public void writeWelcomeMessage() {
        writeOption("* * * * W E L C O M E * * * *");
    }

    public void waitMiliseconds(Integer time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void showMenu(String menuOption) {
        writeOption(menuOption);
    }

    private String inputUser() throws IOException {
        BufferedReader is2 = new BufferedReader(new InputStreamReader(System.in));
        return is2.
                readLine();
    }

    private void writeOption(String text) {
        System.out.println(text);
    }

    public void execute(int option) throws Exception {
        validateOption(option);
        switch (option) {
            case 1:
                librarian.listOnlyAvailableBooks();
                break;
            case 2:
                movieManager.list();
                break;
            case 3:
                writeOption("Please enter the name of the book that you want to checkout....");
                String bookname = inputUser();
                try {
                    librarian.checkOut(bookname.toUpperCase());
                } catch (Exception e) {
                    System.out.println("That book is not available");
                }
                break;
            case 4:
                writeOption("Please enter the name of the book that you want to return....");
                String returnBookName = inputUser();
                try {
                    librarian.returnBook(returnBookName.toUpperCase());
                } catch (Exception e) {
                    System.out.println("That book is not available");
                }
                break;
            case 5:
                writeOption("Please enter the name of the movie that you want to checkout....");
                String movieName = inputUser();
                try {
                    movieManager.checkOut(movieName.toUpperCase());
                } catch (Exception e) {
                    System.out.println("That movie is not available");
                }
                break;
            case 6:
                writeOption("Please enter the name of the movie that you want to return....");
                String returnMovieName = inputUser();
                try {
                    movieManager.returnTo(returnMovieName.toUpperCase());
                } catch (Exception e) {
                    System.out.println("That movie is not available");
                }
                break;
            case 0:
                writeOption("Finish!");
                System.exit(0);
                break;
            default:
                writeOption("Select a valid option!");
                break;
        }
    }

    public void validateOption(int option) throws Exception {
        if (((option > 3 || option == 3) && (option < 7 || option == 7))) {
            if (currentUser == null) {
                forceLogin();
            }
        }
    }

    private void forceLogin() throws IOException, InterruptedException {
        boolean response = false;
        String libraryNumber = null;
        while (!response) {
            writeOption("Please Insert your Library number");
            libraryNumber = inputUser();
            writeOption("Please insert your Password");
            String password = inputUser();
            Login login = new Login(libraryNumber, password);
            response = login.verifyPassword();
            if (!response) {
                writeOption("Please check Library number and Password...");
            } else {
                writeOption("Login Sucessfull!!!");
                waitMiliseconds(500);
                clearConsole();
            }
        }
        currentUser = libraryNumber;
    }

    private void clearConsole() {
        for (int i = 0; i < 15; i++) {
            writeOption("");
        }
    }
}
