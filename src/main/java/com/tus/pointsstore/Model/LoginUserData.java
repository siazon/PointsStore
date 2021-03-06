package com.tus.pointsstore.Model;


/**
 * This class is created to hold the data provided in the request body,
 * when a user attempts to log in
 **/

public class LoginUserData {

    private String email;
    private String password;

    public LoginUserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
