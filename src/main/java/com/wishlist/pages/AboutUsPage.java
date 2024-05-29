package com.wishlist.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AboutUsPage extends BasePage{

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".paragraph-first")
    WebElement result;
    public AboutUsPage verifyAboutUs(String text) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }
}
