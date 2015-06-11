package com.twu.biblioteca;

/**
 * Created by gchasifa on 6/10/15.
 */
public interface LibraryManager {
    public abstract void list();

    public abstract void checkOut(String name);

    public abstract void returnTo(String name);
}
