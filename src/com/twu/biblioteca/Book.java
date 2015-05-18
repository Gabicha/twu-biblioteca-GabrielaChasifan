package com.twu.biblioteca;

/**
 * Created by gchasifa on 5/11/15.
 */
public class Book {
    private String name;
    private int year;
    private int status;

    public Book(String name, int year,int status) {
        this.name=name.toUpperCase();
        this.year=year;
        this.status=status;
    }
    public Book() {}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
