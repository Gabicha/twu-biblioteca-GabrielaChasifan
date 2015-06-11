package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by gchasifa on 6/10/15.
 */
public class TestMovie {
    @Test
    public void shouldCreateAMovie(){
        String movieString="GREASE"+1978+"RANDAL KLEISER"+10;
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","10",1);
        assertTrue(movieString.equals(movie.getName()+movie.getYear()+movie.getDirector()+movie.getRating()));
    }
    @Test
    public void shouldValidateIfRatingIsTen(){
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","10",1);
        assertTrue("10".equals(movie.getRating()));
    }
    @Test
    public void shouldValidateIfRatingIsOne(){
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","1",1);
        assertTrue("1".equals(movie.getRating()));
    }
    @Test
    public void shouldValidateIfRatingIsBetweenOneAndTen() throws Exception {
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","10",1);
        assertTrue(movie.validateRating());
    }
    @Test
    public void shouldValidateUnrated() throws Exception {
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","UNRATED",1);
        assertTrue(movie.validateRating());
    }
    @Test(expected = Exception.class)
    public void shouldShowAnException() throws Exception {
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","11",1);
        movie.validateRating();
    }
    @Test
    public void shouldGetAvailableStatusOfTheBook(){
        Movie movie=new Movie("GREASE",1978,"RANDAL KLEISER","11",1);
        assertEquals(1,movie.getStatus());
    }
}
