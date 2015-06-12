package com.twu.biblioteca;

/**
 * Created by gchasifa on 5/11/15.
 */
public class Book {
    private String name;
    private int year;
    private int status;
    private String userLibraryNumber;

    public Book(String name, int year,int status) {
        this.name=name.toUpperCase();
        this.year=year;
        this.status=status;
    }
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setUserLibraryNumber(String userLibraryNumber) {
        this.userLibraryNumber = userLibraryNumber;
    }
    public String getUserLibraryNumber() {
        return this.userLibraryNumber;
    }
}
