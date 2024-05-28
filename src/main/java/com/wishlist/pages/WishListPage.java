package com.wishlist.pages;

import com.wishlist.models.Wishlist;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WishListPage extends BasePage {

    public WishListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public

    @FindBy(id = "wishlist-name")
    WebElement name;
    @FindBy(id = "comment")
    WebElement comments;
    @FindBy(id = "event-date")
    WebElement eventdate;
    @FindBy(css = ".save-button-custom")
    WebElement savebutton;

    public WishListPage fillWishListForm(String title, String comment, String date ) {
        scrollToTopWithJS();
        type(name, title);
        type(comments, comment);
        click(eventdate);
        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);
        if (os.startsWith("Mac")) {
            eventdate.sendKeys(Keys.COMMAND, "a");
        } else {
            eventdate.sendKeys(Keys.CONTROL, "a");
        }
        eventdate.sendKeys(date);
        eventdate.sendKeys(Keys.ENTER);
              return new WishListPage(driver);
    }
    public WishListPage fillWishListForm(Wishlist wishlist) {
        scrollToTopWithJS();
        type(name, wishlist.title);
        type(comments, wishlist.comment);
        click(eventdate);
        String os = System.getProperty("os.name");
        System.out.println("My OS is " + os);
        if (os.startsWith("Mac")) {
            eventdate.sendKeys(Keys.COMMAND, "a");
        } else {
            eventdate.sendKeys(Keys.CONTROL, "a");
        }
        eventdate.sendKeys(wishlist.eventDate);
        eventdate.sendKeys(Keys.ENTER);
        return new WishListPage(driver);
    }

    public WishListPage clickSaveButton() {
        click(savebutton);
        return new WishListPage(driver);
    }
}
