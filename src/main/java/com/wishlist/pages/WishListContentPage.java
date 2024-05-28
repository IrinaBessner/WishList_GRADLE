package com.wishlist.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WishListContentPage extends BasePage {
    public WishListContentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

     @FindBy(xpath = "//button[.='OK']")
    // @FindBy(css = "button:nth-child(3)")
    //@FindBy(xpath = "//span[.='OK']")
    WebElement buttonOK;

    public WishListContentPage clickOnOKbutton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(buttonOK));
        click(buttonOK);
        return new WishListContentPage(driver);
    }

    // @FindBy(css = "button:nth-child(1)")
    // @FindBy(css = ".delete-wl-button")
    @FindBy(css = "[data-icon='delete']")
    WebElement basket;

    public WishListContentPage clickOnBasketToDelete() {
        click(basket);
        return new WishListContentPage(driver);
    }

    @FindBy(xpath = "//span[.='Share list']")
    WebElement share;

    public WishListContentPage verifyShare() {
        Assert.assertTrue(share.isDisplayed());
        return this;
    }

    @FindBy(css = "[data-icon='more']")
    WebElement dots;
    @FindBy(xpath = "//span[.='Delete']")
    WebElement choosedelete;

    public WishListContentPage chooseDelete() {
        click(dots);
        click(choosedelete);
//        choose.sendKeys(delete);
//        choose.sendKeys(Keys.ENTER);
        return new WishListContentPage(driver);
    }

    @FindBy(css = ".go-to-wishlists")
    WebElement linkGoToWishlists;

    public WishListContentPage clickOnGoToWishLists() {
        click(linkGoToWishlists);
        return new WishListContentPage(driver);
    }
}
