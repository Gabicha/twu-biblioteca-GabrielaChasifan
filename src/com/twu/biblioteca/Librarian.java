package com.twu.biblioteca;

import com.sun.tools.classfile.ConstantPool;

import java.io.*;
import java.util.*;

public class Librarian {
    private HashMap<String, Book> books = new HashMap<String, Book>();

    public Librarian() {
    }
    public Librarian(HashMap<String, Book> books) {
        this.books=books;
    }

    public void checkOut(String name){
            books.get(name).setStatus(0);
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public void setBooks(HashMap<String, Book> books) {
        this.books= books;
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

    public void RegisterUser(String libraryNumber,String bookName) {
        this.books.get(bookName).setUserLibraryNumber(libraryNumber);
    }

    public String getUser(String bookName) {
        Book userBook=findBook(bookName);
        return userBook.getUserLibraryNumber();
    }
}