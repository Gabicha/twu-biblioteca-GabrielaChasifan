package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gchasifa on 5/11/15.
 */
public class TestBook {
    @Test
    public void validateNameOfBook(){
        Book book= new Book("Gaby",1987,1);
        assertTrue("GABY".equals(book.getName()));
    }
}
