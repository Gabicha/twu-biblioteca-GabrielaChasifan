package com.twu.biblioteca;

/**
 * Created by gchasifa on 5/11/15.
 */
public class Book {
    private String name;
    private int year;

    public Book(String name, int year) {
        name=name;
        year=year;
    }

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
}
