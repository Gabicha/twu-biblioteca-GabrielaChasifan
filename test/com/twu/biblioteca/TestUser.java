package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by gchasifa on 6/10/15.
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;
public class TestUser {
    public User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        user=new User("123-4567","GABRIELA","PASSWORD","GABRIELACHASIFAN@GMAIL.COM","0987375697");
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    @Test
    public void shouldCreateAUser(){

        String stringUser="123-4567"+"GABRIELA"+"PASSWORD"+"GABRIELACHASIFAN@GMAIL.COM"+"0987375697";
        assertEquals(stringUser,user.getLibraryNumber()+user.getName()+user.getPassword()+user.getMail()+user.getPhone());
    }
    @Test
    public void shouldValidateFormatLibraryNumber(){
        assertTrue(user.validateFormatLibraryNumber());
    }
    @Test
    public void shouldListUserInformation(){
        String userName = "NAME: GABRIELA\n";
        String userMail = "MAIL: GABRIELACHASIFAN@GMAIL.COM\n";
        String userPhone = "PHONE: 0987375697\n";
        String information = userName+userMail+userPhone;
        assertEquals(information,user.getUserInformation());
    }
}
