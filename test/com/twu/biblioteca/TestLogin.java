package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by gchasifa on 6/11/15.
 */
public class TestLogin {
    @Test
    public void shouldVerifyPassword(){
        String userLibraryNumber="123-4567";
        String password="********";
        Login login=new Login(userLibraryNumber,password);
        assertTrue(login.verifyPassword());
    }
}
