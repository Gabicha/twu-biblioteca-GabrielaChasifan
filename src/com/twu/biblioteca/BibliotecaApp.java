package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BibliotecaApp {
    public Biblioteca biblioteca=new Biblioteca();

    public static void main(String[] args) throws IOException, InterruptedException {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.writeWelcomeMessage();
        bibliotecaApp.waitOneThousandMiliseconds();
        bibliotecaApp.biblioteca.loadBooks("libros.txt");
        while (true){
            bibliotecaApp.showMenu("1. List Books");
            bibliotecaApp.showMenu("2. CheckOut Books");
            bibliotecaApp.showMenu("3. Return Books");
            bibliotecaApp.showMenu("4. Exit");
            bibliotecaApp.showMenu("Choose an option...");
            String option=bibliotecaApp.inputUser();
            try{
                int intOption=Integer.parseInt(option);
                bibliotecaApp.execute(intOption);
            }catch(Exception e) {
                System.out.println("You can insert only numbers!!!");
            }
        }

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

    public boolean validateChoosenOption(String optionMenu) {

        return false;
    }

    public boolean receiveMenuOption() throws IOException {
        String option = inputUser();
        boolean validOption = false;
        if ("1".equals(option)) {
            validOption = true;
        }
        return validOption;
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
                biblioteca.listOnlyAvailableBooks();
                break;
            case 2:
                writeOption("Please enter the name of the book that you want to checkout....");
                String bookname=inputUser();
                try{
                    biblioteca.checkOut(bookname.toUpperCase());
                }catch(Exception e){
                    System.out.println("That book is not available");
                }
                break;
            case 3:
                writeOption("Please enter the name of the book that you want to return....");
                String retunrBookname=inputUser();
                try{
                    biblioteca.returnBook(retunrBookname.toUpperCase());
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

    public String getMenuOption() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}
