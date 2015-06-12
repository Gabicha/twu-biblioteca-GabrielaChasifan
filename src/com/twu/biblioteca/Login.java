package com.twu.biblioteca;

/**
 * Created by gchasifa on 6/11/15.
 */
public class Login {

    public String getUserLibraryNumber() {
        return userLibraryNumber;
    }

    public String getPassword() {
        return Password;
    }

    private String userLibraryNumber;
    private String Password;

    public User[] getUserAccounts() {
        return userAccounts;
    }

    private User[] userAccounts={new User("123-4567","GABRIELA","PASSWORD","GABRIELACHASIFAN@GMAIL.COM","0987375697"),
            new User("222-2222","2","2","2@GMAIL.COM","2222222222")};

    public Login(String userLibraryNumber,String Password){
        this.userLibraryNumber = userLibraryNumber;
        this.Password = Password;
    }
    public boolean verifyPassword(){
        for (User user:userAccounts) {
            if((user.getLibraryNumber().compareTo(userLibraryNumber)==0)&&(user.getPassword().compareTo(Password)==0)){
                return true;
            }
        }
        return false;
    }
}