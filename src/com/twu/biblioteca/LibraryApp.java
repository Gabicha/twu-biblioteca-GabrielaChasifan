package com.twu.biblioteca;

import java.io.*;

public class LibraryApp {
    private Librarian librarian;
    public static void main(String[] args) throws IOException, InterruptedException {
        LibraryApp libraryApp = new LibraryApp();
        libraryApp.writeWelcomeMessage();
        libraryApp.waitOneThousandMiliseconds();
        libraryApp.loadVariables();

        while (true){
            libraryApp.showMenu("1. List Books");
            libraryApp.showMenu("2. CheckOut Books");
            libraryApp.showMenu("3. Return Books");
            libraryApp.showMenu("4. Exit");
            libraryApp.showMenu("Choose an option...");
            String option= libraryApp.inputUser();
            try{
                int intOption=Integer.parseInt(option);
                libraryApp.execute(intOption);
            }catch(Exception e) {
                System.out.println("You can only insert numbers!!!");
            }
        }

    }
    public void loadVariables() throws IOException {
        BookLoader bookLoader = new BookLoader();
        bookLoader.load("libros.txt");
        librarian =new Librarian(bookLoader.getBooks());
    }
    public void writeWelcomeMessage() {
        writeOption("* * * * W E L C O M E * * * *");
    }

    public void waitOneThousandMiliseconds() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void showMenu(String menuOption) {
        writeOption(menuOption);
    }

    private String inputUser() throws IOException {
        BufferedReader is2 = new BufferedReader(new InputStreamReader(System.in));
        return is2.readLine();
    }

    private void writeOption(String text) {
        System.out.println(text);
    }

    public void execute(int option) throws IOException {
        switch (option) {
            case 1:
                librarian.listOnlyAvailableBooks();
                break;
            case 2:
                writeOption("Please enter the name of the book that you want to checkout....");
                String bookname=inputUser();
                try{
                    librarian.checkOut(bookname.toUpperCase());
                }catch(Exception e){
                    System.out.println("That book is not available");
                }
                break;
            case 3:
                writeOption("Please enter the name of the book that you want to return....");
                String retunrBookname=inputUser();
                try{
                    librarian.returnBook(retunrBookname.toUpperCase());
                }catch(Exception e){
                    System.out.println("That book is not available");
                }
                break;
            case 4:
                writeOption("Finish!");
                System.exit(0);
                break;
            default:
                writeOption("Select a valid option!");
                break;
        }
    }
}
