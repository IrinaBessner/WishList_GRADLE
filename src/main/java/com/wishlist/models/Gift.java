package com.wishlist.models;

import org.openqa.selenium.WebDriver;

public class Gift {

    public String link;
    public String name;
    public String price;
    public String currency;
    public String photoPath;
    public String linkImg;
    public String comment;

    public Gift(String link, String name, String price, String currency, String photoPath, String linkImg, String comment) {
        this.link = link;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.photoPath = photoPath;
        this.linkImg = linkImg;
        this.comment = comment;
    }

    public Gift(WebDriver driver) {

    }
}


