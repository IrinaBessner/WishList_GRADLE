package com.wishlist.models;

import org.openqa.selenium.WebDriver;

public class Wishlist {

    public String title;
    public String comment;
    public String eventDate;

    public Wishlist(String title, String comment, String eventDate) {
        this.title = title;
        this.comment = comment;
        this.eventDate = eventDate;
    }

    public Wishlist (WebDriver driver) {

    }
}
