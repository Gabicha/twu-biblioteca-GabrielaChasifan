package com.twu.biblioteca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gchasifa on 6/10/15.
 */
public class User {
    private String userInformation;

    public String getLibraryNumber() {
        return libraryNumber;
    }

    String libraryNumber;

    public String getName() {
        return name;
    }

    String name;

    public String getPassword() {
        return password;
    }

    String password;

    public String getMail() {
        return mail;
    }

    String mail;

    public String getPhone() {
        return phone;
    }

    String phone;

    public User(String libraryNumber, String name, String password, String mail, String phone) {
        this.libraryNumber = libraryNumber;
        this.name=name;
        this.password=password;
        this.mail=mail;
        this.phone=phone;
    }

    public boolean validateFormatLibraryNumber() {
        String stringPattern = "^(\\w{3}-\\w{4})$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(libraryNumber);
        return matcher.find();
    }

    public String getUserInformation() {
        String userName = "NAME: "+name+ "\n";
        String userMail = "MAIL: "+mail+"\n";
        String userPhone = "PHONE: "+phone +"\n";
        
        return userName+userMail+userPhone;
    }
}
