package com.wishlist.models;

import org.openqa.selenium.WebDriver;

public class User {
    public String name;
    public String secondName;
    public String email;
    public String password;
    public String confirmPass;

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String secondName, String email, String password, String confirmPass) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.confirmPass = password;

    }

    public User(WebDriver driver) {

    }

    public String takeScreenshot() {
        return null;
    }
}



