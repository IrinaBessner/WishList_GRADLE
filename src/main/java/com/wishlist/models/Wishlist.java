package com.wishlist.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public static List<WebElement> findElements(WebElement element) {
        return null;
    }
}
